package mods.railcraft_cos.common.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrainOperatorChest extends ModelBiped
{
  //fields
    ModelRenderer LeftArmPart;
    ModelRenderer RightArmPart;
    ModelRenderer BodyPart;
  
  public ModelTrainOperatorChest(float f)
  {
    textureWidth = 64;
    textureHeight = 64;
    
      LeftArmPart = new ModelRenderer(this, 0, 21);
      LeftArmPart.addBox(-1F, -3F, -3F, 5, 8, 6);
      LeftArmPart.setRotationPoint(0F, 0F, 0F);
      LeftArmPart.setTextureSize(64, 64);
      LeftArmPart.mirror = true;
      setRotation(LeftArmPart, 0F, 0F, 0F);
      RightArmPart = new ModelRenderer(this, 23, 21);
      RightArmPart.addBox(-4F, -3F, -3F, 5, 8, 6);
      RightArmPart.setRotationPoint(0F, 0F, 0F);
      RightArmPart.setTextureSize(64, 64);
      RightArmPart.mirror = true;
      setRotation(RightArmPart, 0F, 0F, 0F);
      BodyPart = new ModelRenderer(this, 0, 0);
      BodyPart.addBox(-5F, -1F, -3F, 10, 12, 6);
      BodyPart.setRotationPoint(0F, 0F, 0F);
      BodyPart.setTextureSize(64, 64);
      BodyPart.mirror = true;
      setRotation(BodyPart, 0F, 0F, 0F);
      this.bipedBody.addChild(BodyPart);
      this.bipedLeftArm.addChild(LeftArmPart);
      this.bipedRightArm.addChild(RightArmPart);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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