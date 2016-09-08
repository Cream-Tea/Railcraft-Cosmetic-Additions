package mods.railcraft_cos.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.entity.item.EntityModelledChestCart;
import mods.railcraft_cos.common.entity.item.EntityModelledTankCart;
import mods.railcraft_cos.common.models.CosCartEmpty;
import mods.railcraft_cos.common.models.CosCartLiquid;
import mods.railcraft_cos.common.models.CosCartPanzer;
import mods.railcraft_cos.common.models.CosCartQuarry;
import mods.railcraft_cos.common.models.CosCartWoodFull;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderModelledCartCustom extends RenderMinecart
{
    private static ResourceLocation minecartTextures = new ResourceLocation(Railcraft_Cos.MODID, "textures/entities/coscart.quarry.png");
    /** instance of ModelMinecart for rendering */
    protected ModelBase modelMinecart = new CosCartQuarry();
    protected final RenderBlocks field_94145_f;

    public RenderModelledCartCustom()
    {
        this.shadowSize = 0.5F;
        this.field_94145_f = new RenderBlocks();
    }

    public void doRender(EntityMinecart entity, double d, double d1, double d2, float f, float f1)
    {
        GL11.glPushMatrix();
        if(entity instanceof EntityModelledChestCart)
        {
        	switch (((EntityModelledChestCart) entity).getCustomCartType()) 
        	{	case 0:
	            {
	            	modelMinecart = new CosCartQuarry();
	            	minecartTextures = new ResourceLocation(Railcraft_Cos.MODID, "textures/entities/coscart.quarry.png");
	            	break;
	            }	            	
	            case 2: 
	            {	int logs = ((EntityModelledChestCart) entity).getItemCount();
	            	modelMinecart = new CosCartWoodFull(logs);
	            	minecartTextures = new ResourceLocation(Railcraft_Cos.MODID, "textures/entities/coscart.woodfull.png");
	            	break;
	            } 
	            case 3: 
	            {	
	            	modelMinecart = new CosCartEmpty();
	            	minecartTextures = new ResourceLocation(Railcraft_Cos.MODID, "textures/entities/coscart.empty.png");
	            	break;
	            }
	            case 4: 
	            {	
	            	modelMinecart = new CosCartPanzer();
	            	minecartTextures = new ResourceLocation(Railcraft_Cos.MODID, "textures/entities/coscart.panzer.png");
	            	break;
	            }
            }
        }
        else if(entity instanceof EntityModelledTankCart)
        {
        	switch (((EntityModelledTankCart) entity).getCustomCartType()) 
        	{	           
	            case 1:
	            {	modelMinecart = new CosCartLiquid();
	            	minecartTextures = new ResourceLocation(Railcraft_Cos.MODID, "textures/entities/coscart.liquid.png");
	            	break;
	            }
        	}
        }
       
        this.bindEntityTexture(entity);
        long i = (long)entity.getEntityId() * 493286711L;
        i = i * i * 4392167121L + i * 98761L;
        float f2 = (((float)(i >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f3 = (((float)(i >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f4 = (((float)(i >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        GL11.glTranslatef(f2, f3, f4);
        double d3 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f1;
        double d4 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f1;
        double d5 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f1;
        double d6 = 0.30000001192092896D;
        Vec3 vec3 = entity.func_70489_a(d3, d4, d5);
        float f5 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1;

        if (vec3 != null)
        {
            Vec3 vec31 = entity.func_70495_a(d3, d4, d5, d6);
            Vec3 vec32 = entity.func_70495_a(d3, d4, d5, -d6);

            if (vec31 == null)
            {
                vec31 = vec3;
            }

            if (vec32 == null)
            {
                vec32 = vec3;
            }

            d += vec3.xCoord - d3;
            d1 += (vec31.yCoord + vec32.yCoord) / 2.0D - d4;
            d2 += vec3.zCoord - d5;
            Vec3 vec33 = vec32.addVector(-vec31.xCoord, -vec31.yCoord, -vec31.zCoord);

            if (vec33.lengthVector() != 0.0D)
            {
                vec33 = vec33.normalize();
                f = (float)(Math.atan2(vec33.zCoord, vec33.xCoord) * 180.0D / Math.PI);
                f5 = (float)(Math.atan(vec33.yCoord) * 73.0D);
            }
        }

        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(180.0F - f, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f5, 0.0F, 0.0F, 1.0F);
        float f7 = (float)entity.getRollingAmplitude() - f1;
        float f8 = entity.getDamage() - f1;

        if (f8 < 0.0F)
        {
            f8 = 0.0F;
        }

        if (f7 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f7) * f7 * f8 / 10.0F * (float)entity.getRollingDirection(), 1.0F, 0.0F, 0.0F);
        }

        int k = entity.getDisplayTileOffset();
        Block block = entity.func_145820_n();
        int j = entity.getDisplayTileData();

        if (block.getRenderType() != -1)
        {
            GL11.glPushMatrix();
            this.bindTexture(TextureMap.locationBlocksTexture);
            float f6 = 0.75F;
            GL11.glScalef(f6, f6, f6);
            GL11.glTranslatef(0.0F, (float)k / 16.0F, 0.0F);
            this.func_147910_a(entity, f1, block, j);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindEntityTexture(entity);
        }

        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelMinecart.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityMinecart entity)
    {
        return minecartTextures;
    }

    protected void func_147910_a(EntityMinecart entity, float f, Block block, int i)
    {
        float f1 = entity.getBrightness(f);
        GL11.glPushMatrix();
        this.field_94145_f.renderBlockAsItem(block, i, f1);
        GL11.glPopMatrix();
    }
}