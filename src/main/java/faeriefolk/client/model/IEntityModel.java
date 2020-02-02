package faeriefolk.client.model;

import net.minecraft.client.renderer.model.ModelRenderer;

public interface IEntityModel
{
	public default void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public default void copyRotationAngles(ModelRenderer modelRendererA, ModelRenderer modelRendererB)
	{
		modelRendererA.rotateAngleX = modelRendererB.rotateAngleX;
		modelRendererA.rotateAngleY = modelRendererB.rotateAngleY;
		modelRendererA.rotateAngleZ = modelRendererB.rotateAngleZ;
	}
}
