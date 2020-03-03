package merrple.faeriefolk.common.items;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import merrple.faeriefolk.client.Group;
import merrple.faeriefolk.common.Faeriefolk;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Rarity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

public final class SpawnerItem extends SpawnEggItem {
	protected final Supplier<EntityType<?>> supplier;
	
	public SpawnerItem(Supplier<EntityType<?>> supplierIn, String hex1, String hex2) {
		super(null, Faeriefolk.Util.hex16(hex1), Faeriefolk.Util.hex16(hex2), new Properties().rarity(Rarity.UNCOMMON).group(Group.FAERIE_FOLK));
		this.supplier = supplierIn;
	}
	
	@Nullable
	public EntityType<?> getType(@Nullable CompoundNBT compound) {
		EntityType<?> typeIn = this.supplier.get();
		return compound != null ? EntityType.byKey(compound.getCompound("EntityTag").getString("id")).orElse(typeIn) : typeIn;
	}
}
