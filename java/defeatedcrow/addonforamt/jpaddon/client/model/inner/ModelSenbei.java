package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSenbei extends ModelBase
{
	  //fields
	    ModelRenderer senbei1;
	    ModelRenderer senbei2;
	    ModelRenderer senbei3;
	  
	  public ModelSenbei()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      senbei1 = new ModelRenderer(this, 0, 0);
	      senbei1.addBox(-1F, -1F, -1F, 5, 1, 5);
	      senbei1.setRotationPoint(0F, 23F, 0F);
	      senbei1.setTextureSize(64, 32);
	      senbei1.mirror = true;
	      setRotation(senbei1, 0F, 0.2094395F, 0F);
	      senbei2 = new ModelRenderer(this, 0, 0);
	      senbei2.addBox(-4F, -2.2F, -4F, 5, 1, 5);
	      senbei2.setRotationPoint(0F, 23F, 0F);
	      senbei2.setTextureSize(64, 32);
	      senbei2.mirror = true;
	      setRotation(senbei2, 0.3141593F, 1.396263F, 0F);
	      senbei3 = new ModelRenderer(this, 0, 0);
	      senbei3.addBox(-2F, -3F, -3F, 5, 1, 5);
	      senbei3.setRotationPoint(0F, 23F, 0F);
	      senbei3.setTextureSize(64, 32);
	      senbei3.mirror = true;
	      setRotation(senbei3, 0.5235988F, -0.1047198F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    senbei1.render(f5);
	    senbei2.render(f5);
	    senbei3.render(f5);
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
