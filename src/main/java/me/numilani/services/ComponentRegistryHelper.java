package me.numilani.services;

import java.lang.reflect.Field;

import com.hypixel.hytale.component.ComponentRegistry;
import com.hypixel.hytale.server.core.universe.world.storage.ChunkStore;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import me.numilani.DebugThis;

public final class ComponentRegistryHelper {

  private ComponentRegistryHelper() {
  }

  public static String[] getEntityComponentNames() {
    try{
    Field entityComponentList = DebugThis.plugin.getEntityStoreRegistry().getClass().getDeclaredField("registry");
    entityComponentList.setAccessible(true);

    ComponentRegistry<EntityStore> entityComponents = (ComponentRegistry<EntityStore>) entityComponentList
        .get(DebugThis.plugin.getEntityStoreRegistry());

    Field entityComponentIds = entityComponents.getClass().getDeclaredField("componentIds");
    entityComponentIds.setAccessible(true);

    String[] entityIds = (String[]) entityComponentIds.get(entityComponents);
    return entityIds;
    } catch (ReflectiveOperationException e){throw new RuntimeException();}
  }

  public static String[] getChunkComponentNames() {
    try{
    Field chunkComponentList = DebugThis.plugin.getChunkStoreRegistry().getClass().getDeclaredField("registry");
    chunkComponentList.setAccessible(true);

    ComponentRegistry<ChunkStore> chunkComponents = (ComponentRegistry<ChunkStore>) chunkComponentList
        .get(DebugThis.plugin.getChunkStoreRegistry());

    Field chunkComponentIds = chunkComponents.getClass().getDeclaredField("componentIds");
    chunkComponentIds.setAccessible(true);

    String[] chunkIds = (String[]) chunkComponentIds.get(chunkComponents);
    return chunkIds;
    }
    catch(ReflectiveOperationException e){ throw new RuntimeException();}
  }
}
