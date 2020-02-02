package faeriefolk.common.entities.ai.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;

public class AltLeapAtTargetGoal extends LeapAtTargetGoal
{
	protected final MobEntity goalOwner;
	
	public AltLeapAtTargetGoal(MobEntity leapingEntity, float leapMotionYIn)
	{
		super(leapingEntity, leapMotionYIn);
		this.goalOwner = leapingEntity;
	}
	
	public boolean shouldExecute()
	{
		LivingEntity target = this.goalOwner.getAttackTarget();
		return super.shouldExecute() && this.goalOwner.isAlive() && target != null && target.isAlive();
	}
}
