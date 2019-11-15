package nyc.welles.MetroInventoryTwo;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class SwitchSlotsListener implements Listener {
    @EventHandler
    public void getCurrentSlot(PlayerItemHeldEvent event) {
        int slotNumber = event.getNewSlot();
        Player player = event.getPlayer();
        CorrectSlotStuff.correctSlot(player, slotNumber);

    }
}
