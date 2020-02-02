package faeriefolk.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoblinModel<T extends LivingEntity> extends BipedModel<T> implements IEntityModel
{
	private final ModelRenderer leftLeg;
	private final ModelRenderer lLJoint;
	private final ModelRenderer lLJointLower;
	private final ModelRenderer lLJointLowerFeet;
	private final ModelRenderer rightLeg;
	private final ModelRenderer rLJoint;
	private final ModelRenderer rLJointLower;
	private final ModelRenderer rLJointLowerFeet;
	private final ModelRenderer torso;
	private final ModelRenderer tLower;
	private final ModelRenderer tUpper;
	private final ModelRenderer leftArm;
	private final ModelRenderer lAJoint;
	private final ModelRenderer lALower;
	private final ModelRenderer hand0;
	private final ModelRenderer rightArm;
	private final ModelRenderer rAJoint;
	private final ModelRenderer rALower;
	private final ModelRenderer hand1;
	private final ModelRenderer head;
	private final ModelRenderer mouth;
	private final ModelRenderer teeth;
	private final ModelRenderer nose;
	private final ModelRenderer leftEye;
	private final ModelRenderer rightEye;
	private final ModelRenderer leftEar;
	private final ModelRenderer rightEar;
	
	public GoblinModel()
	{
		super(1.0F, 0.5F, 64, 64);
		
		this.leftLeg = new ModelRenderer(this);
		this.leftLeg.setRotationPoint(-3.0F, 17.5F, 0.0F);

		this.lLJoint = new ModelRenderer(this, 41, 2);
		this.lLJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngles(lLJoint, 0.3491F, 0.2618F, 0.0F);
		this.leftLeg.addChild(lLJoint);
		this.lLJoint.func_228301_a_(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);

		this.lLJointLower = new ModelRenderer(this, 20, 32);
		this.lLJointLower.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngles(lLJointLower, -0.6109F, 0.0F, 0.0F);
		this.lLJoint.addChild(lLJointLower);
		this.lLJointLower.func_228301_a_(-2.0F, -1.5F, -2.0F, 4, 6, 4, -0.5F);

		this.lLJointLowerFeet = new ModelRenderer(this, 28, 32);
		this.lLJointLowerFeet.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngles(lLJointLowerFeet, 0.4363F, 0.0F, 0.0F);
		this.lLJointLower.addChild(lLJointLowerFeet);
		this.lLJointLowerFeet.func_228301_a_(-2.0F, 0.0F, -4.0F, 4, 0, 4, 0.0F);

		this.rightLeg = new ModelRenderer(this);
		this.rightLeg.setRotationPoint(3.0F, 17.5F, 0.0F);

		this.rLJoint = new ModelRenderer(this, 0, 39);
		this.rLJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngles(rLJoint, 0.3491F, -0.2618F, 0.0F);
		this.rightLeg.addChild(rLJoint);
		this.rLJoint.func_228301_a_(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);

		this.rLJointLower = new ModelRenderer(this, 30, 10);
		this.rLJointLower.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngles(rLJointLower, -0.6109F, 0.0F, 0.0F);
		this.rLJoint.addChild(rLJointLower);
		this.rLJointLower.func_228301_a_(-2.0F, -1.5F, -2.0F, 4, 6, 4, -0.5F);

		this.rLJointLowerFeet = new ModelRenderer(this, 17, 17);
		this.rLJointLowerFeet.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.setRotationAngles(rLJointLowerFeet, 0.4363F, 0.0F, 0.0F);
		this.rLJointLower.addChild(rLJointLowerFeet);
		this.rLJointLowerFeet.func_228301_a_(-2.0F, 0.0F, -4.0F, 4, 0, 4, 0.0F);

		this.torso = new ModelRenderer(this);
		this.torso.setRotationPoint(0.0F, 12.0F, 0.0F);

		this.tLower = new ModelRenderer(this, 0, 0);
		this.tLower.setRotationPoint(-0.5F, 4.0F, 0.0F);
		this.setRotationAngles(tLower, -0.0873F, 0.0F, 0.0F);
		this.torso.addChild(tLower);
		this.tLower.func_228301_a_(-4.0F, -4.0F, -3.0F, 9, 7, 7, 0.0F);

		this.tUpper = new ModelRenderer(this, 21, 21);
		this.tUpper.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.setRotationAngles(tUpper, 0.3491F, 0.0F, 0.0F);
		this.tLower.addChild(tUpper);
		this.tUpper.func_228301_a_(-3.5F, -5.0F, -2.5F, 8, 4, 7, 0.0F);

		this.leftArm = new ModelRenderer(this);
		this.leftArm.setRotationPoint(-4.0F, 12.0F, 0.0F);

		this.lAJoint = new ModelRenderer(this, 30, 42);
		this.lAJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngles(lAJoint, 0.0F, -0.1745F, -0.6109F);
		this.leftArm.addChild(lAJoint);
		this.lAJoint.func_228301_a_(-4.0F, -1.0F, -1.5F, 4, 3, 3, 0.0F);

		this.lALower = new ModelRenderer(this, 36, 36);
		this.lALower.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.setRotationAngles(lALower, 0.0F, -0.5236F, -0.7854F);
		this.lAJoint.addChild(lALower);
		this.lALower.func_228301_a_(-5.0F, -1.0F, -1.5F, 6, 3, 3, -0.5F);

		this.hand0 = new ModelRenderer(this, 12, 39);
		this.hand0.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lALower.addChild(hand0);
		this.hand0.func_228301_a_(-7.0F, -1.0F, 0.0F, 4, 3, 0, 0.0F);

		this.rightArm = new ModelRenderer(this);
		this.rightArm.setRotationPoint(4.0F, 12.0F, 0.0F);

		this.rAJoint = new ModelRenderer(this, 16, 42);
		this.rAJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotationAngles(rAJoint, 0.0F, 0.1745F, 0.6109F);
		this.rightArm.addChild(rAJoint);
		this.rAJoint.func_228301_a_(0.0F, -1.0F, -1.5F, 4, 3, 3, 0.0F);

		this.rALower = new ModelRenderer(this, 27, 0);
		this.rALower.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.setRotationAngles(rALower, 0.0F, 0.5236F, 0.7854F);
		this.rAJoint.addChild(rALower);
		this.rALower.func_228301_a_(-1.0F, -1.0F, -1.5F, 6, 3, 3, -0.5F);

		this.hand1 = new ModelRenderer(this, 21, 14);
		this.hand1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rALower.addChild(hand1);
		this.hand1.func_228301_a_(3.0F, -1.0F, 0.0F, 4, 3, 0, 0.0F);

		this.head = new ModelRenderer(this, 0, 14);
		this.head.setRotationPoint(0.0F, 10.0F, 0.5F);
		this.head.func_228301_a_(-3.5F, -4.0F, -4.5F, 7, 6, 7, 0.0F);

		this.mouth = new ModelRenderer(this, 0, 27);
		this.mouth.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.setRotationAngles(mouth, 0.4363F, 0.0F, 0.0F);
		this.head.addChild(mouth);
		this.mouth.func_228301_a_(-3.0F, -1.0F, -2.0F, 6, 8, 4, 0.0F);

		this.teeth = new ModelRenderer(this, 16, 27);
		this.teeth.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.mouth.addChild(teeth);
		this.teeth.func_228301_a_(-3.0F, -2.0F, -1.0F, 6, 1, 0, 0.0F);

		this.nose = new ModelRenderer(this, 44, 18);
		this.nose.setRotationPoint(0.0F, -2.0F, -5.0F);
		this.setRotationAngles(nose, -0.9599F, 0.0F, 0.0F);
		this.head.addChild(nose);
		this.nose.func_228301_a_(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.nose.func_228301_a_(-1.5F, 0.5F, -2.3F, 2, 2, 2, -0.7F);

		this.leftEye = new ModelRenderer(this, 0, 2);
		this.leftEye.setRotationPoint(-3.5F, -2.5F, -4.5F);
		this.setRotationAngles(leftEye, 0.0F, 0.5236F, 0.0F);
		this.head.addChild(leftEye);
		this.leftEye.func_228301_a_(0.0F, -0.5F, 0.0F, 1, 1, 1, 0.2F);

		this.rightEye = new ModelRenderer(this, 0, 0);
		this.rightEye.setRotationPoint(3.5F, -2.5F, -4.5F);
		this.setRotationAngles(rightEye, 0.0F, -0.5236F, 0.0F);
		this.head.addChild(rightEye);
		this.rightEye.func_228301_a_(-1.0F, -0.5F, 0.0F, 1, 1, 1, 0.2F);

		this.leftEar = new ModelRenderer(this, 41, 42);
		this.leftEar.setRotationPoint(-3.5F, -2.0F, -1.0F);
		this.setRotationAngles(leftEar, 0.5236F, 0.7854F, 0.5236F);
		this.head.addChild(leftEar);
		this.leftEar.func_228301_a_(-6.0F, -2.0F, 0.0F, 6, 3, 0, 0.0F);

		this.rightEar = new ModelRenderer(this, 40, 32);
		this.rightEar.setRotationPoint(3.5F, -2.0F, -1.0F);
		this.setRotationAngles(rightEar, 0.5236F, -0.7854F, -0.5236F);
		this.head.addChild(rightEar);
		this.rightEar.func_228301_a_(0.0F, -2.0F, 0.0F, 6, 3, 0, 0.0F);
	}
	
	protected Iterable<ModelRenderer> func_225602_a_()
	{
		return func_225600_b_();
	}
	
	protected Iterable<ModelRenderer> func_225600_b_()
	{
		return ImmutableList.of(this.leftLeg, this.rightLeg, this.torso, this.leftArm, this.rightArm, this.head);
	}
	
	public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_)
	{
		super.func_225597_a_(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
		this.copyRotationAngles(this.head, super.bipedHead);
		this.copyRotationAngles(this.rightArm, super.bipedRightArm);
		this.copyRotationAngles(this.leftArm, super.bipedLeftArm);
		this.copyRotationAngles(this.rightLeg, super.bipedRightLeg);
		this.copyRotationAngles(this.leftLeg, super.bipedLeftLeg);
	}
}
