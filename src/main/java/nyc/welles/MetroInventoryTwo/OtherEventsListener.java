package nyc.welles.MetroInventoryTwo;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OtherEventsListener implements Listener {

    @EventHandler
    public void onLogin(PlayerJoinEvent Event){
        ItemStack flashlightOff = new ItemStack(Material.GOLD_BARDING);
        ItemStack flashlightOn = new ItemStack(Material.DIAMOND_BARDING);

        Player p = Event.getPlayer();
        if (!bypassPerm(p)) {
            BlockedSlotsStuff.giveItems(p);
        }

        if (p.getInventory().getItemInMainHand().equals(flashlightOff) || p.getInventory().getItemInMainHand().equals(flashlightOn)) {
            ItemStack is = p.getInventory().getItemInMainHand();
            //DateFormat df = new SimpleDateFormat("MM.ss");
            //String date = df.format(new Date());
            ItemMeta im = is.getItemMeta();
            List<String> lore = im.getLore();
            lore.add(ChatColor.GRAY + "10");
            im.setLore(lore);
            is.setItemMeta(im);
            p.getInventory().setItemInMainHand(is);
        }

    }
    @EventHandler
    public void onInteract(PlayerInteractEvent playerInteractEvent){
        HandGenAndFlashlightStuff handGenAndFlashlightStuff = new HandGenAndFlashlightStuff();
        Player p = playerInteractEvent.getPlayer();
        ItemStack flashlightOff = new ItemStack(Material.GOLD_BARDING);
        ItemStack flashlightOn = new ItemStack(Material.DIAMOND_BARDING);
        if (playerInteractEvent.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_BARDING){
            if (playerInteractEvent.getPlayer().getInventory().contains(Material.GOLD_BARDING)){
                ItemStack is = p.getInventory().getItem(p.getInventory().first(Material.GOLD_BARDING));
                //DateFormat df = new SimpleDateFormat("MM.ss");
                //String date = df.format(new Date());
                ItemMeta im = is.getItemMeta();
                List<String> lore = im.getLore();
                int foo;
                try {
                    foo = Integer.parseInt(lore.get(lore.size() - 1));
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error in metroInv caused due to changing item name by " + p.getName());
                    p.sendMessage("DO NOT MODIFY THE NAME OF THIS ITEM AGAIN, To remove from inventory please place item in hand, then relog");
                    foo = 0;
                }

                lore.set(lore.size(), Integer.toString(foo + 1));


            }

        }
    }

    public boolean bypassPerm(Player p) {
        boolean bypass = false;
        if (p.hasPermission("customInv.bypass")) {
            bypass = true;
        }
        return bypass;
    }

}
