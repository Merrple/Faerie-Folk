package faeriefolk.common.entities.creature;

import faeriefolk.common.entities.IFaerieEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class BrownieEntity extends CreatureEntity implements IFaerieEntity
{
	public BrownieEntity(EntityType<? extends BrownieEntity> type, World worldIn)
	{
		super(type, worldIn);
	}
}
