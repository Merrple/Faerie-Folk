package merrple.faeriefolk.common;

import merrple.faeriefolk.client.renderers.entities.factories.GoblinEntityRendererFactory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Faeriefolk.MODID)
public final class Faeriefolk {
	public static final String MODID = "faeriefolk";
	
	public Faeriefolk() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		FaeriefolkItems.DEFERRED_REGISTRY.register(bus);
		FaeriefolkEntityTypes.DEFERRED_REGISTRY.register(bus);
		bus.addListener(this::fmlClientSetupEvent);
	}
	
	private void fmlClientSetupEvent(final FMLClientSetupEvent event) {
		if (FMLEnvironment.dist.isClient()) {
			RenderingRegistry.registerEntityRenderingHandler(FaeriefolkEntityTypes.GOBLIN.get(), GoblinEntityRendererFactory.INSTANCE);
		}
	}
	
	public static class Util {
		
		public static int hex16(String hex) {
			return Integer.parseInt(hex, 16);
		}
	}
}
