package defeatedcrow.addonforamt.jpaddon.client.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAlabasterLamp extends ModelBase {
	// fields
	ModelRenderer o1;
	ModelRenderer o2;
	ModelRenderer o3;
	ModelRenderer o4;
	ModelRenderer m1;
	ModelRenderer m2;
	ModelRenderer m3;
	ModelRenderer m4;
	ModelRenderer i1;
	ModelRenderer i2;
	ModelRenderer i3;
	ModelRenderer i4;
	ModelRenderer lamp;

	public ModelAlabasterLamp() {
		textureWidth = 64;
		textureHeight = 32;

		float f = 0.7853982F;

		o1 = new ModelRenderer(this, 0, 0);
		o1.addBox(0F, -7F, 0F, 1, 7, 7);
		o1.setRotationPoint(0F, 16F, 0F);
		o1.setTextureSize(64, 32);
		o1.mirror = true;
		setRotation(o1, 0.7853982F, 0F, 1.047198F);
		m1 = new ModelRenderer(this, 16, 0);
		m1.addBox(1F, -6F, 1F, 1, 5, 5);
		m1.setRotationPoint(0F, 16F, 0F);
		m1.setTextureSize(64, 32);
		m1.mirror = true;
		setRotation(m1, 0.7853982F, 0F, 0.6108652F);
		i1 = new ModelRenderer(this, 28, 0);
		i1.addBox(2.6F, -6.5F, 1.5F, 1, 5, 5);
		i1.setRotationPoint(0F, 16F, 0F);
		i1.setTextureSize(64, 32);
		i1.mirror = true;
		setRotation(i1, 0.7853982F, 0F, 0F);
		i2 = new ModelRenderer(this, 28, 0);
		i2.addBox(2.6F, -6.5F, 1.5F, 1, 5, 5);
		i2.setRotationPoint(0F, 16F, 0F);
		i2.setTextureSize(64, 32);
		i2.mirror = true;
		setRotation(i2, 0.7853982F, f * 2, 0F);
		i3 = new ModelRenderer(this, 28, 0);
		i3.addBox(2.6F, -6.5F, 1.5F, 1, 5, 5);
		i3.setRotationPoint(0F, 16F, 0F);
		i3.setTextureSize(64, 32);
		i3.mirror = true;
		setRotation(i3, 0.7853982F, -f * 2, 0F);
		i4 = new ModelRenderer(this, 28, 0);
		i4.addBox(2.6F, -6.5F, 1.5F, 1, 5, 5);
		i4.setRotationPoint(0F, 16F, 0F);
		i4.setTextureSize(64, 32);
		i4.mirror = true;
		setRotation(i4, 0.7853982F, f * 4, 0F);
		lamp = new ModelRenderer(this, 0, 15);
		lamp.addBox(-1F, -5F, -1F, 2, 4, 2);
		lamp.setRotationPoint(0F, 16F, 0F);
		lamp.setTextureSize(64, 32);
		lamp.mirror = true;
		setRotation(lamp, 0F, 0.7853982F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		i1.render(f5);
		i2.render(f5);
		i3.render(f5);
		i4.render(f5);
		lamp.render(f5);
	}

	public void renderPetal1(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		o1.render(f5);
	}

	public void renderPetal2(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		m1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

}
