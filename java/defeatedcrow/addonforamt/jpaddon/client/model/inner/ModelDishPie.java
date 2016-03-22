package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDishPie extends ModelBase {
	// fields
	ModelRenderer cake1;
	ModelRenderer cake2;

	public ModelDishPie() {
		textureWidth = 64;
		textureHeight = 32;

		cake1 = new ModelRenderer(this, 32, 0);
		cake1.addBox(-4F, 4F, -4F, 8, 3, 8);
		cake1.setRotationPoint(0F, 16F, 0F);
		cake1.setTextureSize(64, 32);
		cake1.mirror = true;
		setRotation(cake1, 0F, 0F, 0F);
		cake2 = new ModelRenderer(this, 32, 12);
		cake2.addBox(-4F, 3F, -4F, 8, 1, 8);
		cake2.setRotationPoint(0F, 16F, 0F);
		cake2.setTextureSize(64, 32);
		cake2.mirror = true;
		setRotation(cake2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		cake1.render(f5);
		cake2.render(f5);
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
