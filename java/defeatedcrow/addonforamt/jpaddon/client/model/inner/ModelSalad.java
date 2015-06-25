package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSalad extends ModelBase {
	// fields
	ModelRenderer bottom;
	ModelRenderer sideF;
	ModelRenderer sideB;
	ModelRenderer sideL;
	ModelRenderer sideR;
	ModelRenderer leaf1;
	ModelRenderer leaf2;
	ModelRenderer leaf3;
	ModelRenderer leaf4;
	ModelRenderer leaf5;
	ModelRenderer leaf6;
	ModelRenderer leaf7;
	ModelRenderer leaf8;
	ModelRenderer mid;
	ModelRenderer egg1;
	ModelRenderer egg2;
	ModelRenderer egg3;
	ModelRenderer egg4;
	ModelRenderer tomato1;
	ModelRenderer tomato2;
	ModelRenderer tomato3;
	ModelRenderer tomato4;

	public ModelSalad() {
		textureWidth = 64;
		textureHeight = 64;

		bottom = new ModelRenderer(this, 0, 0);
		bottom.addBox(-5F, 6F, -5F, 10, 2, 10);
		bottom.setRotationPoint(0F, 16F, 0F);
		bottom.setTextureSize(64, 64);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0F, 0F);
		sideF = new ModelRenderer(this, 0, 14);
		sideF.addBox(-6F, 2F, -6F, 12, 4, 1);
		sideF.setRotationPoint(0F, 17F, 0F);
		sideF.setTextureSize(64, 64);
		sideF.mirror = true;
		setRotation(sideF, 0F, 0F, 0F);
		sideB = new ModelRenderer(this, 0, 36);
		sideB.addBox(-6F, 3F, 5F, 12, 4, 1);
		sideB.setRotationPoint(0F, 16F, 0F);
		sideB.setTextureSize(64, 64);
		sideB.mirror = true;
		setRotation(sideB, 0F, 0F, 0F);
		sideL = new ModelRenderer(this, 0, 20);
		sideL.addBox(5F, 3F, -5F, 1, 4, 10);
		sideL.setRotationPoint(0F, 16F, 0F);
		sideL.setTextureSize(64, 64);
		sideL.mirror = true;
		setRotation(sideL, 0F, 0F, 0F);
		sideR = new ModelRenderer(this, 0, 42);
		sideR.addBox(-6F, 3F, -5F, 1, 4, 10);
		sideR.setRotationPoint(0F, 16F, 0F);
		sideR.setTextureSize(64, 64);
		sideR.mirror = true;
		setRotation(sideR, 0F, 0F, 0F);
		leaf1 = new ModelRenderer(this, 30, 14);
		leaf1.addBox(-2F, -6F, -5F, 6, 6, 0);
		leaf1.setRotationPoint(0F, 16F, 0F);
		leaf1.setTextureSize(64, 64);
		leaf1.mirror = true;
		setRotation(leaf1, 1.047198F, -0.2094395F, 0F);
		leaf2 = new ModelRenderer(this, 30, 14);
		leaf2.addBox(-2F, -6F, -5F, 6, 6, 0);
		leaf2.setRotationPoint(0F, 16F, 0F);
		leaf2.setTextureSize(64, 64);
		leaf2.mirror = true;
		setRotation(leaf2, 1.047198F, 1.361357F, 0F);
		leaf3 = new ModelRenderer(this, 36, 14);
		leaf3.addBox(-4F, -6F, 5F, 6, 6, 0);
		leaf3.setRotationPoint(0F, 16F, 0F);
		leaf3.setTextureSize(64, 64);
		leaf3.mirror = true;
		setRotation(leaf3, -1.047198F, -0.2094395F, 0F);
		leaf4 = new ModelRenderer(this, 36, 14);
		leaf4.addBox(-4F, -6F, 5F, 6, 6, 0);
		leaf4.setRotationPoint(0F, 16F, 0F);
		leaf4.setTextureSize(64, 64);
		leaf4.mirror = true;
		setRotation(leaf4, -1.047198F, 1.361357F, 0F);
		leaf5 = new ModelRenderer(this, 45, 14);
		leaf5.addBox(-2F, -4F, -5F, 5, 5, 0);
		leaf5.setRotationPoint(0F, 16F, 0F);
		leaf5.setTextureSize(64, 64);
		leaf5.mirror = true;
		setRotation(leaf5, 0.9599311F, 0.6457718F, 0F);
		leaf6 = new ModelRenderer(this, 45, 14);
		leaf6.addBox(-2F, -4F, -5F, 5, 5, 0);
		leaf6.setRotationPoint(0F, 16F, 0F);
		leaf6.setTextureSize(64, 64);
		leaf6.mirror = true;
		setRotation(leaf6, 0.9599311F, 2.216568F, 0F);
		leaf7 = new ModelRenderer(this, 50, 14);
		leaf7.addBox(-2F, -4F, 5F, 5, 5, 0);
		leaf7.setRotationPoint(0F, 16F, 0F);
		leaf7.setTextureSize(64, 64);
		leaf7.mirror = true;
		setRotation(leaf7, -1.047198F, 0.6457718F, 0F);
		leaf8 = new ModelRenderer(this, 50, 14);
		leaf8.addBox(-2F, -4F, 5F, 5, 5, 0);
		leaf8.setRotationPoint(0F, 16F, 0F);
		leaf8.setTextureSize(64, 64);
		leaf8.mirror = true;
		setRotation(leaf8, -1.047198F, 2.216568F, 0F);
		mid = new ModelRenderer(this, 42, 0);
		mid.addBox(-2F, 3F, -2F, 4, 3, 4);
		mid.setRotationPoint(0F, 16F, 0F);
		mid.setTextureSize(64, 64);
		mid.mirror = true;
		setRotation(mid, 0F, 0F, 0F);
		egg1 = new ModelRenderer(this, 30, 22);
		egg1.addBox(0F, 0F, -4F, 3, 3, 1);
		egg1.setRotationPoint(0F, 16F, 0F);
		egg1.setTextureSize(64, 64);
		egg1.mirror = true;
		setRotation(egg1, 0.5235988F, 0.5235988F, 0F);
		egg2 = new ModelRenderer(this, 30, 22);
		egg2.addBox(0F, 0F, -5F, 3, 3, 1);
		egg2.setRotationPoint(0F, 16F, 0F);
		egg2.setTextureSize(64, 64);
		egg2.mirror = true;
		setRotation(egg2, 0.5235988F, -0.8726646F, 0F);
		egg3 = new ModelRenderer(this, 30, 22);
		egg3.addBox(-2F, 2F, -2F, 3, 3, 1);
		egg3.setRotationPoint(0F, 16F, 0F);
		egg3.setTextureSize(64, 64);
		egg3.mirror = true;
		setRotation(egg3, -0.3839724F, 1.570796F, 0F);
		egg4 = new ModelRenderer(this, 30, 22);
		egg4.addBox(-2F, 0F, 4F, 3, 3, 1);
		egg4.setRotationPoint(0F, 16F, 0F);
		egg4.setTextureSize(64, 64);
		egg4.mirror = true;
		setRotation(egg4, -0.5235988F, 0.2617994F, 0F);
		tomato1 = new ModelRenderer(this, 40, 22);
		tomato1.addBox(0F, 2F, 0F, 2, 2, 2);
		tomato1.setRotationPoint(0F, 16F, 0F);
		tomato1.setTextureSize(64, 64);
		tomato1.mirror = true;
		setRotation(tomato1, 0.2617994F, -0.4363323F, 0F);
		tomato2 = new ModelRenderer(this, 40, 22);
		tomato2.addBox(-2F, 1F, -3F, 2, 2, 2);
		tomato2.setRotationPoint(0F, 16F, 0F);
		tomato2.setTextureSize(64, 64);
		tomato2.mirror = true;
		setRotation(tomato2, 0.5235988F, -0.8726646F, 0F);
		tomato3 = new ModelRenderer(this, 50, 22);
		tomato3.addBox(1.5F, 2F, -0.5F, 2, 2, 2);
		tomato3.setRotationPoint(0F, 16F, 0F);
		tomato3.setTextureSize(64, 64);
		tomato3.mirror = true;
		setRotation(tomato3, 0.0698132F, 0.3839724F, 0.3490659F);
		tomato4 = new ModelRenderer(this, 50, 22);
		tomato4.addBox(-3F, 1F, -1F, 2, 2, 2);
		tomato4.setRotationPoint(0F, 16F, 0F);
		tomato4.setTextureSize(64, 64);
		tomato4.mirror = true;
		setRotation(tomato4, 0.2094395F, 0.3490659F, -0.2792527F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bottom.render(f5);
		sideF.render(f5);
		sideB.render(f5);
		sideL.render(f5);
		sideR.render(f5);
		leaf1.render(f5);
		leaf2.render(f5);
		leaf3.render(f5);
		leaf4.render(f5);
		leaf5.render(f5);
		leaf6.render(f5);
		leaf7.render(f5);
		leaf8.render(f5);
		mid.render(f5);
		egg1.render(f5);
		egg2.render(f5);
		egg3.render(f5);
		egg4.render(f5);
		tomato1.render(f5);
		tomato2.render(f5);
		tomato3.render(f5);
		tomato4.render(f5);
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
