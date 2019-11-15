package nyc.welles.MetroInventoryTwo;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void dragEvent(InventoryDragEvent e) {
        Player p = (Player) e.getWhoClicked();
        //System.out.println("inventoryDragEvent is called");

        //if(!hasBypassPermission(p) && playerInWorld(p)) {
        if (!bypassPerm(p)) {
            for (int x = 0; x < e.getInventorySlots().size(); x++){
                for (int a = 0; a < BlockedSlotsStuff.blockedSlots().length; a++){
                    if (e.getInventorySlots().contains(BlockedSlotsStuff.blockedSlots()[a])){
                        BlockedSlotsStuff.giveItems(p);
                        e.setCancelled(true);

                    }

                }

                if (SpecialsSlotsStuff.checkSlotCancel((Integer) e.getInventorySlots().toArray()[x], p, e.getOldCursor())){
                    e.setCancelled(true);

                }
            }
        }
        //PlayerItemGiver.removeDragon(p);


    }
    @EventHandler(priority = EventPriority.HIGH)
    public void clickEvent(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        //System.out.println("inventoryClickEvent is called");
        if (!bypassPerm(p)) {
            if (event.getClickedInventory() != null){
                if (event.getClickedInventory().getType() == InventoryType.CRAFTING){
                    event.setCancelled(true);
                    event.getClickedInventory().clear();

                }
            }

            for (int x = 0; x < BlockedSlotsStuff.blockedSlots().length; x++) {
                if (event.getSlot() == BlockedSlotsStuff.blockedSlots()[x]) {
                    event.setCancelled(true);
                    BlockedSlotsStuff.giveItems(p);


                }
            }
            //System.out.println("When we check if player is using blocked slot, event.setCancelled = " + event.isCancelled());
            if (!SpecialsSlotsStuff.checkSlotCancel(event.getSlot(), p, p.getItemOnCursor())) {
            } else {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void dropEvent(PlayerDropItemEvent dropItemEvent) {
        Player p = dropItemEvent.getPlayer();
        ItemStack dragonStack = new ItemStack(Material.DRAGONS_BREATH, 1);
        ItemStack airStack =  new ItemStack(Material.AIR);
        ItemStack dropStack = dropItemEvent.getItemDrop().getItemStack();
        if (dropStack != null && dropStack.isSimilar(dragonStack)) {
            if (   !bypassPerm(p)) {
                dropItemEvent.setCancelled(true);
                BlockedSlotsStuff.giveItems(p);
                dropItemEvent.getItemDrop().setItemStack(airStack);
            }
        }

        // }
    }
    @EventHandler
    public void swapEvent(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        //if(!hasBypassPermission(p) && playerInWorld(p)) {

        if (!bypassPerm(p)) {
            e.setCancelled(true);
            BlockedSlotsStuff.giveItems(p);

        }
        ///// }
    }
    @EventHandler (priority = EventPriority.HIGH)
    public void onDeath( final PlayerDeathEvent playerDeathEvent) {
        ItemStack giftStack = BlockedSlotsStuff.createPlayerGiftStack();
        final Player player = playerDeathEvent.getEntity();
        ItemStack[] inventory = player.getInventory().getContents();
        //Logger logger = Logger.getLogger("Tester");
        for (int i = 0; i < inventory.length; i++) {
            boolean shouldKeep = false;
            ItemStack itemStack = inventory[i];
            //logger.log(Level.INFO, "inventory content at index " + i + " is " + itemStack);
            if (itemStack != null && itemStack.isSimilar(giftStack)){
                // logger.log(Level.INFO,  "" + itemStack + " isSimilar to " + giftStack);
                if (!bypassPerm(player)) {
                    //logger.log(Level.INFO, "bypassPerms for " + player + " is false,  will keep");
                    shouldKeep = true;

                } else {
                    //logger.log(Level.INFO, "bypassPerms for " + player + " is true, wont keep");
                }

            }
            else {
                //logger.log(Level.INFO, "" + itemStack + " is NOT similar to " + giftStack + ", wont keep");
            }

            if (shouldKeep) {

                //logger.log(Level.INFO, "removing " + itemStack + " from playerDeathEvent.getDrops()");
                playerDeathEvent.getDrops().remove(itemStack);

                //playerDeathEvent.getDrops().remove(i);
                // i : e.getDrops()) i.setType(Material.AIR);
                // e.getDrops().clear();

            } else {
                inventory[i] = null;
            }
        }


    }
    @EventHandler (priority = EventPriority.HIGH)
    public void onRespawn(PlayerRespawnEvent respawnEvent){
        Player p = respawnEvent.getPlayer();
        if (!bypassPerm(p)) {
            BlockedSlotsStuff.giveItems(p);
        }

    }

    public static boolean bypassPerm(Player p) {
        boolean Bypass = false;
        if (p.hasPermission("customInv.bypass")) {
            Bypass = true;
        }
        return Bypass;
    }
}
