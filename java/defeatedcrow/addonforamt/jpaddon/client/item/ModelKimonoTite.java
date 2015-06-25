package defeatedcrow.addonforamt.jpaddon.client.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelKimonoTite extends ModelBiped {
	public ModelRenderer head;
	public ModelRenderer body;
	public ModelRenderer rightArm;
	public ModelRenderer leftArm;
	public ModelRenderer rightLeg;
	public ModelRenderer leftLeg;

	// 追加パーツ
	ModelRenderer bodybottom;
	ModelRenderer obi;
	ModelRenderer obi2;

	public ModelKimonoTite() {
		this(0.75F);
	}

	public ModelKimonoTite(float f) {
		this(f, 0.0F, 64, 64);
	}

	public ModelKimonoTite(float f1, float f2, int i3, int i4) {
		this.textureWidth = i3;
		this.textureHeight = i4;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8, f1);
		head.showModel = false;
		head.setRotationPoint(0F, 0F + f2, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-3.5F, 0F, -1.5F, 7, 12, 3, f1);
		body.setRotationPoint(0F, 0F + f2, 0F);
		rightArm = new ModelRenderer(this, 24, 16);
		rightArm.addBox(-2.5F, -2F, -1.5F, 3, 12, 3, f1);
		rightArm.setRotationPoint(-3F, 2F + f2, 0F);
		leftArm = new ModelRenderer(this, 40, 16);
		leftArm.addBox(-0.5F, -2F, -1.5F, 3, 12, 3, f1);
		leftArm.setRotationPoint(4F, 2F + f2, 0F);
		rightLeg = new ModelRenderer(this, 0, 32);
		rightLeg.addBox(-1.5F, 0F, -1.5F, 3, 12, 3, f1);
		rightLeg.setRotationPoint(-2F, 12F + f2, 0F);
		leftLeg = new ModelRenderer(this, 16, 32);
		leftLeg.addBox(-1.5F, 0F, -1.5F, 3, 12, 3, f1);
		leftLeg.setRotationPoint(2F, 12F + f2, 0F);
		bodybottom = new ModelRenderer(this, 0, 48);
		bodybottom.addBox(-4.5F, 0F, -2.5F, 9, 10, 5);
		bodybottom.setRotationPoint(0F, 12F + f2, 0F);
		obi = new ModelRenderer(this, 28, 48);
		obi.addBox(-4.5F, 7F, -2.5F, 9, 3, 5);
		obi.setRotationPoint(0F, 0F + f2, 0F);
		obi2 = new ModelRenderer(this, 28, 56);
		obi2.addBox(-3F, 6F, 2F, 6, 4, 1);
		obi2.setRotationPoint(0F, 0F + f2, 0F);
	}

	@Override
	public void render(Entity f1, float f2, float f3, float f4, float f5, float f6, float f7) {
		this.setRotationAngles(f2, f3, f4, f5, f6, f7, f1);

		if (this.isChild) {
			float f = 2.0F;
			GL11.glPushMatrix();
			GL11.glScalef(1.5F / f, 1.5F / f, 1.5F / f);
			GL11.glTranslatef(0.0F, 16.0F * f7, 0.0F);
			this.head.render(f7);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
			GL11.glTranslatef(0.0F, 24.0F * f7, 0.0F);
			this.body.render(f7);
			this.bodybottom.render(f7);
			this.obi.render(f7);
			this.obi2.render(f7);
			this.rightArm.render(f7);
			this.leftArm.render(f7);
			this.rightLeg.render(f7);
			this.leftLeg.render(f7);
			GL11.glPopMatrix();
		} else {
			this.head.render(f7);
			this.body.render(f7);
			this.bodybottom.render(f7);
			this.obi.render(f7);
			this.obi2.render(f7);
			this.rightArm.render(f7);
			this.leftArm.render(f7);
			this.rightLeg.render(f7);
			this.leftLeg.render(f7);
		}
	}

	@Override
	public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float float6, Entity entity) {
		super.setRotationAngles(f1, f2, f3, f4, f5, float6, entity);

		this.head.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f5 / (180F / (float) Math.PI);
		this.rightArm.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 2.0F * f2 * 0.5F;
		this.leftArm.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 2.0F * f2 * 0.5F;
		this.rightArm.rotateAngleZ = 0.0F;
		this.leftArm.rotateAngleZ = 0.0F;
		this.rightLeg.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
		this.leftLeg.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.rightLeg.rotateAngleY = 0.0F;
		this.leftLeg.rotateAngleY = 0.0F;

		boolean ride = false;
		boolean held = false;
		boolean sneak = false;
		boolean block = false;
		if (entity != null) {
			if (entity.isRiding())
				ride = true;
			if (entity.isSneaking())
				sneak = true;
			if (entity instanceof EntityPlayer) {
				if (((EntityPlayer) entity).inventory.getCurrentItem() != null)
					held = true;
				if (((EntityPlayer) entity).isBlocking())
					block = true;
			} else if (entity instanceof EntityLiving) {
				if (((EntityLiving) entity).getEquipmentInSlot(0) != null)
					held = true;
			}
		}

		if (ride) {
			this.rightArm.rotateAngleX += -((float) Math.PI / 5F);
			this.leftArm.rotateAngleX += -((float) Math.PI / 5F);
			this.rightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.leftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.bodybottom.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.rightLeg.rotateAngleY = ((float) Math.PI / 10F);
			this.leftLeg.rotateAngleY = -((float) Math.PI / 10F);
		} else {
			this.bodybottom.rotateAngleX = 0;
		}

		if (this.heldItemLeft != 0) {
			this.leftArm.rotateAngleX = this.leftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * 1;
		}

		if (held) {
			this.rightArm.rotateAngleX = this.rightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * 1;
		}

		this.rightArm.rotateAngleY = 0.0F;
		this.leftArm.rotateAngleY = 0.0F;
		float f6;
		float f7;

		if (this.onGround > -9990.0F) {
			f6 = this.onGround;
			this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float) Math.PI * 2.0F) * 0.2F;
			this.obi.rotateAngleY = this.body.rotateAngleY;
			this.obi2.rotateAngleY = this.body.rotateAngleY;
			this.rightArm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.rightArm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.leftArm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.leftArm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.rightArm.rotateAngleY += this.body.rotateAngleY;
			this.leftArm.rotateAngleY += this.body.rotateAngleY;
			this.leftArm.rotateAngleX += this.body.rotateAngleY;
			f6 = 1.0F - this.onGround;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			f7 = MathHelper.sin(f6 * (float) Math.PI);
			float f8 = MathHelper.sin(this.onGround * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
			this.rightArm.rotateAngleX = (float) (this.rightArm.rotateAngleX - (f7 * 1.2D + f8));
			this.rightArm.rotateAngleY += this.body.rotateAngleY * 2.0F;
			this.rightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float) Math.PI) * -0.4F;
		}

		if (sneak) {
			this.body.rotateAngleX = 0.5F;
			this.rightArm.rotateAngleX += 0.4F;
			this.leftArm.rotateAngleX += 0.4F;
			this.rightLeg.rotationPointZ = 4.0F;
			this.leftLeg.rotationPointZ = 4.0F;
			this.rightLeg.rotationPointY = 9.0F;
			this.leftLeg.rotationPointY = 9.0F;
			this.head.rotationPointY = 1.0F;
			this.bodybottom.rotationPointZ = 4.0F;
			this.bodybottom.rotationPointY = 9.0F;
			this.obi.rotateAngleX = 0.5F;
			this.obi2.rotateAngleX = 0.5F;
		} else {
			this.body.rotateAngleX = 0.0F;
			this.rightLeg.rotationPointZ = 0.1F;
			this.leftLeg.rotationPointZ = 0.1F;
			this.rightLeg.rotationPointY = 12.0F;
			this.leftLeg.rotationPointY = 12.0F;
			this.bodybottom.rotationPointZ = 0.1F;
			this.bodybottom.rotationPointY = 12.0F;
			this.head.rotationPointY = 0.0F;
			this.obi.rotateAngleX = 0.0F;
			this.obi2.rotateAngleX = 0.0F;
		}

		this.rightArm.rotateAngleZ += MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
		this.leftArm.rotateAngleZ -= MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
		this.rightArm.rotateAngleX += MathHelper.sin(f3 * 0.067F) * 0.05F;
		this.leftArm.rotateAngleX -= MathHelper.sin(f3 * 0.067F) * 0.05F;

		if (block) {
			f6 = 0.0F;
			f7 = 0.0F;
			this.rightArm.rotateAngleZ = 0.0F;
			this.leftArm.rotateAngleZ = 0.0F;
			this.rightArm.rotateAngleY = -(0.1F - f6 * 0.6F) + this.head.rotateAngleY;
			this.leftArm.rotateAngleY = 0.1F - f6 * 0.6F + this.head.rotateAngleY + 0.4F;
			this.rightArm.rotateAngleX = -((float) Math.PI / 2F) + this.head.rotateAngleX;
			this.leftArm.rotateAngleX = -((float) Math.PI / 2F) + this.head.rotateAngleX;
			this.rightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			this.leftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			this.rightArm.rotateAngleZ += MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
			this.leftArm.rotateAngleZ -= MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
			this.rightArm.rotateAngleX += MathHelper.sin(f3 * 0.067F) * 0.05F;
			this.leftArm.rotateAngleX -= MathHelper.sin(f3 * 0.067F) * 0.05F;
		}
	}

}
