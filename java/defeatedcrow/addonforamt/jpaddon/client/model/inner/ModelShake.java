package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShake extends ModelBase
{
	  //fields
	    ModelRenderer sake1;
	    ModelRenderer sake2;
	    ModelRenderer sake3;
	    ModelRenderer sake4;
	    ModelRenderer sake5;
	    ModelRenderer sake6;
	    ModelRenderer hajikami;
	  
	  public ModelShake()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      sake1 = new ModelRenderer(this, 0, 0);
	      sake1.addBox(-4.5F, -1.8F, 1.2F, 3, 2, 2);
	      sake1.setRotationPoint(0F, 23F, 0F);
	      sake1.setTextureSize(64, 32);
	      sake1.mirror = true;
	      setRotation(sake1, 0.1047198F, -0.7330383F, 0F);
	      sake2 = new ModelRenderer(this, 11, 0);
	      sake2.addBox(-4.5F, -1.9F, -0.7F, 2, 2, 1);
	      sake2.setRotationPoint(0F, 23F, 0F);
	      sake2.setTextureSize(64, 32);
	      sake2.mirror = true;
	      setRotation(sake2, 0.0523599F, -0.2617994F, 0F);
	      sake3 = new ModelRenderer(this, 18, 0);
	      sake3.addBox(-3F, -2F, -1F, 2, 2, 3);
	      sake3.setRotationPoint(0F, 23F, 0F);
	      sake3.setTextureSize(64, 32);
	      sake3.mirror = true;
	      setRotation(sake3, 0.0872665F, -0.2094395F, 0F);
	      sake4 = new ModelRenderer(this, 0, 6);
	      sake4.addBox(-1.2F, -1.9F, 0F, 4, 2, 2);
	      sake4.setRotationPoint(0F, 23F, 0F);
	      sake4.setTextureSize(64, 32);
	      sake4.mirror = true;
	      setRotation(sake4, 0.122173F, -0.122173F, 0F);
	      sake5 = new ModelRenderer(this, 13, 6);
	      sake5.addBox(-1.2F, -1.7F, -0.7F, 3, 2, 1);
	      sake5.setRotationPoint(0F, 23F, 0F);
	      sake5.setTextureSize(64, 32);
	      sake5.mirror = true;
	      setRotation(sake5, 0F, -0.5235988F, 0F);
	      sake6 = new ModelRenderer(this, 22, 6);
	      sake6.addBox(2F, -1.8F, 0.3F, 3, 2, 2);
	      sake6.setRotationPoint(0F, 23F, 0F);
	      sake6.setTextureSize(64, 32);
	      sake6.mirror = true;
	      setRotation(sake6, 0.1047198F, 0.0872665F, 0F);
	      hajikami = new ModelRenderer(this, 0, 16);
	      hajikami.addBox(1F, -3F, -4F, 1, 1, 6);
	      hajikami.setRotationPoint(0F, 23F, 0F);
	      hajikami.setTextureSize(64, 32);
	      hajikami.mirror = true;
	      setRotation(hajikami, 0.5235988F, -0.4712389F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    sake1.render(f5);
	    sake2.render(f5);
	    sake3.render(f5);
	    sake4.render(f5);
	    sake5.render(f5);
	    sake6.render(f5);
	    hajikami.render(f5);
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
