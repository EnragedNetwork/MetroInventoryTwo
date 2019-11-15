package nyc.welles.MetroInventoryTwo;

import org.bukkit.entity.Player;

public class CorrectSlotStuff {
    public static boolean bypassPerm(Player p) {
        boolean Bypass = false;
        if (p.hasPermission("customInv.bypass")) {
            Bypass = true;
        }
        return Bypass;
    }
    public static void correctSlot(Player player, int slotNumber) {
        if (slotNumber == 0) {
            if (!bypassPerm(player)) {
                player.getInventory().setHeldItemSlot(3);
            }
        }
        if (slotNumber == 1) {
            if (!bypassPerm(player)) {
                player.getInventory().setHeldItemSlot(4);
            }
        }
        if (slotNumber == 2) {
            if (!bypassPerm(player)) {
                player.getInventory().setHeldItemSlot(5);
            }
        }
        if (slotNumber == 6 || slotNumber == 7 || slotNumber == 8) {
            if (!bypassPerm(player)) {
                player.getInventory().setHeldItemSlot(3);
            }
        }
    }
}
