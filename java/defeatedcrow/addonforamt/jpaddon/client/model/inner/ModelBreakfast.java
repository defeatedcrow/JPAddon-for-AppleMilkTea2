package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBreakfast extends ModelBase {
	// fields
	ModelRenderer egg1;
	ModelRenderer egg2;
	ModelRenderer pork;
	ModelRenderer pork2;
	ModelRenderer mush;
	ModelRenderer mush2;
	ModelRenderer tomato;

	public ModelBreakfast() {
		textureWidth = 64;
		textureHeight = 32;

		egg1 = new ModelRenderer(this, 47, 8);
		egg1.addBox(-2F, 5.5F, -2.5F, 2, 1, 2);
		egg1.setRotationPoint(0F, 16F, 0F);
		egg1.setTextureSize(64, 32);
		egg1.mirror = true;
		setRotation(egg1, 0F, -0.2792527F, 0F);
		egg2 = new ModelRenderer(this, 32, 0);
		egg2.addBox(-4F, 6F, -4.5F, 6, 1, 6);
		egg2.setRotationPoint(0F, 16F, 0F);
		egg2.setTextureSize(64, 32);
		egg2.mirror = true;
		setRotation(egg2, 0F, -0.2792527F, 0F);
		pork = new ModelRenderer(this, 32, 8);
		pork.addBox(0F, 0F, 0F, 3, 1, 4);
		pork.setRotationPoint(-3F, 22.5F, 0F);
		pork.setTextureSize(64, 32);
		pork.mirror = true;
		setRotation(pork, 0.3141593F, -0.4712389F, 0F);
		pork2 = new ModelRenderer(this, 32, 8);
		pork2.addBox(0F, 0F, 0F, 3, 1, 4);
		pork2.setRotationPoint(-1F, 22.5F, 0F);
		pork2.setTextureSize(64, 32);
		pork2.mirror = true;
		setRotation(pork2, 0.3839724F, -0.2443461F, 0F);
		mush = new ModelRenderer(this, 32, 14);
		mush.addBox(0F, 0F, 0F, 2, 1, 2);
		mush.setRotationPoint(2F, 22F, 2F);
		mush.setTextureSize(64, 32);
		mush.mirror = true;
		setRotation(mush, 0.0523599F, 0.1047198F, 0F);
		mush2 = new ModelRenderer(this, 32, 14);
		mush2.addBox(0F, 0F, 0F, 2, 1, 2);
		mush2.setRotationPoint(1F, 22F, 1F);
		mush2.setTextureSize(64, 32);
		mush2.mirror = true;
		setRotation(mush2, 0.4363323F, 0.5235988F, 0F);
		tomato = new ModelRenderer(this, 41, 14);
		tomato.addBox(0F, 0F, 0F, 3, 2, 3);
		tomato.setRotationPoint(3F, 21F, -3F);
		tomato.setTextureSize(64, 32);
		tomato.mirror = true;
		setRotation(tomato, 0F, -0.2094395F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		egg1.render(f5);
		egg2.render(f5);
		pork.render(f5);
		pork2.render(f5);
		mush.render(f5);
		mush2.render(f5);
		tomato.render(f5);
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