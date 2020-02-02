package faeriefolk;

import faeriefolk.client.renderer.BrownieRenderer.BrownieRendererFactory;
import faeriefolk.client.renderer.GoblinRenderer.GoblinRendererFactory;
import faeriefolk.common.entities.FaerieFolkEntityTypes;
import faeriefolk.common.items.FaerieFolkItems;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(FaerieFolk.MODID)
public final class FaerieFolk
{
	public static final String MODID = "faerie_folk";
	
	public FaerieFolk()
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		FaerieFolkItems.getRegistry().register(bus);
		FaerieFolkEntityTypes.getRegistry().register(bus);
		
		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event)
	{
		for (Biome biome : ForgeRegistries.BIOMES)
		{
			if (biome == Biomes.FOREST || biome == Biomes.BIRCH_FOREST || biome == Biomes.BIRCH_FOREST_HILLS || biome == Biomes.DARK_FOREST || biome == Biomes.DARK_FOREST_HILLS || biome == Biomes.TALL_BIRCH_FOREST || biome == Biomes.TALL_BIRCH_HILLS || biome == Biomes.TAIGA || biome == Biomes.TAIGA_HILLS)
			{
				biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(FaerieFolkEntityTypes.GOBLIN.get(), 5, 6, 8));
			}
		}
	}
	
	private void clientSetup(final FMLClientSetupEvent event)
	{
		if (FMLEnvironment.dist.isDedicatedServer()) return;
		RenderingRegistry.registerEntityRenderingHandler(FaerieFolkEntityTypes.GOBLIN.get(), GoblinRendererFactory.INSTANCE);
		RenderingRegistry.registerEntityRenderingHandler(FaerieFolkEntityTypes.BROWNIE.get(), BrownieRendererFactory.INSTANCE);
	}
	
	public static ResourceLocation resourceLocaton(String location)
	{
		return new ResourceLocation(MODID, location);
	}
	
	@EventBusSubscriber(modid = FaerieFolk.MODID, bus = Bus.MOD)
	public static class EventHandler
	{
	}
}
