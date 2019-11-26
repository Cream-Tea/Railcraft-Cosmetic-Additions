package mods.railcraft_cos.common.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlatform extends ModelPlatformBase
	{
	  //fields
    ModelRenderer center;
    ModelRenderer outerRight;
    ModelRenderer outerLeft;
    ModelRenderer outerBack;
    ModelRenderer outerFront;
    ModelRenderer cornerRightFront;
    ModelRenderer cornerRightBack;
    ModelRenderer cornerLeftFront;
    ModelRenderer cornerLeftBack;
    ModelRenderer topBig;
    ModelRenderer topSmall;
  
  public ModelPlatform()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      center = new ModelRenderer(this, 0, 0);
      center.addBox(-5F, -4F, -5F, 10, 12, 10);
      center.setRotationPoint(0F, 16F, 0F);
      center.setTextureSize(64, 64);
      center.mirror = true;
      setRotation(center, 0F, 0F, 0F);
      outerRight = new ModelRenderer(this, 0, 36);
      outerRight.addBox(5F, -4F, -5F, 3, 12, 10);
      outerRight.setRotationPoint(0F, 16F, 0F);
      outerRight.setTextureSize(64, 64);
      outerRight.mirror = true;
      setRotation(outerRight, 0F, 0F, 0F);
      outerLeft = new ModelRenderer(this, 0, 36);
      outerLeft.addBox(-8F, -4F, -5F, 3, 12, 10);
      outerLeft.setRotationPoint(0F, 16F, 0F);
      outerLeft.setTextureSize(64, 64);
      outerLeft.mirror = true;
      setRotation(outerLeft, 0F, 0F, 0F);
      outerBack = new ModelRenderer(this, 26, 36);
      outerBack.addBox(-5F, -4F, 5F, 10, 12, 3);
      outerBack.setRotationPoint(0F, 16F, 0F);
      outerBack.setTextureSize(64, 64);
      outerBack.mirror = true;
      setRotation(outerBack, 0F, 0F, 0F);
      outerFront = new ModelRenderer(this, 26, 36);
      outerFront.addBox(-5F, -4F, -8F, 10, 12, 3);
      outerFront.setRotationPoint(0F, 16F, 0F);
      outerFront.setTextureSize(64, 64);
      outerFront.mirror = true;
      setRotation(outerFront, 0F, 0F, 0F);
      cornerRightFront = new ModelRenderer(this, 40, 0);
      cornerRightFront.addBox(5F, -4F, -8F, 3, 12, 3);
      cornerRightFront.setRotationPoint(0F, 16F, 0F);
      cornerRightFront.setTextureSize(64, 64);
      cornerRightFront.mirror = true;
      setRotation(cornerRightFront, 0F, 0F, 0F);
      cornerRightBack = new ModelRenderer(this, 40, 0);
      cornerRightBack.addBox(5F, -4F, 5F, 3, 12, 3);
      cornerRightBack.setRotationPoint(0F, 16F, 0F);
      cornerRightBack.setTextureSize(64, 64);
      cornerRightBack.mirror = true;
      setRotation(cornerRightBack, 0F, 0F, 0F);
      cornerLeftFront = new ModelRenderer(this, 52, 0);
      cornerLeftFront.addBox(-8F, -4F, -8F, 3, 12, 3);
      cornerLeftFront.setRotationPoint(0F, 16F, 0F);
      cornerLeftFront.setTextureSize(64, 64);
      cornerLeftFront.mirror = true;
      setRotation(cornerLeftFront, 0F, 0F, 0F);
      cornerLeftBack = new ModelRenderer(this, 52, 0);
      cornerLeftBack.addBox(-8F, -4F, 5F, 3, 12, 3);
      cornerLeftBack.setRotationPoint(0F, 16F, 0F);
      cornerLeftBack.setTextureSize(64, 64);
      cornerLeftBack.mirror = true;
      setRotation(cornerLeftBack, 0F, 0F, 0F);
      topBig = new ModelRenderer(this, 0, 22);
      topBig.addBox(-5F, -8F, -5F, 10, 4, 10);
      topBig.setRotationPoint(0F, 16F, 0F);
      topBig.setTextureSize(64, 64);
      topBig.mirror = true;
      setRotation(topBig, 0F, 0F, 0F);
      topSmall = new ModelRenderer(this, 40, 15);
      topSmall.addBox(-3F, -8F, -3F, 6, 4, 6);
      topSmall.setRotationPoint(0F, 16F, 0F);
      topSmall.setTextureSize(64, 64);
      topSmall.mirror = true;
      setRotation(topSmall, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int type, short top)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    center.render(f5);
    outerRight.render(f5);
    outerLeft.render(f5);
    outerBack.render(f5);
    outerFront.render(f5);
    cornerRightFront.render(f5);
    cornerRightBack.render(f5);
    cornerLeftFront.render(f5);
    cornerLeftBack.render(f5);
    topBig.render(f5);
    topSmall.render(f5);
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