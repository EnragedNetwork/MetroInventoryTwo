package nyc.welles.MetroInventoryTwo;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandGenAndFlashlightStuff {
    public int chargePlusPlus(int x){

        return x++;
    }
    public static boolean getIfShouldBeOff(String time, Player player, int slot){

        ItemStack is = player.getInventory().getItemInMainHand();
        ItemMeta im = is.getItemMeta();
        List<String> lore = im.getLore();
        int foo;
        try {
            foo = Integer.parseInt(lore.get(lore.size() - 1));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error in metroInv caused by assholery by " + player.getName());
            player.sendMessage("DO NOT MODIFY THE NAME OF THIS ITEM AGAIN, To remove from inventory please store item, then relog");
            foo = 0;
        }
        if (foo >= 5){
            return true;
        }
        else return false;

        /*DateFormat df = new SimpleDateFormat("MM.ss");
        String date = df.format(new Date());
        ItemMeta im = is.getItemMeta();
        List<String> lore = im.getLore();
        Date timeOnItem = df.parse(lore.get(lore.size() - 1));
        Date currentTime = df.parse(date);
        long diffInMillies = Math.abs(currentTime.getTime() - timeOnItem.getTime());
        if (diffInMillies >= ){
            return false;
        }
        else return true;
         */
    }
}
