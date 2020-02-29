package merrple.faeriefolk.client.renderers.entities.models;

import com.google.common.collect.ImmutableSet;
import com.mojang.blaze3d.matrix.MatrixStack;

import merrple.faeriefolk.common.entities.hostile.GoblinEntity;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoblinEntityModel<T extends GoblinEntity> extends SegmentedModel<T> implements IEntityModel, IHasArm {
	private final ModelRenderer torso;
	private final ModelRenderer torsoUpper;
	private final ModelRenderer head;
	private final ModelRenderer mouth;
	private final ModelRenderer teeth;
	private final ModelRenderer nose;
	private final ModelRenderer leftEye;
	private final ModelRenderer rightEye;
	private final ModelRenderer leftEar;
	private final ModelRenderer rightEar;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArmUpper;
	private final ModelRenderer rightArmLower;
	private final ModelRenderer rightArmHand;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArmUpper;
	private final ModelRenderer leftArmLower;
	private final ModelRenderer leftArmHand;
	private final ModelRenderer rightLeg;
	private final ModelRenderer rightLegUpper;
	private final ModelRenderer rightLegLower;
	private final ModelRenderer rightLegFoot;
	private final ModelRenderer leftLeg;
	private final ModelRenderer leftLegUpper;
	private final ModelRenderer leftLegLower;
	private final ModelRenderer leftLegFoot;

	public GoblinEntityModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.torso = this.placeholderName(new ModelRenderer(this, 0, 0), -4.5F, -7.0F, -3.0F, 9, 7, 7, 0.0F);
		this.torso.setRotationPoint(0.0F, 19.0F, 1.0F);
		
		this.torsoUpper = this.placeholderName(new ModelRenderer(this, 21, 21), -3.5F, -5.0F, -2.5F, 8, 3, 7, 0.0F);
		this.torsoUpper.setRotationPoint(-0.5F, -3.5F, 0.0F);
		this.setRotationAngle(torsoUpper, 0.2618F, 0.0F, 0.0F);
		this.torso.addChild(torsoUpper);
		
		this.head = this.placeholderName(new ModelRenderer(this, 0, 14), -3.5F, -4.0F, -3.5F, 7, 6, 7, 0.0F);
		this.head.setRotationPoint(0.5F, -5.0F, 0.5F);
		this.torsoUpper.addChild(head);
		
		this.mouth = this.placeholderName(new ModelRenderer(this, 0, 27), -3.0F, 0.0F, -4.0F, 6, 8, 4, 0.0F);
		this.mouth.setRotationPoint(0.0F, -1.0F, -1.5F);
		this.head.addChild(mouth);
		
		this.teeth = this.placeholderName(new ModelRenderer(this, 16, 27), -3.0F, -2.0F, -2.0F, 6, 1, 0, 0.0F);
		this.teeth.setRotationPoint(0.0F, 1.0F, -0.5F);
		this.mouth.addChild(teeth);
		
		this.nose = this.placeholderName(new ModelRenderer(this, 44, 18), -1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.nose.setRotationPoint(0.0F, -2.0F, -4.0F);
		this.setRotationAngle(nose, -0.9599F, 0.0F, 0.0F);
		this.head.addChild(nose);
		
		this.leftEye = this.placeholderName(new ModelRenderer(this, 0, 2), 0.0F, -0.5F, 0.0F, 1, 1, 1, 0.2F);
		this.leftEye.setRotationPoint(-3.5F, -2.5F, -3.5F);
		this.setRotationAngle(leftEye, 0.0F, 0.5236F, 0.0873F);
		this.head.addChild(leftEye);
		
		this.rightEye = this.placeholderName(new ModelRenderer(this, 0, 0), -1.0F, -0.5F, 0.0F, 1, 1, 1, 0.2F);
		this.rightEye.setRotationPoint(3.5F, -2.5F, -3.5F);
		this.setRotationAngle(rightEye, 0.0F, -0.5236F, -0.0873F);
		this.head.addChild(rightEye);
		
		this.leftEar = this.placeholderName(new ModelRenderer(this, 41, 42), -6.0F, -2.0F, 0.0F, 6, 3, 0, 0.0F);
		this.leftEar.setRotationPoint(-3.5F, -2.0F, 0.0F);
		this.setRotationAngle(leftEar, 0.5236F, 0.7854F, 0.5236F);
		this.head.addChild(leftEar);
		
		this.rightEar = this.placeholderName(new ModelRenderer(this, 40, 32), 0.0F, -2.0F, 0.0F, 6, 3, 0, 0.0F);
		this.rightEar.setRotationPoint(3.5F, -2.0F, 0.0F);
		this.setRotationAngle(rightEar, 0.5236F, -0.7854F, -0.5236F);
		this.head.addChild(rightEar);	
		
		this.rightArm = new ModelRenderer(this);
		this.rightArm.setRotationPoint(4.5F, -3.0F, 1.0F);
		this.torsoUpper.addChild(rightArm);
		
		this.rightArmUpper = this.placeholderName(new ModelRenderer(this, 16, 42), 0.0F, -1.0F, -1.5F, 4, 3, 3, 0.0F);
		this.rightArmUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngle(rightArmUpper, -0.0873F, 0.3491F, 0.5236F);
		this.rightArm.addChild(rightArmUpper);
		
		this.rightArmLower = this.placeholderName(new ModelRenderer(this, 27, 0), -1.0F, -1.0F, -1.5F, 6, 3, 3, -0.5F);
		this.rightArmLower.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.setRotationAngle(rightArmLower, 0.0F, 0.5236F, 0.7854F);
		this.rightArmUpper.addChild(rightArmLower);
		
		this.rightArmHand = this.placeholderName(new ModelRenderer(this, 21, 14), 3.0F, -1.0F, 0.0F, 4, 3, 0, 0.0F);
		this.rightArmHand.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightArmLower.addChild(rightArmHand);
		
		this.leftArm = new ModelRenderer(this);
		this.leftArm.setRotationPoint(-3.5F, -3.0F, 0.0F);
		this.torsoUpper.addChild(leftArm);
		
		this.leftArmUpper = this.placeholderName(new ModelRenderer(this, 30, 42), -4.0F, -1.0F, -1.5F, 4, 3, 3, 0.0F);
		this.leftArmUpper.setRotationPoint(0.0F, 0.0F, 1.0F);
		this.setRotationAngle(leftArmUpper, -0.0873F, -0.3491F, -0.5236F);
		this.leftArm.addChild(leftArmUpper);
		
		this.leftArmLower = this.placeholderName(new ModelRenderer(this, 36, 36), -5.0F, -1.0F, -1.5F, 6, 3, 3, -0.5F);
		this.leftArmLower.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.setRotationAngle(leftArmLower, 0.0F, -0.5236F, -0.7854F);
		this.leftArmUpper.addChild(leftArmLower);
		
		this.leftArmHand = this.placeholderName(new ModelRenderer(this, 12, 39), -7.0F, -1.0F, 0.0F, 4, 3, 0, 0.0F);
		this.leftArmHand.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftArmLower.addChild(leftArmHand);
		
		this.rightLeg = new ModelRenderer(this);
		this.rightLeg.setRotationPoint(3.0F, -1.5F, 0.0F);
		this.torso.addChild(rightLeg);
		
		this.rightLegUpper = this.placeholderName(new ModelRenderer(this, 0, 39), -2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
		this.rightLegUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngle(rightLegUpper, 0.3491F, -0.2618F, 0.0F);
		this.rightLeg.addChild(rightLegUpper);
		
		this.rightLegLower = this.placeholderName(new ModelRenderer(this, 30, 10), -2.0F, -1.5F, -2.0F, 4, 6, 4, -0.5F);
		this.rightLegLower.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngle(rightLegLower, -0.6109F, 0.0F, 0.0F);
		this.rightLegUpper.addChild(rightLegLower);
		
		this.rightLegFoot = this.placeholderName(new ModelRenderer(this, 17, 17), -2.0F, 0.0F, -4.0F, 4, 0, 4, 0.0F);
		this.rightLegFoot.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngle(rightLegFoot, 0.4363F, 0.0F, 0.0F);
		this.rightLegLower.addChild(rightLegFoot);
		
		this.leftLeg = new ModelRenderer(this);
		this.leftLeg.setRotationPoint(-3.0F, -1.5F, 0.0F);
		this.torso.addChild(leftLeg);
		
		this.leftLegUpper = this.placeholderName(new ModelRenderer(this, 41, 2), -2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
		this.leftLegUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngle(leftLegUpper, 0.3491F, 0.2618F, 0.0F);
		this.leftLeg.addChild(leftLegUpper);
		
		this.leftLegLower = this.placeholderName(new ModelRenderer(this, 20, 32), -2.0F, -1.5F, -2.0F, 4, 6, 4, -0.5F);
		this.setRotationAngle(leftLegLower, -0.6109F, 0.0F, 0.0F);
		this.leftLegLower.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.leftLegUpper.addChild(leftLegLower);
		
		this.leftLegFoot = this.placeholderName(new ModelRenderer(this, 28, 32), -2.0F, 0.0F, -4.0F, 4, 0, 4, 0.0F);
		this.leftLegFoot.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngle(leftLegFoot, 0.4363F, 0.0F, 0.0F);
		this.leftLegLower.addChild(leftLegFoot);
	}
	
	public Iterable<ModelRenderer> func_225601_a_() {
		return ImmutableSet.of(this.torso);
	}
	
	public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		this.head.rotateAngleY = MathHelper.clamp(p_225597_5_ * ((float)Math.PI / 180F), -0.4F, 0.4F);
		float f = MathHelper.clamp(p_225597_6_ * ((float)Math.PI / 180F), -0.2F, 0.3F);
	    this.head.rotateAngleX = -0.2618F + f;
	    this.mouth.rotateAngleX = 0.3491F - f;
	}
	
	public void func_225599_a_(HandSide p_225599_1_, MatrixStack p_225599_2_) {
		
		this.getArmForSide(p_225599_1_, p_225599_2_).func_228307_a_(p_225599_2_);
	}
	
	protected ModelRenderer getArmForSide(HandSide side, MatrixStack p_225599_2_) {
		boolean flag = side == HandSide.RIGHT;
		p_225599_2_.func_227861_a_(flag ? -0.65D : 0.6D, 0.85D, -0.15D);
		return flag ? this.rightArm : this.leftArm;
	}
}
