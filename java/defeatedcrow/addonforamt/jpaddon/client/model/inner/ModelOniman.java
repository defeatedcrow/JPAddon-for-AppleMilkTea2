package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOniman extends ModelBase
{
	  //fields
	    ModelRenderer kushi;
	    ModelRenderer mothi;
	    ModelRenderer imo1;
	    ModelRenderer imo2;
	    ModelRenderer imo3;
	    ModelRenderer imo4;
	    ModelRenderer imo5;
	    ModelRenderer imo6;
	    ModelRenderer imo7;
	    ModelRenderer imo8;
	  
	  public ModelOniman()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      kushi = new ModelRenderer(this, 0, 0);
	      kushi.addBox(4F, -1F, 1F, 1, 1, 6);
	      kushi.setRotationPoint(0F, 23F, 0F);
	      kushi.setTextureSize(64, 32);
	      kushi.mirror = true;
	      setRotation(kushi, 0.1745329F, 1.047198F, 0F);
	      mothi = new ModelRenderer(this, 16, 0);
	      mothi.addBox(-3F, -4F, -3F, 5, 4, 5);
	      mothi.setRotationPoint(0F, 23F, 0F);
	      mothi.setTextureSize(64, 32);
	      mothi.mirror = true;
	      setRotation(mothi, 0F, 1.396263F, 0F);
	      imo1 = new ModelRenderer(this, 0, 8);
	      imo1.addBox(0F, -4.5F, 0F, 1, 1, 1);
	      imo1.setRotationPoint(0F, 23F, 0F);
	      imo1.setTextureSize(64, 32);
	      imo1.mirror = true;
	      setRotation(imo1, 0F, 0F, 0F);
	      imo2 = new ModelRenderer(this, 0, 8);
	      imo2.addBox(1F, -2F, 0F, 1, 1, 1);
	      imo2.setRotationPoint(0F, 23F, 0F);
	      imo2.setTextureSize(64, 32);
	      imo2.mirror = true;
	      setRotation(imo2, -0.3141593F, 0F, 0F);
	      imo3 = new ModelRenderer(this, 0, 8);
	      imo3.addBox(0F, -2F, -2F, 1, 1, 1);
	      imo3.setRotationPoint(0F, 23F, 0F);
	      imo3.setTextureSize(64, 32);
	      imo3.mirror = true;
	      setRotation(imo3, 0.0872665F, 0.1570796F, 0F);
	      imo4 = new ModelRenderer(this, 0, 8);
	      imo4.addBox(-3F, -3F, 0F, 1, 1, 1);
	      imo4.setRotationPoint(0F, 23F, 0F);
	      imo4.setTextureSize(64, 32);
	      imo4.mirror = true;
	      setRotation(imo4, 0.9250245F, 0.2617994F, 0F);
	      imo5 = new ModelRenderer(this, 0, 8);
	      imo5.addBox(0F, -3F, 2.5F, 1, 1, 1);
	      imo5.setRotationPoint(0F, 23F, 0F);
	      imo5.setTextureSize(64, 32);
	      imo5.mirror = true;
	      setRotation(imo5, 0F, 0.1570796F, 0F);
	      imo6 = new ModelRenderer(this, 0, 8);
	      imo6.addBox(-2.5F, -4F, -2.5F, 1, 1, 1);
	      imo6.setRotationPoint(0F, 23F, 0F);
	      imo6.setTextureSize(64, 32);
	      imo6.mirror = true;
	      setRotation(imo6, -0.122173F, -0.1919862F, 0F);
	      imo7 = new ModelRenderer(this, 0, 8);
	      imo7.addBox(-2.5F, -3F, 3F, 1, 1, 1);
	      imo7.setRotationPoint(0F, 23F, 0F);
	      imo7.setTextureSize(64, 32);
	      imo7.mirror = true;
	      setRotation(imo7, 0.2268928F, -0.5235988F, 0F);
	      imo8 = new ModelRenderer(this, 0, 8);
	      imo8.addBox(-2F, -2.5F, 1.5F, 1, 1, 1);
	      imo8.setRotationPoint(0F, 23F, 0F);
	      imo8.setTextureSize(64, 32);
	      imo8.mirror = true;
	      setRotation(imo8, -0.296706F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    kushi.render(f5);
	    mothi.render(f5);
	    imo1.render(f5);
	    imo2.render(f5);
	    imo3.render(f5);
	    imo4.render(f5);
	    imo5.render(f5);
	    imo6.render(f5);
	    imo7.render(f5);
	    imo8.render(f5);
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
