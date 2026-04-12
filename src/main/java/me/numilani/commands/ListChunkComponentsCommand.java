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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ListChunkComponentsCommand extends AbstractPlayerCommand {

    public ListChunkComponentsCommand(String name, String description) {
        super(name, description);
    }

    @Override
    protected void execute(CommandContext ctx, Store<EntityStore> store, Ref<EntityStore> ref, PlayerRef pRef,
        World world) {
    var components = ComponentRegistryHelper.getChunkComponentNames();
    pRef.sendMessage(Message.raw("== Chunk Components =="));
    for (var i : components){
      pRef.sendMessage(Message.raw(i));
      HytaleLogger.getLogger().atInfo().log(i);
    }
    pRef.sendMessage(Message.raw("== END =="));
    }

}
