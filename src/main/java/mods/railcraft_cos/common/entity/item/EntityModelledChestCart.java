package mods.railcraft_cos.common.entity.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityModelledChestCart extends EntityMinecartContainer
{
	
    private String entityName;

	public EntityModelledChestCart(World p_i1714_1_)
    {
        super(p_i1714_1_);
    }

    public EntityModelledChestCart(World p_i1715_1_, double p_i1715_2_, double p_i1715_4_, double p_i1715_6_, short Type)
    {
        super(p_i1715_1_, p_i1715_2_, p_i1715_4_, p_i1715_6_);
        this.setCustomCartType(Type);
    }
    
    @Override
    protected void entityInit() {
    	super.entityInit();
    	this.dataWatcher.addObject(23, Short.valueOf((short) 0));
    }
    
    public void killMinecart(DamageSource p_94095_1_)
    {
        super.killMinecart(p_94095_1_);
    }

    protected void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        if (p_70037_1_.getBoolean("CustomDisplayTile"))
        {
            this.func_145819_k(p_70037_1_.getInteger("DisplayTile"));
            this.setDisplayTileData(p_70037_1_.getInteger("DisplayData"));
            this.setDisplayTileOffset(p_70037_1_.getInteger("DisplayOffset"));
        }

        if (p_70037_1_.hasKey("CustomName", 8) && p_70037_1_.getString("CustomName").length() > 0)
        {
            this.entityName = p_70037_1_.getString("CustomName");
        }
        
        this.setCustomCartType(p_70037_1_.getShort("CustomType"));
    }
    
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        if (this.hasDisplayTile())
        {
            p_70014_1_.setBoolean("CustomDisplayTile", true);
            p_70014_1_.setInteger("DisplayTile", this.func_145820_n().getMaterial() == Material.air ? 0 : Block.getIdFromBlock(this.func_145820_n()));
            p_70014_1_.setInteger("DisplayData", this.getDisplayTileData());
            p_70014_1_.setInteger("DisplayOffset", this.getDisplayTileOffset());
        }

        if (this.entityName != null && this.entityName.length() > 0)
        {
            p_70014_1_.setString("CustomName", this.entityName);
        }
        
        p_70014_1_.setShort("CustomType", getCustomCartType());
    }
    
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return 9;
    }

    public int getMinecartType()
    {
        return -1;
    }
    
    public void setCustomCartType(short Type) {
    	this.dataWatcher.updateObject(23, Short.valueOf(Type));
    }
    
    public short getCustomCartType() {
    	return this.dataWatcher.getWatchableObjectShort(23);
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }
}