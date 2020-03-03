package merrple.faeriefolk.client;

import merrple.faeriefolk.common.Faeriefolk;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class Group {
	public static final ItemGroup FAERIE_FOLK = new ItemGroup(Faeriefolk.MODID) {
		
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			 return new ItemStack(Blocks.PEONY);
		}
	};
}
