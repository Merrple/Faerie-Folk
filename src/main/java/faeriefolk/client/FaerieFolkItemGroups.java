package faeriefolk.client;

import faeriefolk.FaerieFolk;
import faeriefolk.common.items.FaerieFolkItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FaerieFolkItemGroups extends ItemGroup
{
	public static FaerieFolkItemGroups ITEMGROUP = new FaerieFolkItemGroups("itemgroup");
	
	FaerieFolkItemGroups(String label)
	{
		super(FaerieFolk.MODID + "." + label);
	}
	
	@OnlyIn(Dist.CLIENT)
	public ItemStack createIcon()
	{
		return new ItemStack(FaerieFolkItems.SPAWNER_GOBLIN.get());
	}
}
