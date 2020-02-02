package faeriefolk.client.renderer;

import faeriefolk.FaerieFolk;
import faeriefolk.client.model.GoblinModel;
import faeriefolk.common.entities.creature.GoblinEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class GoblinRenderer extends MobRenderer<GoblinEntity, GoblinModel<GoblinEntity>>
{
	public GoblinRenderer(EntityRendererManager managerIn)
	{
		super(managerIn, new GoblinModel<>(), 0.5F);
	}

	public ResourceLocation getEntityTexture(GoblinEntity entity)
	{
		return FaerieFolk.resourceLocaton("textures/entities/goblin/default.png");
	}
	
	public static class GoblinRendererFactory implements IRenderFactory<GoblinEntity>
	{
		public static final GoblinRendererFactory INSTANCE = new GoblinRendererFactory();
		
		public EntityRenderer<? super GoblinEntity> createRenderFor(EntityRendererManager manager)
		{
			return new GoblinRenderer(manager);
		}
	}
}
