package defeatedcrow.addonforamt.jpaddon.client.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAlabasterChandelier extends ModelBase {
	// fields
	ModelRenderer o1;
	ModelRenderer m1;
	ModelRenderer i1;
	ModelRenderer i2;
	ModelRenderer i3;
	ModelRenderer i4;
	ModelRenderer bottom;
	ModelRenderer bottom2;
	ModelRenderer i21;
	ModelRenderer i22;
	ModelRenderer i23;
	ModelRenderer i24;
	ModelRenderer lamp1;
	ModelRenderer lamp2;

	public ModelAlabasterChandelier() {
		textureWidth = 64;
		textureHeight = 32;

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
		setRotation(i2, 0.7853982F, 1.570796F, 0F);
		i3 = new ModelRenderer(this, 28, 0);
		i3.addBox(2.6F, -6.5F, 1.5F, 1, 5, 5);
		i3.setRotationPoint(0F, 16F, 0F);
		i3.setTextureSize(64, 32);
		i3.mirror = true;
		setRotation(i3, 0.7853982F, -1.570796F, 0F);
		i4 = new ModelRenderer(this, 28, 0);
		i4.addBox(2.6F, -6.5F, 1.5F, 1, 5, 5);
		i4.setRotationPoint(0F, 16F, 0F);
		i4.setTextureSize(64, 32);
		i4.mirror = true;
		setRotation(i4, 0.7853982F, 3.141593F, 0F);
		bottom = new ModelRenderer(this, 0, 15);
		bottom.addBox(-1F, -1F, -1F, 2, 2, 2);
		bottom.setRotationPoint(0F, 16F, 0F);
		bottom.setTextureSize(64, 32);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0.7853982F, 0F);
		bottom2 = new ModelRenderer(this, 0, 15);
		bottom2.addBox(-1F, -5F, -1F, 2, 2, 2);
		bottom2.setRotationPoint(10F, 16F, 0F);
		bottom2.setTextureSize(64, 32);
		bottom2.mirror = true;
		setRotation(bottom2, 0F, 0F, 0F);
		i21 = new ModelRenderer(this, 40, 0);
		i21.addBox(1.5F, -4F, 0F, 1, 4, 4);
		i21.setRotationPoint(10F, 12F, 0F);
		i21.setTextureSize(64, 32);
		i21.mirror = true;
		setRotation(i21, 0.7853982F, 0F, 0F);
		i22 = new ModelRenderer(this, 40, 0);
		i22.addBox(1.5F, -4F, 0F, 1, 4, 4);
		i22.setRotationPoint(10F, 12F, 0F);
		i22.setTextureSize(64, 32);
		i22.mirror = true;
		setRotation(i22, 0.7853982F, 1.570796F, 0F);
		i23 = new ModelRenderer(this, 40, 0);
		i23.addBox(1.5F, -4F, 0F, 1, 4, 4);
		i23.setRotationPoint(10F, 12F, 0F);
		i23.setTextureSize(64, 32);
		i23.mirror = true;
		setRotation(i23, 0.7853982F, -1.570796F, 0F);
		i24 = new ModelRenderer(this, 40, 0);
		i24.addBox(1.5F, -4F, 0F, 1, 4, 4);
		i24.setRotationPoint(10F, 12F, 0F);
		i24.setTextureSize(64, 32);
		i24.mirror = true;
		setRotation(i24, 0.7853982F, 3.141593F, 0F);
		lamp1 = new ModelRenderer(this, 10, 15);
		lamp1.addBox(-1.5F, -6F, -1.5F, 3, 3, 3);
		lamp1.setRotationPoint(0F, 16F, 0F);
		lamp1.setTextureSize(64, 32);
		lamp1.mirror = true;
		setRotation(lamp1, 0F, 0F, 0F);
		lamp2 = new ModelRenderer(this, 23, 15);
		lamp2.addBox(-1F, -3F, -1F, 2, 2, 2);
		lamp2.setRotationPoint(10F, 12F, 0F);
		lamp2.setTextureSize(64, 32);
		lamp2.mirror = true;
		setRotation(lamp2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		i1.render(f5);
		i2.render(f5);
		i3.render(f5);
		i4.render(f5);
		bottom.render(f5);
		lamp1.render(f5);
	}

	public void renderPetal1(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		o1.render(f5);
	}

	public void renderPetal2(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		m1.render(f5);
	}

	public void renderLamps(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bottom2.render(f5);
		i21.render(f5);
		i22.render(f5);
		i23.render(f5);
		i24.render(f5);
		lamp2.render(f5);
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
