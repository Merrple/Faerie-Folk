package merrple.faeriefolk.client.renderers.entities;

import merrple.faeriefolk.client.renderers.entities.models.GoblinEntityModel;
import merrple.faeriefolk.common.Faeriefolk;
import merrple.faeriefolk.common.entities.hostile.GoblinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class GoblinEntityRenderer extends MobRenderer<GoblinEntity, GoblinEntityModel<GoblinEntity>> {
	
	public GoblinEntityRenderer(EntityRendererManager p_i50961_1_) {
		super(p_i50961_1_, new GoblinEntityModel<>(), 0.4F);
		this.addLayer(new HeldItemLayer<>(this));
	}
	
	public ResourceLocation getEntityTexture(GoblinEntity entity) {
		return new ResourceLocation(Faeriefolk.MODID, "textures/entities/goblin/default.png");
	}
}
