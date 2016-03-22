package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCarpaccio extends ModelBase {
	// fields
	ModelRenderer source;
	ModelRenderer meal1;
	ModelRenderer meal2;
	ModelRenderer meal3;
	ModelRenderer meal4;
	ModelRenderer meal5;
	ModelRenderer meal6;
	ModelRenderer green1;
	ModelRenderer green2;
	ModelRenderer green3;

	public ModelCarpaccio() {
		textureWidth = 64;
		textureHeight = 32;

		source = new ModelRenderer(this, 32, 0);
		source.addBox(-4F, 6.6F, -4F, 8, 0, 8);
		source.setRotationPoint(0F, 16F, 0F);
		source.setTextureSize(64, 32);
		source.mirror = true;
		setRotation(source, 0F, 0F, 0F);
		meal1 = new ModelRenderer(this, 32, 10);
		meal1.addBox(0F, 0F, -1.5F, 4, 1, 3);
		meal1.setRotationPoint(0F, 22F, 0F);
		meal1.setTextureSize(64, 32);
		meal1.mirror = true;
		setRotation(meal1, 0.5235988F, 0F, 0F);
		meal2 = new ModelRenderer(this, 32, 10);
		meal2.addBox(0F, 0F, -1.5F, 4, 1, 3);
		meal2.setRotationPoint(0F, 22F, 0F);
		meal2.setTextureSize(64, 32);
		meal2.mirror = true;
		setRotation(meal2, 0.5235988F, 1.047198F, 0F);
		meal3 = new ModelRenderer(this, 32, 10);
		meal3.addBox(0F, 0F, -1.5F, 4, 1, 3);
		meal3.setRotationPoint(0F, 22F, 0F);
		meal3.setTextureSize(64, 32);
		meal3.mirror = true;
		setRotation(meal3, 0.5235988F, 2.094395F, 0F);
		meal4 = new ModelRenderer(this, 32, 10);
		meal4.addBox(0F, 0F, -1.5F, 4, 1, 3);
		meal4.setRotationPoint(0F, 22F, 0F);
		meal4.setTextureSize(64, 32);
		meal4.mirror = true;
		setRotation(meal4, 0.5235988F, 3.141593F, 0F);
		meal5 = new ModelRenderer(this, 32, 10);
		meal5.addBox(0F, 0F, -1.5F, 4, 1, 3);
		meal5.setRotationPoint(0F, 22F, 0F);
		meal5.setTextureSize(64, 32);
		meal5.mirror = true;
		setRotation(meal5, 0.5235988F, -1.047198F, 0F);
		meal6 = new ModelRenderer(this, 32, 10);
		meal6.addBox(0F, 0F, -1.5F, 4, 1, 3);
		meal6.setRotationPoint(0F, 22F, 0F);
		meal6.setTextureSize(64, 32);
		meal6.mirror = true;
		setRotation(meal6, 0.5235988F, -2.094395F, 0F);
		green1 = new ModelRenderer(this, 32, 16);
		green1.addBox(0F, 0F, 0F, 1, 1, 1);
		green1.setRotationPoint(1F, 21F, -2F);
		green1.setTextureSize(64, 32);
		green1.mirror = true;
		setRotation(green1, 0F, 0.2617994F, 0F);
		green2 = new ModelRenderer(this, 32, 16);
		green2.addBox(0F, 0F, 0F, 1, 1, 1);
		green2.setRotationPoint(-1.5F, 21F, 0F);
		green2.setTextureSize(64, 32);
		green2.mirror = true;
		setRotation(green2, 0F, 0.7853982F, 0F);
		green3 = new ModelRenderer(this, 32, 16);
		green3.addBox(0F, 0F, 0F, 1, 1, 1);
		green3.setRotationPoint(0F, 21F, 1F);
		green3.setTextureSize(64, 32);
		green3.mirror = true;
		setRotation(green3, 0F, -0.1745329F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		meal1.render(f5);
		meal2.render(f5);
		meal3.render(f5);
		meal4.render(f5);
		meal5.render(f5);
		meal6.render(f5);
		green1.render(f5);
		green2.render(f5);
		green3.render(f5);
	}

	public void renderSource(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		source.render(f5);
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
