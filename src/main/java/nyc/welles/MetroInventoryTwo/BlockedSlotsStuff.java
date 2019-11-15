package nyc.welles.MetroInventoryTwo;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockedSlotsStuff {
    public static int[] blockedSlots() {
        int[] slots = {9, 18, 27, 0, 1, 2, 29, 20, 11, 17, 26, 35, 8, 7, 6, 33, 24, 15,};
        return slots;
    }
    static ItemStack createPlayerGiftStack() {
        ItemStack itemStack = new ItemStack(Material.DRAGONS_BREATH, 1);
        ItemMeta isMeta = itemStack.getItemMeta();
        isMeta.setDisplayName(" "); //you can even set color
        itemStack.setItemMeta(isMeta);
        return itemStack;

    }
    public static void giveItems(Player player) {
        ItemStack itemStack = createPlayerGiftStack();
        int[] blockedSlotIds = BlockedSlotsStuff.blockedSlots();
        int i;

        for (int x = 0; x < blockedSlotIds.length; x++) {
            int slotId = blockedSlotIds[x];
            if (player.getInventory().getItem(slotId) != itemStack) {
                player.getPlayer().getInventory().setItem(slotId, itemStack);
            }
        }
    }
}
