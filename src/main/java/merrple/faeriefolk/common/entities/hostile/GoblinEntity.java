package merrple.faeriefolk.common.entities.hostile;

import merrple.faeriefolk.common.entities.IFaeriefolkEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class GoblinEntity extends CreatureEntity implements IMob, IFaeriefolkEntity {
	public GoblinEntity(EntityType<? extends GoblinEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
	}
}
