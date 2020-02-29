package merrple.faeriefolk.client.renderers.entities.factories;

import merrple.faeriefolk.client.renderers.entities.GoblinEntityRenderer;
import merrple.faeriefolk.common.entities.hostile.GoblinEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public final class GoblinEntityRendererFactory implements IRenderFactory<GoblinEntity> {
	public static final GoblinEntityRendererFactory INSTANCE = new GoblinEntityRendererFactory();
	
	public EntityRenderer<? super GoblinEntity> createRenderFor(EntityRendererManager manager) {
		return new GoblinEntityRenderer(manager);
	}
}
