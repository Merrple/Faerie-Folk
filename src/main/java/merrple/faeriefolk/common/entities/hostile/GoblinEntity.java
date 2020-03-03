package merrple.faeriefolk.common.entities.hostile;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import merrple.faeriefolk.common.entities.IFaeriefolkEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GoblinEntity extends CreatureEntity implements IFaeriefolkEntity {
	private static final DataParameter<Optional<UUID>> TRIBE_LEADER = EntityDataManager.createKey(GoblinEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	private static final DataParameter<Float> TRIBE_LEADER_REP = EntityDataManager.createKey(GoblinEntity.class, DataSerializers.FLOAT);
	
	public GoblinEntity(EntityType<? extends GoblinEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(TRIBE_LEADER, Optional.empty());
		this.dataManager.register(TRIBE_LEADER_REP, 0.0F);
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FollowTribeLeaderGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
	}
	
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		if (this.getTribeLeaderUUID() != null) compound.putUniqueId("TribeLeaderUUID", this.getTribeLeaderUUID());
		compound.putFloat("TribeLeaderRep", this.getTribeLeaderRep());
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		World worldIn = this.world;
		if (compound.contains("TribeLeaderUUID")) this.setTribeLeaderUUID(worldIn, compound.getUniqueId("TribeLeaderUUID"));
		this.setTribeLeaderRep(worldIn, compound.getFloat("TribeLeaderRep"));
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
		World worldIn = player.world;
		if (!worldIn.isRemote) {
			ServerWorld serverIn = ((ServerWorld)worldIn);
			LivingEntity leader = this.getTribeLeader(serverIn);
			
			if (leader == null) {
				this.updateTribeIn(serverIn, player);
			} else if (leader == player) {
				 this.updateTribeLeaderRep(serverIn, this.getTribeLeaderRep() - 0.4F); // debug
			}
			
		}
		return true;
	}
	
	protected void updateTribeLeaderRep(ServerWorld worldIn, float value) {
		if (this.setTribeLeaderRep(worldIn, value)) {
		} else this.updateTribeIn(worldIn, null);
	}
	
	protected void updateTribeIn(ServerWorld serverIn, LivingEntity newLeader) {
		String text = "entity.faeriefolk.goblin.tribe.leave";
		LivingEntity leader = this.getTribeLeader(serverIn);
		
		if (newLeader != null && this.setTribeLeaderUUID(serverIn, newLeader.getUniqueID())) {
			text = "entity.faeriefolk.goblin.tribe.join";
			leader = this.getTribeLeader(serverIn);
			
			if (leader instanceof PlayerEntity) {
				this.setCustomName(new TranslationTextComponent("entity.faeriefolk.goblin.name" + this.rand.nextInt(10)));
				this.setTribeLeaderRep(serverIn, 1.0F);
			}
		} else if (!this.setTribeLeaderUUID(serverIn, null)) {
		}
		
		if (leader != null) {
			String message = new TranslationTextComponent(text).getFormattedText();
			leader.sendMessage(new StringTextComponent(this.getName().getFormattedText() + message));
		}
	}
	
	@Nullable
	protected LivingEntity getTribeLeader(ServerWorld serverIn) {
		UUID uuid = this.getTribeLeaderUUID();
		return uuid != null ? serverIn.getPlayerByUuid(uuid) : null;
	}
	
	@Nullable
	private UUID getTribeLeaderUUID() {
		try {
			return this.dataManager.get(TRIBE_LEADER).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private boolean setTribeLeaderUUID(World worldIn, @Nullable UUID value) {
		try {
			if (!worldIn.isRemote) this.dataManager.set(TRIBE_LEADER, Optional.ofNullable(value));
			return true && value != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	
	private boolean setTribeLeaderRep(World worldIn, float value) {
		try {
			if (!worldIn.isRemote) this.dataManager.set(TRIBE_LEADER_REP, value);
			return true && !(value <= 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private final class FollowTribeLeaderGoal extends RandomWalkingGoal {
		private final GoblinEntity goalOwner;
		
		public FollowTribeLeaderGoal(GoblinEntity goblinIn, double speedIn) {
			super(goblinIn, speedIn);
			this.goalOwner = goblinIn;
		}
		
		@Nullable
		protected Vec3d getPosition() {
			World worldIn = this.goalOwner.world;
			if (!worldIn.isRemote) {
				LivingEntity leader = this.goalOwner.getTribeLeader(((ServerWorld)worldIn));
				if (leader != null) return RandomPositionGenerator.findRandomTargetBlockTowards(this.creature, 10, 7, leader.getPositionVec());
			}
			return null;
		}
	}
}
