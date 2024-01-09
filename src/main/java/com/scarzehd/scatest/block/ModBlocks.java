package com.scarzehd.scatest.block;

import com.scarzehd.scatest.SCATest;
import com.scarzehd.scatest.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block BLOCK_OF_RAW_MACARONI = registerBlock("block_of_raw_macaroni", new Block(FabricBlockSettings.create().strength(0.5f)), true);

    public static void registerModBlocks() { // This loads all the static fields of this class
        SCATest.LOGGER.info("Registering blocks for " + SCATest.MOD_ID);
    }

    private static Block registerBlock(String name, Block block, boolean registerItem) {
        Block newBlock = Registry.register(Registries.BLOCK, new Identifier(SCATest.MOD_ID, name), block);
        if (registerItem) {
            ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()));
        }
        return newBlock;
    }
}
