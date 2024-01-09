package com.scarzehd.scatest;

import com.scarzehd.scatest.block.ModBlocks;
import com.scarzehd.scatest.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SCATest implements ModInitializer {
	public static final String MOD_ID = "scatest";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItems.addItemsToGroups();
		ModBlocks.registerModBlocks();
	}
}