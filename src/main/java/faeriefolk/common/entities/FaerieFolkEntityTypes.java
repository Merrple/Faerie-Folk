package faeriefolk.common.entities;

import faeriefolk.FaerieFolk;
import faeriefolk.common.entities.creature.BrownieEntity;
import faeriefolk.common.entities.creature.GoblinEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class FaerieFolkEntityTypes
{
	private static final DeferredRegister<EntityType<?>> ENTITYTYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, FaerieFolk.MODID);
	
	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = ENTITYTYPES.register("goblin", () -> EntityType.Builder.create(GoblinEntity::new, EntityClassification.CREATURE).size(0.7F, 1.1F).build("goblin"));
	public static final RegistryObject<EntityType<BrownieEntity>> BROWNIE = ENTITYTYPES.register("brownie", () -> EntityType.Builder.create(BrownieEntity::new, EntityClassification.CREATURE).size(0.7F, 1.1F).build("brownie"));
	
	public static DeferredRegister<EntityType<?>> getRegistry()
	{
		return ENTITYTYPES;
	}
}
