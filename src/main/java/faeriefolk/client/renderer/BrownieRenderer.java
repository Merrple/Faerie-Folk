package faeriefolk.client.renderer;

import faeriefolk.FaerieFolk;
import faeriefolk.client.model.GoblinModel;
import faeriefolk.common.entities.creature.BrownieEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BrownieRenderer extends MobRenderer<BrownieEntity, GoblinModel<BrownieEntity>>
{
	public BrownieRenderer(EntityRendererManager managerIn)
	{
		super(managerIn, new GoblinModel<>(), 0.5F);
	}

	public ResourceLocation getEntityTexture(BrownieEntity entity)
	{
		return FaerieFolk.resourceLocaton("textures/entities/brownie/default.png");
	}
	
	public static class BrownieRendererFactory implements IRenderFactory<BrownieEntity>
	{
		public static final BrownieRendererFactory INSTANCE = new BrownieRendererFactory();
		
		public EntityRenderer<? super BrownieEntity> createRenderFor(EntityRendererManager manager)
		{
			return new BrownieRenderer(manager);
		}
	}
}
