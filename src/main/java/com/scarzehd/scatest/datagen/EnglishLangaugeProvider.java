package com.scarzehd.scatest.datagen;

import com.scarzehd.scatest.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishLangaugeProvider extends FabricLanguageProvider {
    protected EnglishLangaugeProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.RAW_MACARONI, "Raw Macaroni");
        translationBuilder.add(ModItems.BOWL_OF_RAW_MACARONI, "Bowl of Raw Macaroni");
    }
}
