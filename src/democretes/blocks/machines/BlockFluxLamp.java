package democretes.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import thaumcraft.api.ItemApi;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import democretes.blocks.BlockBase;
import democretes.blocks.machines.tiles.TileElectricBellows;
import democretes.blocks.machines.tiles.TileFluxLamp;
import democretes.blocks.machines.tiles.TileNodeGenerator;
import democretes.lib.LibNames;
import democretes.lib.Reference;
import democretes.lib.RenderIds;

public class BlockFluxLamp extends BlockBase {
	
	public BlockFluxLamp(int id) {
		super(id);
		setUnlocalizedName(Reference.MOD_PREFIX + LibNames.FLUX_LAMP_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileFluxLamp();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return RenderIds.idFluxLamp;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon iconLamp;
	
	@SideOnly(Side.CLIENT)
	public void RegisterIcons(IconRegister icon) {
		this.iconLamp = icon.registerIcon(Reference.TEXTURE_PREFIX + LibNames.CONDENSER_NAME);	
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta){
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		return side + meta;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if(tile instanceof TileFluxLamp) {
			((TileFluxLamp)tile).placed = true;
		}
	}
	
}
