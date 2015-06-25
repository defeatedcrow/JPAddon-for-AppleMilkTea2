package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCheese extends ModelBase {
	// fields
	ModelRenderer cheese1;
	ModelRenderer cheese2;
	ModelRenderer cheese3;
	ModelRenderer cheese4;
	ModelRenderer cheese5;
	ModelRenderer seal;

	public ModelCheese() {
		textureWidth = 64;
		textureHeight = 32;

		cheese1 = new ModelRenderer(this, 0, 0);
		cheese1.addBox(-5F, 2F, -2F, 10, 6, 4);
		cheese1.setRotationPoint(0F, 16F, 0F);
		cheese1.setTextureSize(64, 32);
		cheese1.mirror = true;
		setRotation(cheese1, 0F, 0F, 0F);
		cheese2 = new ModelRenderer(this, 0, 0);
		cheese2.addBox(-4F, 2F, 2F, 8, 6, 2);
		cheese2.setRotationPoint(0F, 16F, 0F);
		cheese2.setTextureSize(64, 32);
		cheese2.mirror = true;
		setRotation(cheese2, 0F, 0F, 0F);
		cheese3 = new ModelRenderer(this, 0, 0);
		cheese3.addBox(-4F, 2F, -4F, 8, 6, 2);
		cheese3.setRotationPoint(0F, 16F, 0F);
		cheese3.setTextureSize(64, 32);
		cheese3.mirror = true;
		setRotation(cheese3, 0F, 0F, 0F);
		cheese4 = new ModelRenderer(this, 0, 0);
		cheese4.addBox(-2F, 2F, 4F, 4, 6, 1);
		cheese4.setRotationPoint(0F, 16F, 0F);
		cheese4.setTextureSize(64, 32);
		cheese4.mirror = true;
		setRotation(cheese4, 0F, 0F, 0F);
		cheese5 = new ModelRenderer(this, 0, 0);
		cheese5.addBox(-2F, 2F, -5F, 4, 6, 1);
		cheese5.setRotationPoint(0F, 16F, 0F);
		cheese5.setTextureSize(64, 32);
		cheese5.mirror = true;
		setRotation(cheese5, 0F, 0F, 0F);
		seal = new ModelRenderer(this, 0, 12);
		seal.addBox(-2.5F, 1.9F, -2.5F, 5, 0, 5);
		seal.setRotationPoint(0F, 16F, 0F);
		seal.setTextureSize(64, 32);
		seal.mirror = true;
		setRotation(seal, 0F, 0.7853982F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		cheese1.render(f5);
		cheese2.render(f5);
		cheese3.render(f5);
		cheese4.render(f5);
		cheese5.render(f5);
		seal.render(f5);
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
