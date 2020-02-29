package merrple.faeriefolk.common;

import merrple.faeriefolk.common.entities.hostile.GoblinEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class FaeriefolkEntityTypes {
	protected static final DeferredRegister<EntityType<?>> DEFERRED_REGISTRY = new DeferredRegister<>(ForgeRegistries.ENTITIES, Faeriefolk.MODID);
	
	public static RegistryObject<EntityType<GoblinEntity>> GOBLIN = create("goblin", EntityType.Builder.create(GoblinEntity::new, EntityClassification.MISC).size(0.8F, 1.1F));
	
	private static <T extends Entity> RegistryObject<EntityType<T>> create(String idIn, EntityType.Builder<T> builder) {
		return DEFERRED_REGISTRY.register(idIn, () -> builder.build(idIn));
	}
}
