package mods.railcraft_cos.common.entity.item;

import java.util.ArrayList;
import java.util.List;

import mods.railcraft.common.util.inventory.InvTools;
import mods.railcraft.common.util.misc.Game;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityModelledChestCart extends EntityMinecartContainer implements ISidedInventory
{	
    private String entityName;
    private short cart = 0;
    private static final int[] SLOTS = InvTools.buildSlotArray(0, 9);

	public EntityModelledChestCart(World world)
    {
        super(world);
    }

    public EntityModelledChestCart(World world, double x, double y, double z, short cartType)
    {
        super(world, x, y, z);
        this.setCustomCartType(cartType);
        this.cart = cartType;
    }
    
    public int countItems()
    {
    	int items = 0;
    	if (this != null)
    	{    		
    		for (int i1 = 0; i1 < this.getSizeInventory(); ++i1)
    		{
    			ItemStack itemstack = this.getStackInSlot(i1);
    			if(itemstack != null)
    			{
    				items = items + 1;
    			}
    		}
    	}
    	return items;
    }
    
    @Override
    protected void entityInit() 
    {
    	super.entityInit();
    	this.dataWatcher.addObject(23, cart);
    	this.dataWatcher.addObject(24, 0);
    }
    
    public List<ItemStack> getItemsDropped() {
        List<ItemStack> items = new ArrayList<ItemStack>();
        items.add(getCartItem());
        return items;
    }

    @Override
    public void killMinecart(DamageSource par1DamageSource) {
        setDead();
        List<ItemStack> drops = getItemsDropped();
        if (this.func_95999_t() != null)
            drops.get(0).setStackDisplayName(this.func_95999_t());
        for (ItemStack item : drops) {
            entityDropItem(item, 0.0F);
        }
    }
    
    @Override
    public ItemStack getCartItem()
    {
    	return new ItemStack(ItemRailcraftCos.ModelledChestCartQuarry);
    }
    
    protected void readEntityFromNBT(NBTTagCompound tag)
    {
    	super.readEntityFromNBT(tag);
        if (tag.getBoolean("CustomDisplayTile"))
        {
            this.func_145819_k(tag.getInteger("DisplayTile"));
            this.setDisplayTileData(tag.getInteger("DisplayData"));
            this.setDisplayTileOffset(tag.getInteger("DisplayOffset"));
        }
        if (tag.hasKey("CustomName", 8) && tag.getString("CustomName").length() > 0)
        {
            this.entityName = tag.getString("CustomName");
        }        
        this.setCustomCartType(tag.getShort("CustomType"));
        this.dataWatcher.updateObject(24, this.countItems());
    }
    
    protected void writeEntityToNBT(NBTTagCompound tag)
    {
    	super.writeEntityToNBT(tag);
        if (this.hasDisplayTile())
        {
            tag.setBoolean("CustomDisplayTile", true);
            tag.setInteger("DisplayTile", this.func_145820_n().getMaterial() == Material.air ? 0 : Block.getIdFromBlock(this.func_145820_n()));
            tag.setInteger("DisplayData", this.getDisplayTileData());
            tag.setInteger("DisplayOffset", this.getDisplayTileOffset());
        }
        if (this.entityName != null && this.entityName.length() > 0)
        {
            tag.setString("CustomName", this.entityName);
        }        
        tag.setShort("CustomType", getCustomCartType());
    }
    
    public int getSizeInventory()
    {
    	switch(this.getCustomCartType())
        {
	        case(0):
	        case(2):
	        	return 9;
	        case(3):
	        case(4):
	        	return 0;
	        default:
	        	return 9;
        }
    }

    public int getMinecartType()
    {
        return -1;
    }
    
    public void setCustomCartType(short cartType) 
    {
    	this.dataWatcher.updateObject(23, Short.valueOf(cartType));
    }
    
    public short getCustomCartType() 
    {
    	return this.dataWatcher.getWatchableObjectShort(23);
    }
    
    public int getItemCount()
    {
    	return this.dataWatcher.getWatchableObjectInt(24);
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }
    
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item)
    {
        switch(this.getCustomCartType())
        {
        case(0):
        	return true;
        case(2):
        {
        	if (item != null)
        	{
        		Item log = item.getItem();
        		if (log == Item.getItemFromBlock(Blocks.log) || log == Item.getItemFromBlock(Blocks.log2) )
        		{
        			return true;
        		}
        		//needs to be added: Forestry woods etc.
        	}
        	return false;
        	
        	
        }
        case(3):
        case(4):
        {
        	return false;
        }
        default:
        	return true;
        }
    }
    
    public void onUpdate()
    {
    	super.onUpdate();
    	if (Game.isHost(worldObj))
    	{
    		this.dataWatcher.updateObject(24, this.countItems());
    	}
    }

    public boolean canInsertItem(int slot, ItemStack stack, int side)
    {
        return isItemValidForSlot(slot, stack);
    }

	@Override
	public int[] getAccessibleSlotsFromSide(int side) 
	{
		return SLOTS;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) 
	{
		return true;
	}
	
	@Override
	public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.entityName : "entity.railcraft_cos.modelledchestcart." + Short.toString(this.getCustomCartType()) + ".name";
    }
    
}