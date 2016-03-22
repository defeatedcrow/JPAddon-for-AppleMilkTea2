package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBeefstew extends ModelBase {
	// fields
	ModelRenderer source;
	ModelRenderer meal1;
	ModelRenderer meal2;
	ModelRenderer meal3;
	ModelRenderer meal4;
	ModelRenderer meal5;

	public ModelBeefstew() {
		textureWidth = 64;
		textureHeight = 32;

		source = new ModelRenderer(this, 32, 0);
		source.addBox(-4F, 6.6F, -4F, 8, 0, 8);
		source.setRotationPoint(0F, 16F, 0F);
		source.setTextureSize(64, 32);
		source.mirror = true;
		setRotation(source, 0F, 0F, 0F);
		meal1 = new ModelRenderer(this, 32, 10);
		meal1.addBox(0F, 0F, 0F, 5, 1, 3);
		meal1.setRotationPoint(-2F, 22.5F, 1F);
		meal1.setTextureSize(64, 32);
		meal1.mirror = true;
		setRotation(meal1, 0.3490659F, 0.5235988F, 0F);
		meal2 = new ModelRenderer(this, 32, 10);
		meal2.addBox(0F, 0F, 0F, 5, 1, 3);
		meal2.setRotationPoint(-4F, 22.3F, -2F);
		meal2.setTextureSize(64, 32);
		meal2.mirror = true;
		setRotation(meal2, 0.3490659F, 0.2094395F, 0F);
		meal3 = new ModelRenderer(this, 32, 15);
		meal3.addBox(0F, 0F, 0F, 2, 1, 2);
		meal3.setRotationPoint(-3F, 22F, 1F);
		meal3.setTextureSize(64, 32);
		meal3.mirror = true;
		setRotation(meal3, 0F, 0.0872665F, 0F);
		meal4 = new ModelRenderer(this, 32, 15);
		meal4.addBox(0F, 0F, 0F, 2, 1, 2);
		meal4.setRotationPoint(-2F, 22F, -4F);
		meal4.setTextureSize(64, 32);
		meal4.mirror = true;
		setRotation(meal4, 0.5235988F, 0.0872665F, 0F);
		meal5 = new ModelRenderer(this, 32, 15);
		meal5.addBox(0F, 0F, 0F, 2, 1, 2);
		meal5.setRotationPoint(1F, 22F, -3F);
		meal5.setTextureSize(64, 32);
		meal5.mirror = true;
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
