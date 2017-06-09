package mods.railcraft_cos.common.blocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import mods.railcraft_cos.common.core.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;

public class RailcraftCosTrackRenderer implements ISimpleBlockRenderingHandler 
{	
	BlockRailBase rail = (BlockRailBase) Blocks.rail;
	//BlockSnow snow = (BlockSnow) Blocks.snow_layer;
	BlockTallGrass grass = new BlockTallGrass() 
	{
		public int getRenderColor(int p_149741_1_)
		{ 
			return ColorizerGrass.getGrassColor(0.5D, 1.0D);
		}
		public int colorMultiplier(IBlockAccess world, int x, int y, int z) 
		{ 
			return world.getBiomeGenForCoords(x, z).getBiomeGrassColor(z, y, z);
		}
		public IIcon getIcon(int a, int b)
		{
			return Blocks.tallgrass.getIcon(a, b);
		}
	};
	BlockWeb cobweb = new BlockWeb() {};

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) 
	{}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) 
	{
		if (block instanceof BlockRailcraftCosTrackCobweb)
		{
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(Blocks.web, 0, 1));
			renderer.renderBlockByRenderType(cobweb, x, y, z);
		}
		else if (block instanceof BlockRailcraftCosTrack)
		{
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(Blocks.tallgrass, 0, 1));
			renderer.renderBlockByRenderType(grass, x, y, z);
		}
		/*else if (block instanceof BlockRailcraftCosTrackSnow)
		{
			//it render glitches, we will need probably our own texture than putting two together
			renderer.overrideBlockBounds(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(Blocks.snow_layer, 0, 1));
			renderer.renderBlockByRenderType(snow, x, y, z);
			renderer.unlockBlockBounds();
		}*/
        
        renderer.clearOverrideBlockTexture();
		renderer.renderBlockMinecartTrack(rail, x, y, z);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.railcraftCosTrackRenderer;
	}

	
	
}
