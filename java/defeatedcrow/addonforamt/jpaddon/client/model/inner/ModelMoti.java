package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMoti extends ModelBase
{
	  //fields
	    ModelRenderer moti1;
	    ModelRenderer moti2;
	    ModelRenderer kushi;
	  
	  public ModelMoti()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      moti1 = new ModelRenderer(this, 16, 0);
	      moti1.addBox(-3F, -3F, -4.5F, 4, 3, 4);
	      moti1.setRotationPoint(0F, 23F, 0F);
	      moti1.setTextureSize(64, 32);
	      moti1.mirror = true;
	      setRotation(moti1, 0F, 1.308997F, 0F);
	      moti2 = new ModelRenderer(this, 16, 0);
	      moti2.addBox(-2F, -3F, 0F, 4, 3, 4);
	      moti2.setRotationPoint(0F, 23F, 0F);
	      moti2.setTextureSize(64, 32);
	      moti2.mirror = true;
	      setRotation(moti2, 0F, 1.308997F, 0F);
	      kushi = new ModelRenderer(this, 0, 0);
	      kushi.addBox(3F, -1F, 1F, 1, 1, 6);
	      kushi.setRotationPoint(0F, 23F, 0F);
	      kushi.setTextureSize(64, 32);
	      kushi.mirror = true;
	      setRotation(kushi, 0.1745329F, 1.308997F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    moti1.render(f5);
	    moti2.render(f5);
	    kushi.render(f5);
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
