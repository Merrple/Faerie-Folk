package faeriefolk.common.entities.creature;

import faeriefolk.common.entities.ai.goals.AltLeapAtTargetGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class GoblinEntity extends CreatureEntity
{
	public GoblinEntity(EntityType<? extends GoblinEntity> type, World worldIn)
	{
		super(type, worldIn);
	}
	
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new AltLeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, LivingEntity.class, 8.0F));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, 5, false, false, (targetAnimalEntity) -> this.isTargetSmall(targetAnimalEntity)));
	}
	
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.35F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}
	
	public void tick()
	{
		super.tick();
		if (!this.world.isRemote && this.isPeaceful() && this.getAttackTarget() != null)
		{
			this.setAttackTarget(null);
		}
	}
	
	public boolean canAttack(LivingEntity targetLivingEntity)
	{
		return super.canAttack(targetLivingEntity) && !this.isPeaceful();
	}
	
	private boolean isPeaceful()
	{
		return this.world.getDifficulty() == Difficulty.PEACEFUL;
	}
	
	private boolean isTargetSmall(LivingEntity targetLivingEntity)
	{
		return 1.0F * (targetLivingEntity.getHeight() * targetLivingEntity.getWidth()) < 1.0F * (this.getHeight() * this.getWidth());
	}
}
