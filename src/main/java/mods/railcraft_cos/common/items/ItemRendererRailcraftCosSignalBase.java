package mods.railcraft_cos.common.items;

import org.lwjgl.opengl.GL11;

import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.CosSignalBannerModel;
import mods.railcraft_cos.common.models.CosSignalSemaphoreModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRendererRailcraftCosSignalBase implements IItemRenderer {

	private float scale = 1.2F;
	private ModelBase model;
	private static ModelBase modelArray[] = 
			{	new CosSignalBannerModel(),
				new CosSignalSemaphoreModel(0, 0)	
			};
	private ResourceLocation texture;
	private ResourceLocation textureArray[] =
			{	new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalbanner.png"),
				new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalsemaphore.png"),
				new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalsemaphoredistant.png")
			};
	
	public ItemRendererRailcraftCosSignalBase(EnumCosSignalType type) {
		switch(type) {
		case BANNER_REPEATER:
			model = modelArray[0];
			texture = textureArray[0];
			break;
		case SEMAPHORE_STOP:
			model = modelArray[1];
			texture = textureArray[1];
			break;
		case SEMAPHORE_REPEATER:
			model = modelArray[1];
			texture = textureArray[2];
			break;
		case SEMAPHORE_REPEATER_ALT:
			model = modelArray[1];
			texture = textureArray[1];
			break;
		default:
			model = modelArray[1];
			texture = textureArray[1];
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
			case FIRST_PERSON_MAP:
				break;
		default:
			break;
		}
	}
}
