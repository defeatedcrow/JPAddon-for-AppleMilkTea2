package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMasuzushi extends ModelBase
{
	  //fields
	    ModelRenderer leaf1;
	    ModelRenderer leaf2;
	    ModelRenderer syari;
	    ModelRenderer neta;
	  
	  public ModelMasuzushi()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      leaf1 = new ModelRenderer(this, 0, 12);
	      leaf1.addBox(0F, 0F, 0F, 6, 0, 6);
	      leaf1.setRotationPoint(0F, 23F, 0F);
	      leaf1.setTextureSize(64, 32);
	      leaf1.mirror = true;
	      setRotation(leaf1, 0.0523599F, -0.7853982F, -0.0523599F);
	      leaf2 = new ModelRenderer(this, 0, 12);
	      leaf2.addBox(0F, 0F, 0F, 6, 0, 6);
	      leaf2.setRotationPoint(0F, 23F, 0F);
	      leaf2.setTextureSize(64, 32);
	      leaf2.mirror = true;
	      setRotation(leaf2, 0.0523599F, 2.356194F, -0.0523599F);
	      syari = new ModelRenderer(this, 0, 0);
	      syari.addBox(-4F, -2F, -4F, 8, 2, 8);
	      syari.setRotationPoint(0F, 23F, 0F);
	      syari.setTextureSize(64, 32);
	      syari.mirror = true;
	      setRotation(syari, 0F, 0F, 0F);
	      neta = new ModelRenderer(this, 32, 0);
	      neta.addBox(-4F, -3F, -4F, 8, 1, 8);
	      neta.setRotationPoint(0F, 23F, 0F);
	      neta.setTextureSize(64, 32);
	      neta.mirror = true;
	      setRotation(neta, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    leaf1.render(f5);
	    leaf2.render(f5);
	    syari.render(f5);
	    neta.render(f5);
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
