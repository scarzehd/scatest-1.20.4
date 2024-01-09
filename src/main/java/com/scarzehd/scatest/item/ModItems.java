package com.scarzehd.scatest.item;

import com.scarzehd.scatest.SCATest;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_MACARONI = registerItem("raw_macaroni", new Item(new FabricItemSettings()));
    public static final Item BOWL_OF_RAW_MACARONI = registerItem("bowl_of_raw_macaroni", new Item(new FabricItemSettings().maxCount(1)));


    public static void registerModItems() {
        SCATest.LOGGER.info("Registering items for " + SCATest.MOD_ID);
    }

    public static void addItemsToGroups() {
        SCATest.LOGGER.info("Adding items to groups");

        addItemsToItemGroup(ItemGroups.INGREDIENTS, (entries) -> {
            entries.add(RAW_MACARONI);
            entries.add(BOWL_OF_RAW_MACARONI);
        });
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SCATest.MOD_ID, name), item);
    }

    private static void addItemsToItemGroup(RegistryKey<ItemGroup> group, ItemGroupEvents.ModifyEntries entries) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries);
    }
}
