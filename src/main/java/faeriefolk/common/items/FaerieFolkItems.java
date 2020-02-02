package faeriefolk.common.items;

import faeriefolk.FaerieFolk;
import faeriefolk.common.entities.FaerieFolkEntityTypes;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class FaerieFolkItems
{
	private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, FaerieFolk.MODID);
	
	public static final RegistryObject<Item> SPAWNER_GOBLIN = ITEMS.register("spawner_goblin", () -> new SpawnerItem(() -> FaerieFolkEntityTypes.GOBLIN.get(), "858CDB", "746EC9"));
	
	public static DeferredRegister<Item> getRegistry()
	{
		return ITEMS;
	}
}
