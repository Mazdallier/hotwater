package com.sorazodia.hotwater.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.sorazodia.hotwater.registry.ItemRegistry;
import com.sorazodia.hotwater.tileEntity.TileEntity_Cauldon;

public class BlockBoilingCauldon extends BlockContainer{
	
	 public BlockBoilingCauldon(Material material) {
		super(material);
	}

	 public BlockBoilingCauldon() {
			super(Material.iron);
		}
	 
	public Item getItemDropped(int i, Random random, int j)
	    {
	        return ItemRegistry.cauldon;
	    }

	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		ItemStack playeritem = player.getCurrentEquippedItem();
		FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(playeritem);	
		if(playeritem != null && !world.isRemote){
			TileEntity_Cauldon cauldon = new TileEntity_Cauldon();
			cauldon.inputPotionItems(playeritem);
			playeritem.stackSize--;
		}
		 return true;
	 }
	 
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntity_Cauldon();
	}
	

}
