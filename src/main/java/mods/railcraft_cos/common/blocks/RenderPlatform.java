package mods.railcraft_cos.common.blocks;

import org.lwjgl.opengl.GL11;

import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.ModelPlatform;
import mods.railcraft_cos.common.models.ModelPlatformBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderPlatform extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation(Railcraft_Cos.MODID + ":" + "textures/models/Platform.png");

	private ModelPlatformBase model = new ModelPlatform();
	
	public RenderPlatform()
	{
		this.model = new ModelPlatform();
	}

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef( (float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		//this.model.renderModel(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, type, top);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		
	}
}