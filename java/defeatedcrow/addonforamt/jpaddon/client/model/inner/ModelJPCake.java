package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelJPCake extends ModelBase
{
	  //fields
	    ModelRenderer base;
	    ModelRenderer cream1;
	    ModelRenderer cream2;
	    ModelRenderer cream3;
	    ModelRenderer top;
	    ModelRenderer hashi;
	  
	  public ModelJPCake()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      base = new ModelRenderer(this, 0, 0);
	      base.addBox(-4F, 0F, -1F, 8, 1, 4);
	      base.setRotationPoint(0F, 22F, 0F);
	      base.setTextureSize(64, 32);
	      base.mirror = true;
	      setRotation(base, 0F, -0.2094395F, 0F);
	      cream1 = new ModelRenderer(this, 0, 6);
	      cream1.addBox(-4F, -1F, -1F, 8, 1, 4);
	      cream1.setRotationPoint(0F, 22F, 0F);
	      cream1.setTextureSize(64, 32);
	      cream1.mirror = true;
	      setRotation(cream1, 0F, -0.2094395F, 0F);
	      cream2 = new ModelRenderer(this, 0, 12);
	      cream2.addBox(-4F, -2F, -1F, 8, 1, 4);
	      cream2.setRotationPoint(0F, 22F, 0F);
	      cream2.setTextureSize(64, 32);
	      cream2.mirror = true;
	      setRotation(cream2, 0F, -0.2094395F, 0F);
	      cream3 = new ModelRenderer(this, 0, 6);
	      cream3.addBox(-4F, -3F, -1F, 8, 1, 4);
	      cream3.setRotationPoint(0F, 22F, 0F);
	      cream3.setTextureSize(64, 32);
	      cream3.mirror = true;
	      setRotation(cream3, 0F, -0.2094395F, 0F);
	      top = new ModelRenderer(this, 0, 18);
	      top.addBox(-4F, -4F, -1F, 8, 1, 4);
	      top.setRotationPoint(0F, 22F, 0F);
	      top.setTextureSize(64, 32);
	      top.mirror = true;
	      setRotation(top, 0F, -0.2094395F, 0F);
	      hashi = new ModelRenderer(this, 25, 0);
	      hashi.addBox(0F, 0F, -3F, 6, 1, 1);
	      hashi.setRotationPoint(0F, 22F, 0F);
	      hashi.setTextureSize(64, 32);
	      hashi.mirror = true;
	      setRotation(hashi, 0.122173F, -0.2617994F, -0.2617994F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    base.render(f5);
	    cream1.render(f5);
	    cream2.render(f5);
	    cream3.render(f5);
	    top.render(f5);
	    hashi.render(f5);
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
