package merrple.faeriefolk.common;

import merrple.faeriefolk.common.items.EncyclopediaItem;
import merrple.faeriefolk.common.items.SpawnerItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class FaeriefolkItems {
	protected static final DeferredRegister<Item> DEFERRED_REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Faeriefolk.MODID);
	
	public static RegistryObject<EncyclopediaItem> ENCYCLOPEDIA = create("encyclopedia", new EncyclopediaItem());
	
	public static RegistryObject<SpawnerItem> SPAWNEGG_GOBLIN = create("spawnegg_goblin", new SpawnerItem(() -> FaeriefolkEntityTypes.GOBLIN.get(), "D34F2A", "F4ECEB"));
	
	private static <T extends Item> RegistryObject<T> create(String idIn, T itemIn) {
		return DEFERRED_REGISTRY.register(idIn, () -> itemIn);
	}
}
