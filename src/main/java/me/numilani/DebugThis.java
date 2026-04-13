package me.numilani;

import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import me.numilani.commands.ListChunkComponentsCommand;
import me.numilani.commands.ListEntityComponentsCommand;

import javax.annotation.Nonnull;

public class DebugThis extends JavaPlugin {
  public static DebugThis plugin;

  public DebugThis(@Nonnull JavaPluginInit init) {
    super(init);
    DebugThis.plugin = this;
  }

  @Override
  protected void setup() {
    this.getCommandRegistry().registerCommand(new ListChunkComponentsCommand("list-chunk-components", "An example command"));
    this.getCommandRegistry().registerCommand(new ListEntityComponentsCommand("list-entity-components", "An example command"));
  }
}
