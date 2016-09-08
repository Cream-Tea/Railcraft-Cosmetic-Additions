package mods.railcraft_cos.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.core.ClientProxy;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class TrainOperatorUniform extends ItemArmor
{

	private String textureName;

	public TrainOperatorUniform(String unlocalizedName, ArmorMaterial material, String textureName, int type) 
	{
	    super(material, 0, type);
	    this.textureName = textureName;
	    this.setUnlocalizedName(unlocalizedName);
	    this.setTextureName(Railcraft_Cos.MODID + ":" + unlocalizedName);
	    this.setCreativeTab(Railcraft_Cos.tabRailcraftCos);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return Railcraft_Cos.MODID + ":textures/armor/" + this.textureName + ".png";
	}
	
	@Override 
	@SideOnly(Side.CLIENT) 
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		 ModelBiped armorModel = null; 
		 if(itemStack != null)
		 {  
			 armorModel = ClientProxy.getArmorModel(armorSlot); 			 
			 if(armorModel != null)
			 { 	armorModel.bipedHead.showModel = armorSlot == 0; 
			 	armorModel.bipedHeadwear.showModel = armorSlot == 0; 
			 	armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2; 
			 	armorModel.bipedRightArm.showModel = armorSlot == 1; 
			 	armorModel.bipedLeftArm.showModel = armorSlot == 1; 
			 	armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3; 
			 	armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3; 
			 	armorModel.isSneak = entityLiving.isSneaking(); 
			 	armorModel.isRiding = entityLiving.isRiding(); 
			 	armorModel.isChild = entityLiving.isChild(); 
			 	armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0; 
			 	if(entityLiving instanceof EntityPlayer)
			 	{ armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2; 
			 	} 			  
			 }
		 }
		return armorModel;
	}
}



	
	

	

	

	
