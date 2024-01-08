package com.scarzehd.scatest.item;

import com.scarzehd.scatest.SCATest;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems() {
        SCATest.LOGGER.info("Registering Items for " + SCATest.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SCATest.MOD_ID, name), item);
    }
}
