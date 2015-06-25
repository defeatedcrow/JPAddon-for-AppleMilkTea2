package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHiraki extends ModelBase {
	// fields
	ModelRenderer tail;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer fish1;
	ModelRenderer fish2;
	ModelRenderer fish3;
	ModelRenderer oroshi;

	public ModelHiraki() {
		textureWidth = 64;
		textureHeight = 32;

		tail = new ModelRenderer(this, 32, 0);
		tail.addBox(-3F, 6.5F, 5F, 5, 0, 4);
		tail.setRotationPoint(0F, 16F, 0F);
		tail.setTextureSize(64, 32);
		tail.mirror = true;
		setRotation(tail, 0.1745329F, 0.8726646F, 0F);
		tail2 = new ModelRenderer(this, 0, 0);
		tail2.addBox(-1F, 6F, 5F, 1, 1, 1);
		tail2.setRotationPoint(0F, 16F, 0F);
		tail2.setTextureSize(64, 32);
		tail2.mirror = true;
		setRotation(tail2, 0.0872665F, 0.8726646F, 0F);
		tail3 = new ModelRenderer(this, 10, 0);
		tail3.addBox(-1.5F, 6F, 4F, 2, 1, 1);
		tail3.setRotationPoint(0F, 16F, 0F);
		tail3.setTextureSize(64, 32);
		tail3.mirror = true;
		setRotation(tail3, 0.0872665F, 0.8726646F, 0F);
		fish1 = new ModelRenderer(this, 0, 6);
		fish1.addBox(-2.5F, 6F, 2.1F, 4, 1, 2);
		fish1.setRotationPoint(0F, 16F, 0F);
		fish1.setTextureSize(64, 32);
		fish1.mirror = true;
		setRotation(fish1, 0.0698132F, 0.8726646F, 0F);
		fish2 = new ModelRenderer(this, 0, 10);
		fish2.addBox(-4F, 6F, -0.9F, 7, 1, 3);
		fish2.setRotationPoint(0F, 16F, 0F);
		fish2.setTextureSize(64, 32);
		fish2.mirror = true;
		setRotation(fish2, 0.0698132F, 0.8726646F, 0F);
		fish3 = new ModelRenderer(this, 0, 15);
		fish3.addBox(-4.5F, 6F, -4F, 8, 1, 4);
		fish3.setRotationPoint(0F, 16F, 0F);
		fish3.setTextureSize(64, 32);
		fish3.mirror = true;
		setRotation(fish3, -0.0174533F, 0.8726646F, 0F);
		oroshi = new ModelRenderer(this, 32, 5);
		oroshi.addBox(4F, 5F, -2F, 2, 2, 2);
		oroshi.setRotationPoint(0F, 16F, 0F);
		oroshi.setTextureSize(64, 32);
		oroshi.mirror = true;
		setRotation(oroshi, 0F, 0.4537856F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		tail.render(f5);
		tail2.render(f5);
		tail3.render(f5);
		fish1.render(f5);
		fish2.render(f5);
		fish3.render(f5);
		oroshi.render(f5);
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
