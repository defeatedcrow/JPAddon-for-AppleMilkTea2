package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTukemono extends ModelBase {
	// fields
	ModelRenderer melon1;
	ModelRenderer melon2;
	ModelRenderer melon3;
	ModelRenderer eggp1;
	ModelRenderer eggp2;
	ModelRenderer eggp3;
	ModelRenderer cu1;
	ModelRenderer cu2;
	ModelRenderer cu3;

	public ModelTukemono() {
		textureWidth = 64;
		textureHeight = 32;

		melon1 = new ModelRenderer(this, 0, 0);
		melon1.addBox(-4F, 5F, 0F, 3, 1, 4);
		melon1.setRotationPoint(0F, 16F, 0F);
		melon1.setTextureSize(64, 32);
		melon1.mirror = true;
		setRotation(melon1, 0F, -0.2094395F, -0.4363323F);
		melon2 = new ModelRenderer(this, 0, 0);
		melon2.addBox(-5.5F, 4.2F, 0F, 3, 1, 4);
		melon2.setRotationPoint(0F, 16F, 0F);
		melon2.setTextureSize(64, 32);
		melon2.mirror = true;
		setRotation(melon2, 0F, -0.2094395F, -0.4363323F);
		melon3 = new ModelRenderer(this, 0, 0);
		melon3.addBox(-7F, 3.5F, 0F, 3, 1, 4);
		melon3.setRotationPoint(0F, 16F, 0F);
		melon3.setTextureSize(64, 32);
		melon3.mirror = true;
		setRotation(melon3, 0F, -0.2094395F, -0.4363323F);
		eggp1 = new ModelRenderer(this, 16, 0);
		eggp1.addBox(2F, 5F, 0F, 2, 2, 2);
		eggp1.setRotationPoint(0F, 16F, 0F);
		eggp1.setTextureSize(64, 32);
		eggp1.mirror = true;
		setRotation(eggp1, 0F, -0.3490659F, 0F);
		eggp2 = new ModelRenderer(this, 16, 0);
		eggp2.addBox(3F, 5F, 1F, 2, 2, 2);
		eggp2.setRotationPoint(0F, 16F, 0F);
		eggp2.setTextureSize(64, 32);
		eggp2.mirror = true;
		setRotation(eggp2, 0F, 0.3316126F, 0F);
		eggp3 = new ModelRenderer(this, 16, 0);
		eggp3.addBox(2F, 5F, -2F, 2, 2, 2);
		eggp3.setRotationPoint(0F, 16F, 0F);
		eggp3.setTextureSize(64, 32);
		eggp3.mirror = true;
		setRotation(eggp3, 0F, 0.0523599F, 0F);
		cu1 = new ModelRenderer(this, 26, 0);
		cu1.addBox(-4F, 5F, -2F, 4, 1, 1);
		cu1.setRotationPoint(0F, 16F, 0F);
		cu1.setTextureSize(64, 32);
		cu1.mirror = true;
		setRotation(cu1, 0F, -0.7853982F, -0.2094395F);
		cu2 = new ModelRenderer(this, 26, 0);
		cu2.addBox(-5F, 5F, -1F, 4, 1, 1);
		cu2.setRotationPoint(0F, 16F, 0F);
		cu2.setTextureSize(64, 32);
		cu2.mirror = true;
		setRotation(cu2, 0.0349066F, -0.7853982F, -0.2094395F);
		cu3 = new ModelRenderer(this, 26, 0);
		cu3.addBox(3F, 3F, -1F, 4, 1, 1);
		cu3.setRotationPoint(0F, 16F, 0F);
		cu3.setTextureSize(64, 32);
		cu3.mirror = true;
		setRotation(cu3, 0F, 0.7853982F, 0.5235988F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		melon1.render(f5);
		melon2.render(f5);
		melon3.render(f5);
		eggp1.render(f5);
		eggp2.render(f5);
		eggp3.render(f5);
		cu1.render(f5);
		cu2.render(f5);
		cu3.render(f5);
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
