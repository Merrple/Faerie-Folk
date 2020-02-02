package faeriefolk.common.items;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

public class SpawnerItem extends SpawnEggItem
{
	private final Supplier<EntityType<?>> supplier;
	
	public SpawnerItem(Supplier<EntityType<?>> supplierTypeIn, String primaryColorIn, String secondaryColorIn)
	{
		super(null, Integer.parseInt(primaryColorIn, 16), Integer.parseInt(secondaryColorIn, 16), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
		this.supplier = supplierTypeIn;
	}
	
	public EntityType<?> getType(@Nullable CompoundNBT compound)
	{
		return supplier.get();
	}
}
