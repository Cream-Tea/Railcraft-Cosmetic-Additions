package mods.railcraft_cos.common.entity.item;

import mods.railcraft.common.carts.EntityCartTank;
import mods.railcraft.common.carts.EnumCart;
import mods.railcraft.common.carts.ICartType;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityModelledTankCart extends EntityCartTank
{   
	public short colour;
	
    public EntityModelledTankCart(World world) 
    {
		super(world);		
	}
    
    public EntityModelledTankCart(World world, double x, double y, double z, short cartType, int color)
    {    	
        super(world, x, y, z);
        this.setCustomCartType(cartType);
        this.setColor((short) color);
        this.colour = (short) color;
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
    	this.dataWatcher.addObject(24, Short.valueOf(colour ));
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
    
    public void setColor(short color) 
    {
    	this.dataWatcher.updateObject(24, Short.valueOf(color));
    }
    
    public short getCustomCartType() 
    {
    	return this.dataWatcher.getWatchableObjectShort(23);
    } 
    
    public short getColor() 
    {
    	return this.dataWatcher.getWatchableObjectShort(24);
    } 
    
    protected void readEntityFromNBT(NBTTagCompound tag)
    {     
    	super.readEntityFromNBT(tag);
    	this.setColor(tag.getShort("Colour"));
    }
       
    protected void writeEntityToNBT(NBTTagCompound tag)
    {
    	super.writeEntityToNBT(tag);
    	tag.setShort("Colour", getColor());
    }
}
