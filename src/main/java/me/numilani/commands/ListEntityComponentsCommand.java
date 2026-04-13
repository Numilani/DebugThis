package me.numilani.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import me.numilani.services.ComponentRegistryHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListEntityComponentsCommand extends AbstractPlayerCommand {

  public ListEntityComponentsCommand(String name, String description) {
    super(name, description);
  }

  @Override
  protected void execute(CommandContext ctx, Store<EntityStore> store, Ref<EntityStore> ref, PlayerRef pRef,
      World world) {
    // List<String> components =
    // Arrays.asList(ComponentRegistryHelper.getEntityComponentNames()).stream().filter(x
    // -> x != null).sorted().toList();

    var components = ComponentRegistryHelper.getEntityComponentTypesAlt();

    List<String> names = new ArrayList<String>();
    for (var component : components) {
      if (component == null)
        continue;
      String name = component.getTypeClass().getName();
      String[] nameElements = name.split("\\.");
      var group = nameElements[0] + "." + nameElements[1] + "." + nameElements[2];
      var className = nameElements[nameElements.length - 1];
      names.add(className + " (" + group + ")");
    }
    Collections.sort(names);

    pRef.sendMessage(Message.raw("== Entity Components =="));
    for (var name : names) {
      pRef.sendMessage(Message.raw(name));
      HytaleLogger.getLogger().atInfo().log(name);
    }

    // for (String i : components){
    // if (i == null || i.equals("null")) continue;
    // pRef.sendMessage(Message.raw(i));
    // HytaleLogger.getLogger().atInfo().log(i);
    // }
    pRef.sendMessage(Message.raw("== " + components.length + " entity components found =="));
  }

}
