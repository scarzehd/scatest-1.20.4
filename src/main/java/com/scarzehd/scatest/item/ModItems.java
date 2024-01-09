package com.scarzehd.scatest.item;

import com.scarzehd.scatest.SCATest;
import com.scarzehd.scatest.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_MACARONI = registerItem("raw_macaroni", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item BOWL_OF_RAW_MACARONI = registerItem("bowl_of_raw_macaroni", new Item(new FabricItemSettings().maxCount(1)));

    public static final ItemGroup MACARONI_GROUP = registerItemGroup("macaroni_group",
            BOWL_OF_RAW_MACARONI,
            Text.translatable("itemGroup.scatest.macaroni_group"),
            (context, entries) -> {
                entries.add(RAW_MACARONI);
                entries.add(BOWL_OF_RAW_MACARONI);
                entries.add(ModBlocks.BLOCK_OF_RAW_MACARONI.asItem());
            });

    public static void registerModItems() {  // This loads all the static fields of this class
        SCATest.LOGGER.info("Registering items for " + SCATest.MOD_ID);
    }

    public static void addItemsToGroups() {
        SCATest.LOGGER.info("Adding items to groups");

        addItemsToItemGroup(ItemGroups.INGREDIENTS, (entries) -> {
            entries.add(RAW_MACARONI);
            entries.add(BOWL_OF_RAW_MACARONI);
            entries.add(ModBlocks.BLOCK_OF_RAW_MACARONI.asItem());
        });
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SCATest.MOD_ID, name), item);
    }

    private static ItemGroup registerItemGroup(String name, Item icon, Text displayName, ItemGroup.EntryCollector entries) {
        return Registry.register(Registries.ITEM_GROUP, new Identifier(SCATest.MOD_ID, name), FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon))
                .displayName(displayName)
                .entries(entries)
                .build());
    }

    private static void addItemsToItemGroup(RegistryKey<ItemGroup> group, ItemGroupEvents.ModifyEntries entries) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries);
    }
}
