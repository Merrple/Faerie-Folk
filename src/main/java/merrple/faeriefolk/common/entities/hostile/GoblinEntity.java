package merrple.faeriefolk.common.entities.hostile;

import merrple.faeriefolk.common.entities.IFaeriefolkEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GoblinEntity extends TameableEntity implements IFaeriefolkEntity {
	private static final DataParameter<Float> TRIBE_LEADER_REP = EntityDataManager.createKey(GoblinEntity.class, DataSerializers.FLOAT);
	
	public GoblinEntity(EntityType<? extends GoblinEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(TRIBE_LEADER_REP, 0.0F);
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
	}
	
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putFloat("TribeLeaderRep", this.getTribeLeaderRep());
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setTribeLeaderRep(compound.getFloat("TribeLeaderRep"));
	}
	
	public boolean attackEntityFrom(DamageSource source, float amount) {
		World worldIn = this.world;
		Entity attackingEntity = source.getTrueSource();
		
		if (!worldIn.isRemote && attackingEntity != null && attackingEntity instanceof LivingEntity) {
			if (((LivingEntity)attackingEntity) == this.getOwner()) {
				this.updateTribeLeaderRep(((ServerWorld)worldIn), this.getTribeLeaderRep() - amount * 0.35F);
			}
		}
		
		return super.attackEntityFrom(source, amount);
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
		World worldIn = player.world;
		
		if (!worldIn.isRemote) {
			LivingEntity leader = this.getOwner();
			
			//debugging
			if (leader == null) {
				this.joinTribe(player);
			} else if (leader == player) {
				Hand goblinHand = this.getActiveHand();
				
				if (goblinHand != null) {
					ItemStack goblinStack = this.getHeldItem(goblinHand);
					ItemStack playerStack = player.getHeldItem(hand);
					
					boolean flag = playerStack.isEmpty();
					if (goblinStack.isEmpty() && !flag) {
						
						this.setHeldItem(goblinHand, new ItemStack(playerStack.getItem()));
						playerStack.shrink(1);
					} else if (flag) {
						
						player.setHeldItem(hand, new ItemStack(goblinStack.getItem()));
						goblinStack.shrink(1);
					}
				}
			}
			
		}
		return true;
	}
	
	protected void updateTribeLeaderRep(ServerWorld serverIn, float value) {
		if (value > 0.0F) {
			this.setTribeLeaderRep(value);
		} else this.joinTribe(null);
	}
	
	private void joinTribe(LivingEntity entityToJoin) {
		String text = "entity.faeriefolk.goblin.tribe.leave";
		LivingEntity leader = this.getOwner();
		
		if (entityToJoin == null) {
			this.setOwnerId(null);
		}else {
			this.setOwnerId(entityToJoin.getUniqueID());
			leader = entityToJoin;
			if (entityToJoin instanceof PlayerEntity) {
				this.setCustomName(new TranslationTextComponent("entity.faeriefolk.goblin.name" + this.rand.nextInt(10)));
			}
			text = "entity.faeriefolk.goblin.tribe.join";
		}
		
		if (leader != null) {
			String message = new TranslationTextComponent(text).getFormattedText();
			leader.sendMessage(new StringTextComponent(this.getName().getFormattedText() + message));
		}
	}
	
	private float getTribeLeaderRep() {
		try {
			return this.dataManager.get(TRIBE_LEADER_REP);
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0F;
		}
	}
	
	private void setTribeLeaderRep(float value) {
		try {
			this.dataManager.set(TRIBE_LEADER_REP, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
