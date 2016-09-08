package mods.railcraft_cos.common.entity.item;

import mods.railcraft.common.carts.EntityCartTank;
import mods.railcraft.common.carts.EnumCart;
import mods.railcraft.common.carts.ICartType;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityModelledTankCart extends EntityCartTank
{   
    public EntityModelledTankCart(World world) 
    {
		super(world);		
	}
    
    public EntityModelledTankCart(World world, double x, double y, double z, short cartType)
    {    	
        super(world, x, y, z);
        this.setCustomCartType(cartType);
    }
    
    @Override
    public ICartType getCartType() 
    {
        return EnumCart.TANK;
    }

    @Override
    protected void entityInit() 
    {
    	super.entityInit();
    	this.dataWatcher.addObject(23, Short.valueOf((short) 1));
    }
    
    @Override
    public ItemStack getCartItem()
    {
    	return new ItemStack(ItemRailcraftCos.ModelledTankCart);
    }
    
    public void setCustomCartType(short cartType) 
    {
    	this.dataWatcher.updateObject(23, Short.valueOf(cartType));
    }
    
    public short getCustomCartType() 
    {
    	return this.dataWatcher.getWatchableObjectShort(23);
    }   
}
