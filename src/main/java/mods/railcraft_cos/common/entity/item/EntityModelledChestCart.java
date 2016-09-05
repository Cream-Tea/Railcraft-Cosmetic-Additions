package mods.railcraft_cos.common.entity.item;

import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityModelledChestCart extends EntityMinecartContainer
{

	private short type = 0;
	
    public EntityModelledChestCart(World p_i1714_1_)
    {
        super(p_i1714_1_);
    }

    public EntityModelledChestCart(World p_i1715_1_, double p_i1715_2_, double p_i1715_4_, double p_i1715_6_, short Type)
    {
        super(p_i1715_1_, p_i1715_2_, p_i1715_4_, p_i1715_6_);
        type = Type;
        System.out.println("THIS CART IS OF TYPE: " + Type);
    }
    
    public void killMinecart(DamageSource p_94095_1_)
    {
        super.killMinecart(p_94095_1_);
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
    
    public int getCustomCartType() {
    	return type;
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }
}