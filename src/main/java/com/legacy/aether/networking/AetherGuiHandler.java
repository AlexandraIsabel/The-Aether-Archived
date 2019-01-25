package com.legacy.aether.networking;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.legacy.aether.api.AetherAPI;
import com.legacy.aether.client.gui.GuiEnchanter;
import com.legacy.aether.client.gui.GuiFreezer;
import com.legacy.aether.client.gui.GuiIncubator;
import com.legacy.aether.client.gui.GuiLore;
import com.legacy.aether.client.gui.GuiTreasureChest;
import com.legacy.aether.client.gui.inventory.GuiAccessories;
import com.legacy.aether.containers.ContainerAccessories;
import com.legacy.aether.containers.ContainerEnchanter;
import com.legacy.aether.containers.ContainerFreezer;
import com.legacy.aether.containers.ContainerIncubator;
import com.legacy.aether.containers.ContainerLore;
import com.legacy.aether.tile_entities.TileEntityEnchanter;
import com.legacy.aether.tile_entities.TileEntityFreezer;
import com.legacy.aether.tile_entities.TileEntityIncubator;
import com.legacy.aether.tile_entities.TileEntityTreasureChest;

public class AetherGuiHandler implements IGuiHandler
{

	public static final int accessories = 1, enchanter = 2, freezer = 3, incubator = 4, treasure_chest = 5, lore = 6;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == accessories)
		{
			return new ContainerAccessories(AetherAPI.getInstance().get(player).getAccessoryInventory(), player);
		}
		else if (ID == enchanter)
		{
			return new ContainerEnchanter(player.inventory, (TileEntityEnchanter) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == freezer)
		{
			return new ContainerFreezer(player.inventory, (TileEntityFreezer) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == incubator)
		{
			return new ContainerIncubator(player, player.inventory, (TileEntityIncubator) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == treasure_chest)
		{
			return new ContainerChest(player.inventory, (IInventory) world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		else if (ID == lore)
		{
			return new ContainerLore(player.inventory);
		}

		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == accessories)
		{
			return new GuiAccessories(AetherAPI.getInstance().get(player));
		}
		else if (ID == enchanter)
		{
			return new GuiEnchanter(player.inventory, (TileEntityEnchanter) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == freezer)
		{
			return new GuiFreezer(player.inventory, (TileEntityFreezer) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == incubator)
		{
			return new GuiIncubator(player, player.inventory, (TileEntityIncubator) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == treasure_chest)
		{
			return new GuiTreasureChest(player.inventory, (TileEntityTreasureChest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == lore)
		{
			return new GuiLore(player.inventory);
		}

		return null;
	}

}