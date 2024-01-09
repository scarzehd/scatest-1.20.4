package com.scarzehd.scatest.datagen;

import com.scarzehd.scatest.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BOWL_OF_RAW_MACARONI).input(Items.BOWL).input(ModItems.RAW_MACARONI).criterion(FabricRecipeProvider.hasItem(ModItems.RAW_MACARONI), FabricRecipeProvider.conditionsFromItem(ModItems.RAW_MACARONI)).offerTo(exporter);
    }
}
