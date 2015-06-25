package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSwissroll extends ModelBase
{
	  //fields
    ModelRenderer kushi;
    ModelRenderer cake1;
    ModelRenderer cake2;
    ModelRenderer cake3;
    ModelRenderer cake4;
    ModelRenderer cream1;
    ModelRenderer cream2;
    ModelRenderer fruit1;
    ModelRenderer fruit2;
    ModelRenderer fruit3;
  
  public ModelSwissroll()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      kushi = new ModelRenderer(this, 38, 0);
      kushi.addBox(4F, 6F, -1F, 1, 1, 6);
      kushi.setRotationPoint(0F, 16F, 0F);
      kushi.setTextureSize(64, 32);
      kushi.mirror = true;
      setRotation(kushi, 0.2617994F, 1.047198F, 0F);
      cake1 = new ModelRenderer(this, 0, 0);
      cake1.addBox(-2F, -2F, 0F, 5, 2, 3);
      cake1.setRotationPoint(0F, 23F, 0F);
      cake1.setTextureSize(64, 32);
      cake1.mirror = true;
      setRotation(cake1, 0F, -0.0872665F, 0F);
      cake2 = new ModelRenderer(this, 0, 6);
      cake2.addBox(-2F, -7F, 0F, 5, 2, 3);
      cake2.setRotationPoint(0F, 23F, 0F);
      cake2.setTextureSize(64, 32);
      cake2.mirror = true;
      setRotation(cake2, 0F, -0.0872665F, 0F);
      cake3 = new ModelRenderer(this, 0, 12);
      cake3.addBox(3F, -7F, 0F, 2, 7, 3);
      cake3.setRotationPoint(0F, 23F, 0F);
      cake3.setTextureSize(64, 32);
      cake3.mirror = true;
      setRotation(cake3, 0F, -0.0872665F, 0F);
      cake4 = new ModelRenderer(this, 12, 12);
      cake4.addBox(-4F, -7F, 0F, 2, 7, 3);
      cake4.setRotationPoint(0F, 23F, 0F);
      cake4.setTextureSize(64, 32);
      cake4.mirror = true;
      setRotation(cake4, 0F, -0.0872665F, 0F);
      cream1 = new ModelRenderer(this, 18, 0);
      cream1.addBox(-2F, -5F, 0.1F, 5, 3, 1);
      cream1.setRotationPoint(0F, 23F, 0F);
      cream1.setTextureSize(64, 32);
      cream1.mirror = true;
      setRotation(cream1, 0F, -0.0872665F, 0F);
      cream2 = new ModelRenderer(this, 18, 0);
      cream2.addBox(-2F, -5F, 1.9F, 5, 3, 1);
      cream2.setRotationPoint(0F, 23F, 0F);
      cream2.setTextureSize(64, 32);
      cream2.mirror = true;
      setRotation(cream2, 0F, -0.0872665F, 0F);
      fruit1 = new ModelRenderer(this, 32, 0);
      fruit1.addBox(-1F, -3.8F, 1.3F, 1, 1, 1);
      fruit1.setRotationPoint(0F, 23F, 0F);
      fruit1.setTextureSize(64, 32);
      fruit1.mirror = true;
      setRotation(fruit1, 0.7853982F, 1.396263F, 0F);
      fruit2 = new ModelRenderer(this, 32, 0);
      fruit2.addBox(-2F, -3F, 0F, 1, 1, 1);
      fruit2.setRotationPoint(0F, 23F, 0F);
      fruit2.setTextureSize(64, 32);
      fruit2.mirror = true;
      setRotation(fruit2, 0F, 0.0698132F, 0.6283185F);
      fruit3 = new ModelRenderer(this, 32, 0);
      fruit3.addBox(0F, -4F, 2.1F, 1, 1, 1);
      fruit3.setRotationPoint(0F, 23F, 0F);
      fruit3.setTextureSize(64, 32);
      fruit3.mirror = true;
      setRotation(fruit3, -0.0174533F, -0.0523599F, 0.4014257F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    kushi.render(f5);
    cake1.render(f5);
    cake2.render(f5);
    cake3.render(f5);
    cake4.render(f5);
    cream1.render(f5);
    cream2.render(f5);
    fruit1.render(f5);
    fruit2.render(f5);
    fruit3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
