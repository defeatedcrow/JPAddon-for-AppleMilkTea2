package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrownie extends ModelBase
{
	  //fields
	    ModelRenderer kushi;
	    ModelRenderer brownie1;
	    ModelRenderer brownie2;
	  
	  public ModelBrownie()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      kushi = new ModelRenderer(this, 0, 0);
	      kushi.addBox(4F, -1F, 1F, 1, 1, 6);
	      kushi.setRotationPoint(0F, 23F, 0F);
	      kushi.setTextureSize(64, 32);
	      kushi.mirror = true;
	      setRotation(kushi, 0.1745329F, 1.047198F, 0F);
	      brownie1 = new ModelRenderer(this, 16, 0);
	      brownie1.addBox(-1F, -2F, -3F, 6, 2, 4);
	      brownie1.setRotationPoint(0F, 23F, 0F);
	      brownie1.setTextureSize(64, 32);
	      brownie1.mirror = true;
	      setRotation(brownie1, 0F, -1.047198F, 0F);
	      brownie2 = new ModelRenderer(this, 16, 0);
	      brownie2.addBox(-4F, -4F, -1F, 6, 2, 4);
	      brownie2.setRotationPoint(0F, 23F, 0F);
	      brownie2.setTextureSize(64, 32);
	      brownie2.mirror = true;
	      setRotation(brownie2, 0F, 0.5235988F, -0.4363323F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    kushi.render(f5);
	    brownie1.render(f5);
	    brownie2.render(f5);
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
