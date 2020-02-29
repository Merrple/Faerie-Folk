package merrple.faeriefolk.common.items;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import merrple.faeriefolk.common.Faeriefolk;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Rarity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

public class SpawnerItem extends SpawnEggItem {
	protected final Supplier<EntityType<?>> supplier;
	
	public SpawnerItem(Supplier<EntityType<?>> supplierIn, String hex1, String hex2, Properties builder) {
		super(null, Faeriefolk.Util.hex16(hex1), Faeriefolk.Util.hex16(hex2), builder.rarity(Rarity.UNCOMMON));
		this.supplier = supplierIn;
	}
	
	@Nullable
	public EntityType<?> getType(@Nullable CompoundNBT compound) {
		EntityType<?> typeIn = this.supplier.get();
		return compound!= null ? EntityType.byKey(compound.getCompound("EntityTag").getString("id")).orElse(typeIn) : typeIn;
	}
}
