package mods.railcraft_cos.common.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CosCartTender extends CosCartModelBase
{

	
	  //fields
	    ModelRenderer wheelRearRightRear;
	    ModelRenderer wheelRearLeftRear;
	    ModelRenderer wheelRearLeftFront;
	    ModelRenderer wheelRearRightFront;
	    ModelRenderer wheelRear;
	    ModelRenderer wheelFrontLeftFront;
	    ModelRenderer wheelFront;
	    ModelRenderer wheelFrontRightFront;
	    ModelRenderer cartBottom;
	    ModelRenderer topFront;
	    ModelRenderer topRear;
	    ModelRenderer topRight;
	    ModelRenderer topLeft;
	    ModelRenderer coal1Mid;
	    ModelRenderer coal1Top;
	    ModelRenderer coal1Bottom;
	    ModelRenderer coal2Bottom;
	    ModelRenderer coal2Mid;
	    ModelRenderer coal2Top;
	    ModelRenderer coal3Bottom;
	    ModelRenderer coal3Top;
	    ModelRenderer coal3Mid;
	    ModelRenderer coal3Front;
	  
	  public CosCartTender()
	  {
	    textureWidth = 128;
	    textureHeight = 64;
	    
	      wheelRearRightRear = new ModelRenderer(this, 9, 0);
	      wheelRearRightRear.addBox(5F, 5F, 9F, 1, 2, 3);
	      wheelRearRightRear.setRotationPoint(0F, 0F, 0F);
	      wheelRearRightRear.setTextureSize(128, 64);
	      wheelRearRightRear.mirror = true;
	      setRotation(wheelRearRightRear, 0F, 0F, 0F);
	      wheelRearLeftRear = new ModelRenderer(this, 0, 0);
	      wheelRearLeftRear.addBox(-6F, 5F, 9F, 1, 2, 3);
	      wheelRearLeftRear.setRotationPoint(0F, 0F, 0F);
	      wheelRearLeftRear.setTextureSize(128, 64);
	      wheelRearLeftRear.mirror = true;
	      setRotation(wheelRearLeftRear, 0F, 0F, 0F);
	      wheelRearLeftFront = new ModelRenderer(this, 0, 6);
	      wheelRearLeftFront.addBox(-6F, 5F, 5F, 1, 2, 3);
	      wheelRearLeftFront.setRotationPoint(0F, 0F, 0F);
	      wheelRearLeftFront.setTextureSize(128, 64);
	      wheelRearLeftFront.mirror = true;
	      setRotation(wheelRearLeftFront, 0F, 0F, 0F);
	      wheelRearRightFront = new ModelRenderer(this, 9, 6);
	      wheelRearRightFront.addBox(5F, 5F, 5F, 1, 2, 3);
	      wheelRearRightFront.setRotationPoint(0F, 0F, 0F);
	      wheelRearRightFront.setTextureSize(128, 64);
	      wheelRearRightFront.mirror = true;
	      setRotation(wheelRearRightFront, 0F, 0F, 0F);
	      wheelRear = new ModelRenderer(this, 0, 20);
	      wheelRear.addBox(-7F, 3F, 5F, 14, 2, 7);
	      wheelRear.setRotationPoint(0F, 0F, 0F);
	      wheelRear.setTextureSize(128, 64);
	      wheelRear.mirror = true;
	      setRotation(wheelRear, 0F, 0F, 0F);
	      wheelFrontLeftFront = new ModelRenderer(this, 0, 12);
	      wheelFrontLeftFront.addBox(-6F, 5F, -2F, 1, 2, 3);
	      wheelFrontLeftFront.setRotationPoint(0F, 0F, 0F);
	      wheelFrontLeftFront.setTextureSize(128, 64);
	      wheelFrontLeftFront.mirror = true;
	      setRotation(wheelFrontLeftFront, 0F, 0F, 0F);
	      wheelFront = new ModelRenderer(this, 0, 29);
	      wheelFront.addBox(-7F, 3F, -2F, 14, 2, 3);
	      wheelFront.setRotationPoint(0F, 0F, 0F);
	      wheelFront.setTextureSize(128, 64);
	      wheelFront.mirror = true;
	      setRotation(wheelFront, 0F, 0F, 0F);
	      wheelFrontRightFront = new ModelRenderer(this, 9, 12);
	      wheelFrontRightFront.addBox(5F, 5F, -2F, 1, 2, 3);
	      wheelFrontRightFront.setRotationPoint(0F, 0F, 0F);
	      wheelFrontRightFront.setTextureSize(128, 64);
	      wheelFrontRightFront.mirror = true;
	      setRotation(wheelFrontRightFront, 0F, 0F, 0F);
	      cartBottom = new ModelRenderer(this, 3, 3);
	      cartBottom.addBox(-7F, 2F, -3F, 14, 1, 15);
	      cartBottom.setRotationPoint(0F, 0F, 0F);
	      cartBottom.setTextureSize(128, 64);
	      cartBottom.mirror = true;
	      setRotation(cartBottom, 0F, 0F, 0F);
	      topFront = new ModelRenderer(this, 47, 0);
	      topFront.addBox(0F, 0F, 8F, 14, 4, 1);
	      topFront.setRotationPoint(-7F, -2F, -12F);
	      topFront.setTextureSize(128, 64);
	      topFront.mirror = true;
	      setRotation(topFront, 0F, 0F, 0F);
	      topRear = new ModelRenderer(this, 47, 6);
	      topRear.addBox(0F, 0F, 0F, 14, 7, 1);
	      topRear.setRotationPoint(-7F, -5F, 11F);
	      topRear.setTextureSize(128, 64);
	      topRear.mirror = true;
	      setRotation(topRear, 0F, 0F, 0F);
	      topRight = new ModelRenderer(this, 0, 35);
	      topRight.addBox(0F, 0F, 8F, 1, 7, 14);
	      topRight.setRotationPoint(6F, -5F, -11F);
	      topRight.setTextureSize(128, 64);
	      topRight.mirror = true;
	      setRotation(topRight, 0F, 0F, 0F);
	      topLeft = new ModelRenderer(this, 31, 35);
	      topLeft.addBox(0F, 0F, 8F, 1, 7, 14);
	      topLeft.setRotationPoint(-7F, -5F, -11F);
	      topLeft.setTextureSize(128, 64);
	      topLeft.mirror = true;
	      setRotation(topLeft, 0F, 0F, 0F);
	      coal1Mid = new ModelRenderer(this, 78, 0);
	      coal1Mid.addBox(-6F, 0F, 5F, 12, 1, 6);
	      coal1Mid.setRotationPoint(0F, 0F, 0F);
	      coal1Mid.setTextureSize(128, 64);
	      coal1Mid.mirror = true;
	      setRotation(coal1Mid, 0F, 0F, 0F);
	      coal1Top = new ModelRenderer(this, 43, 20);
	      coal1Top.addBox(-6F, -1F, 8F, 12, 1, 3);
	      coal1Top.setRotationPoint(0F, 0F, 0F);
	      coal1Top.setTextureSize(128, 64);
	      coal1Top.mirror = true;
	      setRotation(coal1Top, 0F, 0F, 0F);
	      coal1Bottom = new ModelRenderer(this, 78, 7);
	      coal1Bottom.addBox(-6F, 1F, 2F, 12, 1, 9);
	      coal1Bottom.setRotationPoint(0F, 0F, 0F);
	      coal1Bottom.setTextureSize(128, 64);
	      coal1Bottom.mirror = true;
	      setRotation(coal1Bottom, 0F, 0F, 0F);
	      coal2Bottom = new ModelRenderer(this, 43, 28);
	      coal2Bottom.addBox(-6F, 1F, -3F, 12, 1, 5);
	      coal2Bottom.setRotationPoint(0F, 0F, 0F);
	      coal2Bottom.setTextureSize(128, 64);
	      coal2Bottom.mirror = true;
	      setRotation(coal2Bottom, 0F, 0F, 0F);
	      coal2Mid = new ModelRenderer(this, 78, 27);
	      coal2Mid.addBox(-6F, 0F, -2F, 12, 1, 7);
	      coal2Mid.setRotationPoint(0F, 0F, 0F);
	      coal2Mid.setTextureSize(128, 64);
	      coal2Mid.mirror = true;
	      setRotation(coal2Mid, 0F, 0F, 0F);
	      coal2Top = new ModelRenderer(this, 78, 17);
	      coal2Top.addBox(-6F, -1F, -1F, 12, 1, 9);
	      coal2Top.setRotationPoint(0F, 0F, 0F);
	      coal2Top.setTextureSize(128, 64);
	      coal2Top.mirror = true;
	      setRotation(coal2Top, 0F, 0F, 0F);
	      coal3Bottom = new ModelRenderer(this, 78, 53);
	      coal3Bottom.addBox(-6F, -2F, 2F, 12, 1, 9);
	      coal3Bottom.setRotationPoint(0F, 0F, 0F);
	      coal3Bottom.setTextureSize(128, 64);
	      coal3Bottom.mirror = true;
	      setRotation(coal3Bottom, 0F, 0F, 0F);
	      coal3Top = new ModelRenderer(this, 78, 35);
	      coal3Top.addBox(-6F, -4F, 4F, 12, 1, 7);
	      coal3Top.setRotationPoint(0F, 0F, 0F);
	      coal3Top.setTextureSize(128, 64);
	      coal3Top.mirror = true;
	      setRotation(coal3Top, 0F, 0F, 0F);
	      coal3Mid = new ModelRenderer(this, 78, 43);
	      coal3Mid.addBox(-6F, -3F, 2F, 12, 1, 9);
	      coal3Mid.setRotationPoint(0F, 0F, 0F);
	      coal3Mid.setTextureSize(128, 64);
	      coal3Mid.mirror = true;
	      setRotation(coal3Mid, 0F, 0F, 0F);
	      coal3Front = new ModelRenderer(this, 43, 24);
	      coal3Front.addBox(-6F, -2F, 0F, 12, 1, 2);
	      coal3Front.setRotationPoint(0F, 0F, 0F);
	      coal3Front.setTextureSize(128, 64);
	      coal3Front.mirror = true;
	      setRotation(coal3Front, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int items)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    GL11.glRotatef(90, 0, 1, 0);
	    wheelRearRightRear.render(f5);
	    wheelRearLeftRear.render(f5);
	    wheelRearLeftFront.render(f5);
	    wheelRearRightFront.render(f5);
	    wheelRear.render(f5);
	    wheelFrontLeftFront.render(f5);
	    wheelFront.render(f5);
	    wheelFrontRightFront.render(f5);
	    cartBottom.render(f5);
	    topFront.render(f5);
	    topRear.render(f5);
	    topRight.render(f5);
	    topLeft.render(f5);
	    if (items > 0)
	    {
	    	coal1Mid.render(f5);
	    	coal1Top.render(f5);
	    	coal1Bottom.render(f5);
	    }
	    if (items > 3)
	    {
	    	coal2Bottom.render(f5);
	    	coal2Mid.render(f5);
	    	coal2Top.render(f5);
	    }
	    if (items > 6)
	    {
	    	coal3Bottom.render(f5);
	    	coal3Top.render(f5);
	    	coal3Mid.render(f5);
	    	coal3Front.render(f5);
	    }	    	    
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  }

	}
