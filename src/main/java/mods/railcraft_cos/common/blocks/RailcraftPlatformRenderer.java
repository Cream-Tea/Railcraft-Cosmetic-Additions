package mods.railcraft_cos.common.blocks;

import org.lwjgl.opengl.GL11;

import mods.railcraft_cos.common.core.ClientProxy;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RailcraftPlatformRenderer implements ISimpleBlockRenderingHandler {
	
	private final Tessellator tessellator = Tessellator.instance;
	
	public RailcraftPlatformRenderer() {
		Minecraft.getMinecraft();
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer) {
		
			block.setBlockBoundsForItemRender();
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		        tessellator.startDrawingQuads();
		        tessellator.setNormal(0.0F, -1.0F, 0.0F);
		        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 0));
		        tessellator.draw();
		        tessellator.startDrawingQuads();
		        tessellator.setNormal(0.0F, 1.0F, 0.0F);
		        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 1));
		        tessellator.draw();
		        tessellator.startDrawingQuads();
		        tessellator.setNormal(0.0F, 0.0F, -1.0F);
		        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 2));
		        tessellator.draw();
		        tessellator.startDrawingQuads();
		        tessellator.setNormal(0.0F, 0.0F, 1.0F);
		        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 3));
		        tessellator.draw();
		        tessellator.startDrawingQuads();
		        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 4));
		        tessellator.draw();
		        tessellator.startDrawingQuads();
		        tessellator.setNormal(1.0F, 0.0F, 0.0F);
		        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 5));
		        tessellator.draw();
		        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		if(((BlockRailcraftPlatform) block).getPlatformType() != 3) {
			switch(world.getBlockMetadata(x, y, z)) {
			case 0:
				renderer.setRenderBounds(0.0D, 0.0D, 0.2D, 1.0D, 0.75D, 1.0D);
				break;
			case 1:
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 0.8D, 0.75D, 1.0D);
				break;
			case 2:
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 0.8D);
				break;
			case 3:
				renderer.setRenderBounds(0.2D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
				break;
			}
		} else {
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
		}
		
		if(((BlockRailcraftPlatform) block).getPlatformType() == 2) {
			if(world.getBlockMetadata(x, y, z) == 1 || world.getBlockMetadata(x, y, z) == 3)
				renderer.uvRotateTop = 1;
		}
		
		renderer.renderStandardBlock(block, x, y, z);
		renderer.uvRotateTop = 0;
		
		renderer.setOverrideBlockTexture(block.getIcon(0, 0));
		
		if(world.getBlock(x, y + 1, z) instanceof BlockFence) {
			renderer.setRenderBounds(0.3D, 0.75D, 0.3D, 0.7D, 1.0D, 0.7D);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(((BlockRailcraftPlatform) block).getPlatformType() == 3) {
			switch(world.getBlockMetadata(x, y, z)) {
			case 0:
				renderer.setRenderBounds(0.0D, 0.75D, 0.25D, 1.0D, 1.0D, 1.0D);	
				break;
			case 1:
				renderer.setRenderBounds(0.0D, 0.75D, 0.0D, 0.75D, 1.0D, 1.0D);
				break;
			case 2:
				renderer.setRenderBounds(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 0.75D);
				break;
			case 3:
				renderer.setRenderBounds(0.25D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
			}
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		renderer.clearOverrideBlockTexture();	
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.railcraftPlatformRenderer;
	}
	
}
