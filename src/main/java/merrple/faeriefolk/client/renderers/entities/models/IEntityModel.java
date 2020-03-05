package merrple.faeriefolk.client.renderers.entities.models;

import net.minecraft.client.renderer.model.ModelRenderer;

interface IEntityModel {
	
	public default ModelRenderer setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
		return modelRenderer;
	}
	
	public default ModelRenderer copyRotationAngle(ModelRenderer modelRenderer, ModelRenderer m) {
		return this.setRotationAngle(modelRenderer, m.rotateAngleX, m.rotateAngleY, m.rotateAngleZ);
	}
	
	public default ModelRenderer placeholderName(ModelRenderer modelRenderer, float posX, float posY, float posJ, float scaleX, float scaleY, float scaleJ, float scaleTot) {
		modelRenderer.func_228301_a_(posX, posY, posJ, scaleX, scaleY, scaleJ, scaleTot);
		return modelRenderer;
	}
}
