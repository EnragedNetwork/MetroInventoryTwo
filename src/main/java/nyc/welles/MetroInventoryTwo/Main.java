package nyc.welles.MetroInventoryTwo;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //this.getCommand("metroinv").setExecutor(new UnlockAndLockCommands());
        //this.getCommand("metroinventory").setExecutor(new UnlockAndLockCommands());\
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new OtherEventsListener(), this);
        getServer().getPluginManager().registerEvents(new SwitchSlotsListener(), this);


    }
    @Override
    public void onDisable() {

    }

}
