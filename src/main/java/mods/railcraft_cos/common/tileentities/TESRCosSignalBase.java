package mods.railcraft_cos.common.tileentities;

import org.lwjgl.opengl.GL11;

import mods.railcraft.api.signals.IControllerTile;
import mods.railcraft.api.signals.IReceiverTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TESRCosSignalBase extends TileEntitySpecialRenderer {
	
	private ModelBase model;
	
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        //The PushMatrix tells the renderer to "start" doing something.
                GL11.glPushMatrix();
        //This is setting the initial location.
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
                //Outdated bindTextureByName("/mods/roads/textures/blocks/TrafficLightPoleRed.png");
       //Use in 1.6.2  this
        //the ':' is very important
        //binding the textures
                if(te instanceof IReceiverTile) {
                	Minecraft.getMinecraft().renderEngine.bindTexture(((TileEntityRailcraftCosSignalDistant)te).getResource());
                	model = ((TileEntityRailcraftCosSignalDistant)te).getModel();
                } else if (te instanceof IControllerTile) {
                	Minecraft.getMinecraft().renderEngine.bindTexture(((TileEntityRailcraftCosSignalBlock)te).getResource());
                	model = ((TileEntityRailcraftCosSignalBlock)te).getModel();
                }
        //Rotate the entity according to the metadata.
                int meta = te.getBlockMetadata();
                GL11.glRotatef((meta * (-90)), 0.0F, 1.0F, 0.0F);
        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                      
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //A reference to your Model file. Again, very important.
                model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        //Tell it to stop rendering for both the PushMatrix's
                GL11.glPopMatrix();
                GL11.glPopMatrix();
	}
}
