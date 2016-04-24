package mods.railcraft_cos.common.tileentities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class TESRSignBasic extends TileEntitySpecialRenderer {
	
	private TileEntityRailcraftSignBasic ter;
	
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
                ter = (TileEntityRailcraftSignBasic) te;
                Minecraft.getMinecraft().renderEngine.bindTexture(ter.getResource());
                
                int meta = te.getBlockMetadata();
                GL11.glRotatef((meta * (-90)), 0.0F, 1.0F, 0.0F);
                
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                
                ter.getModel().render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                
                GL11.glPopMatrix();
                GL11.glPopMatrix();
	}
}
