package growthcraft.core.datagen.providers;

import java.util.Map;
import java.util.stream.Collectors;

import growthcraft.core.block.RopeBlock;
import growthcraft.core.shared.Reference;
import growthcraft.lib.block.GrowthcraftBlock;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class GrowthcraftCoreLootTables extends VanillaBlockLoot{
	
	@Override
	protected void generate() {
		getKnownBlocks().forEach(block -> {
				dropSelf(block);
		});
	}
	
	@Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(Reference.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
