package mods.railcraft_cos.common.items;

import org.lwjgl.opengl.GL11;

import mods.railcraft_cos.common.blocks.EnumSignBasicType;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.CosSignBasicModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRendererRailcraftSignBasic implements IItemRenderer {

	private float scale = 1.2F;
	private final ModelBase model = new CosSignBasicModel();
	private ResourceLocation texture;
	
	public ItemRendererRailcraftSignBasic(EnumSignBasicType type) {
		switch(type) {
		case WHISTLE:
			texture = new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.whistle.png");
			break;
		case MPH5:
			texture =  new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.mph5.png");
			break;
		case CLEARANCE:
			texture =  new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.clearance.png");
			break;
		case REFUGE:
			texture =  new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.refuge.png");
		}
	}
	
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
		ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		switch(type) {
			case INVENTORY:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(-0.5F, -0.5F, 0.5F);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(0.6F, -2.0F, -0.4F);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(90, 0, 1, 0);
				GL11.glTranslatef(0.6F, -2.0F, -0.4F);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			case ENTITY:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(0.0F, -1.0F, 0.0F);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
		}
	}
}
