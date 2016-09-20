package mods.railcraft_cos.common.items;

import java.util.Random;

import com.mojang.authlib.GameProfile;

import mods.railcraft.api.carts.CartTools;
import mods.railcraft.api.core.items.IMinecartItem;
import mods.railcraft.common.blocks.tracks.TrackTools;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.entity.item.EntityModelledChestCart;
import mods.railcraft_cos.common.entity.item.EntityModelledTankCart;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemModelled extends Item implements IMinecartItem
{
	private short type;    
    public int minecartType;

    public ItemModelled(String unlocalizedName, short cartType) 
    {
    	this.type = cartType;
        this.maxStackSize = 3;
        this.minecartType = -1;
        this.setCreativeTab(Railcraft_Cos.tabRailcraftCos);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Railcraft_Cos.MODID + ":" + "cart.modelled." + Short.toString(type));
        BlockDispenser.dispenseBehaviorRegistry.putObject(this, null);        
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
    	Block block = world.getBlock(x, y, z);
        if (TrackTools.isRailBlock(block))
        {
            if (!world.isRemote)
            {            	
            	switch(type)
            	{
            		case(0):
            		case(2):
            		case(3):
            		case(4):
            		case(5):
            		{
            			int rand = new Random().nextInt(9);
            			EntityModelledChestCart entityminecart = new EntityModelledChestCart(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), type, rand);                        
            			if (item.hasDisplayName())
                        {
                            entityminecart.setMinecartName(item.getDisplayName());
                        }
                        world.spawnEntityInWorld(entityminecart);
                        --item.stackSize;
                        return true;
            		}
            		case(1):
            		{
            			int rand = new Random().nextInt(9);
            			EntityModelledTankCart entitytankminecart = new EntityModelledTankCart(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), type, rand);                        
            			if (item.hasDisplayName())
                        {
                            entitytankminecart.setMinecartName(item.getDisplayName());
                        }
                        world.spawnEntityInWorld(entitytankminecart);
                        --item.stackSize;
                        return true;
            		}
            		default:
            		{
            			return false;
            		}            			
            	}
            }            
        }        
        return false;		
    }

	@Override
	public boolean canBePlacedByNonPlayer(ItemStack paramItemStack) 
	{
		return true;
	}

	@Override
	public EntityMinecart placeCart(GameProfile owner, ItemStack item, World world, int x, int y, int z) 
	{		
	 	Block block = world.getBlock(x, y, z);
	 	if ((TrackTools.isRailBlock(block)) && (!CartTools.isMinecartAt(world, x, y, z, 0.0F))) 
		{
	 		switch(type)
            {
        		case(0):
        		case(2):
        		case(3):
        		case(4):
        		case(5):
        		{
        			int rand = new Random().nextInt(9);
        			EntityModelledChestCart cart = new EntityModelledChestCart(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), type, rand);                        
        			if (item.hasDisplayName())
                    {
                        cart.setMinecartName(item.getDisplayName());
                    }
        			CartTools.setCartOwner(cart, owner);
                    if (world.spawnEntityInWorld(cart))
                    	return cart;
        		}
        		case(1):
        		{
        			int rand = new Random().nextInt(9);
        			EntityModelledTankCart cart = new EntityModelledTankCart(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), type, rand);                        
        			if (item.hasDisplayName())
                    {
                        cart.setMinecartName(item.getDisplayName());
                    }
        			CartTools.setCartOwner(cart, owner);
                    if (world.spawnEntityInWorld(cart))	                       
                    	return cart;
        		}
        		default:
        		{
        			return null;
        		}            			
            } 
	    }
		return null;
	}
}
