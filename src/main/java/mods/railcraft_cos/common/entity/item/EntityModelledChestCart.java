package mods.railcraft_cos.common.entity.item;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft.common.util.inventory.InvTools;
import mods.railcraft.common.util.misc.Game;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityModelledChestCart extends EntityMinecartContainer implements ISidedInventory
{	
    private String entityName;
    private short cart;
    public short colour = 0;
    private static final int[] SLOTS1 = InvTools.buildSlotArray(0, 1);
    private static final int[] SLOTS9 = InvTools.buildSlotArray(0, 9);
    private static final int[] SLOTS36 = InvTools.buildSlotArray(0, 36);

	public EntityModelledChestCart(World world)
    {
        super(world);
    }

    public EntityModelledChestCart(World world, double x, double y, double z, short cartType, int color)
    {
        super(world, x, y, z);
        this.setCustomCartType(cartType);
        this.cart = cartType;
        if (cartType == 5)
        {
        	this.setColor((short) color);
        	this.colour = (short) color;
        }
        
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
    	this.dataWatcher.addObject(24, Short.valueOf(colour));
    	this.dataWatcher.addObject(29, 0);
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
    	switch(this.getCustomCartType())
        {
	        case(0):
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartQuarry);
	        case(2):
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartWood);
	        case(3):
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartEmpty);
	        case(4):
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartPanzer);
	        case(5):
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartContainer);
	        case(6):
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartTender);
	        default:
	        	return new ItemStack(ItemRailcraftCos.ModelledChestCartEmpty);
        }   	
    }
    
    protected void readEntityFromNBT(NBTTagCompound tag)
    {   short type = tag.getShort("CustomType");
        this.setCustomCartType(type);
        this.cart = type;
        this.dataWatcher.updateObject(29, this.countItems());
        if (type == 5 && tag.hasKey("Colour"))
        {
        	this.setColor(tag.getShort("Colour"));
        }
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
        short type = getCustomCartType();
        tag.setShort("CustomType", type);
        if (type == 5)
        {
        	tag.setShort("Colour", getColor());
        }
    }
    
    public short getColor() 
    {
    	return this.dataWatcher.getWatchableObjectShort(24);
    }
    
    public void setColor(short color) 
    {
    	this.dataWatcher.updateObject(24, Short.valueOf(color));
    }
    
    @Override
    public int getSizeInventory()
    {
    	switch(this.getCustomCartType())
        {
	        case(0):
	        case(2):
	        case(6):
	        	return 9;
	        case(3):
	        case(4):
	        	return 0;
	        case(5):
	        	return 36;
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
    	return this.dataWatcher.getWatchableObjectInt(29);
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
        case(5):
        	return true;
        case(2):
        {
        	if (item != null)
        	{
        		return isWood(item);
        	}
        	return false;       	
        }
        case(6):
        {
        	if (item != null && GameRegistry.getFuelValue(item) > 0)
        	{
        		return true;
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
    		this.dataWatcher.updateObject(29, this.countItems());
    	}
    }

    public boolean canInsertItem(int slot, ItemStack stack, int side)
    {
        return isItemValidForSlot(slot, stack);
    }

	@Override
	public int[] getAccessibleSlotsFromSide(int side) 
	{
		switch(this.getCustomCartType())
        {
        	case(0):
        	case(2):
        	case(6):
        		return SLOTS9;
        	case(3):
        	case(4):
        		return SLOTS1;
        	case(5):
        		return SLOTS36;
        	default:
        		return SLOTS9;
        }
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) 
	{
		return true;
	}
	
	@Override
	public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.entityName : "entity.railcraft_cos.cart." + Short.toString(this.getCustomCartType()) + ".name";
    }
	
	public boolean isWood(ItemStack stack)
    {
    	int[] array = OreDictionary.getOreIDs(stack);
    	int size = array.length;
    	int wood = OreDictionary.getOreID("logWood");
    	boolean isIn = false;
    	if (size > 0)
    	{
    		for (int i = 0; i < size; i++)
	    	{
	    		if (array[i] == wood)
	    		{
	    			isIn = true;
	    			break;
	    		}
	    	}
    	}    	
    	return isIn;
    }
	
    
}