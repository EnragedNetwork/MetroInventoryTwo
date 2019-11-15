package nyc.welles.MetroInventoryTwo;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpecialsSlotsStuff {
    /*public static int[] rightSpecialsSlots() {
        int[] slots = {16, 25};
        return slots;
    }

    public static int[] leftSpecialsSlots() {
        int[] slots = {10, 19};
        return slots;
    }

    public static ItemStack[] leftSpecials() {
        ItemStack itemB = new ItemStack(Material.INK_SACK, 1);


        ItemStack[] itemStacks = {itemB};
        return itemStacks;
    }

    public static ItemStack[] rightSpecials() {
        ItemStack itemA = new ItemStack(Material.POTION, 1);
        ItemStack itemC = new ItemStack(Material.MELON_SEEDS, 1);


        ItemStack[] itemStacks = {itemA, itemC};
        return itemStacks;
    }
     */
    public static boolean checkSlotCancel(int testSlot, Player player, ItemStack testItem) {
        int correctItemOrSlot = 0;
        ItemStack handGen = new ItemStack(Material.IRON_BARDING);
        int[] specialsSlots = {10, 19, 28, 16, 25, 34, 40};
        int incorrectSlot = 0;

        //handGen.getItemMeta().setDisplayName(ChatColor.WHITE + "Hand Generator");
        ItemStack emptyFlask = new ItemStack(Material.GLASS_BOTTLE);
        ItemStack fullFlask = new ItemStack(Material.POTION);
        ItemStack wardDisc = new ItemStack(Material.RECORD_10);
        ItemStack catDisc = new ItemStack(Material.GREEN_RECORD);
        ItemStack flashlightOff = new ItemStack(Material.GOLD_BARDING);
        ItemStack flashlightOn = new ItemStack(Material.DIAMOND_BARDING);
        ItemStack clock = new ItemStack(Material.WATCH);
        ItemStack compass = new ItemStack(Material.COMPASS);
        if (testItem.getType() != Material.AIR && testItem != null) {
            for (int x = 0; x < specialsSlots.length; x++) {
                if (specialsSlots[x] == testSlot) {
                    if (testSlot == 10) {
                        if (testItem.equals(handGen)) {
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }
                    if (testSlot == 19) {
                        if (testItem.equals(emptyFlask) || testItem.getType() == fullFlask.getType()){
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }
                    if (testSlot == 28) {
                        if (testItem.equals(wardDisc) || testItem.equals(catDisc)) {
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }
                    if (testSlot == 16) {
                        if (testItem.equals(flashlightOff) || testItem.equals(flashlightOn)) {
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }
                    if (testSlot == 25) {
                        if (testItem.getType().equals(Material.INK_SACK)) {
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }
                    if (testSlot == 34) {
                        if (testItem.getType().equals(Material.GOLD_SWORD)) {
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }
                    if (testSlot == 40) {
                        if (testItem.getType().equals(Material.WATCH) || testItem.getType().equals(Material.COMPASS)) {
                            correctItemOrSlot++;
                            //System.out.println("Correct item and Slot");
                        }
                    }


                }
                else {
                    //System.out.println("Incorrect slot, x is " + x);
                    incorrectSlot++;
                }

            }
        }
        else {
            //System.out.println("Test item is air");
            return false;
        }
        if (incorrectSlot == specialsSlots.length){
            //System.out.println("Slot incorrect after full loop");
            return false;
        }


        if (correctItemOrSlot >= 1) {

            return false;

        } else {
            return true;
        }
        /*boolean setCancelled = false;
        boolean setCancelledLeft = true;
        boolean setCancelledRight = true;
        int incorrectItemOccurrencesRight = 0;
        int incorrectSlotOccurrencesLeft = 0;
        int incorrectSlotOccurrencesRight = 0;



        if (player.getInventory().getItem(testSlot) != null ){
            //System.out.println("testItem is " + player.getInventory().getItem(testSlot));
        }

        for (int x = 0; x < leftSpecialsSlots().length; x++) {
            if (leftSpecialsSlots()[x] == testSlot) {
                //System.out.println("Proper Slot (left)");
                for (int z = 0; z < leftSpecials().length; z++) {
                    if (leftSpecials()[z] != null && testItem.getType() != Material.AIR && testItem != null) {
                        //System.out.println("================================================================================");
                        //System.out.println("left specials is " + Arrays.toString(leftSpecials()));
                        //System.out.println("z is " + z);
                        //System.out.println("leftSpecials[a] is " + leftSpecials()[z]);
                        //System.out.println("leftSpecials[a].getType() is " + leftSpecials()[z].getType());
                        //System.out.println("testItem is " + testItem);
                        //System.out.println("================================================================================");

                        if (leftSpecials()[z].getType() != testItem.getType()){
                            setCancelledLeft = true;
                            // System.out.println("           -             Incorrect item detected");

                        }
                        else {setCancelledLeft = false;
                            // System.out.println("           +             Correct item detected");

                        }}
                    else {
                        //System.out.println("null");
                        setCancelledLeft = false;
                    }
                    // if (PlayerItemGiver.leftSpecials()[z] == null || PlayerItemGiver.leftSpecials()[z].getType() == Material.AIR) System.out.println("PlayerItemGiver.leftSpecials()[z] is null or air(left)");
                    // if (testItem == null||testItem.getType() == Material.AIR) System.out.println("testItem is null (left) or air");
                }
            }
            else incorrectSlotOccurrencesLeft++;
        }
        //System.out.println("After checking left slots, setCancelledLeft is" + setCancelledLeft );
        //System.out.println("After checking left slots, setCancelledRight is" + setCancelledRight );

        for (int x = 0; x < rightSpecialsSlots().length; x++) {
            if (rightSpecialsSlots()[x] == testSlot) {
                //System.out.println("Proper Slot (right)");
                for (int a = 0; a < rightSpecials().length; a++) {
                    if (rightSpecials()[a] != null && testItem != null && testItem.getType() != Material.AIR){
                        ItemStack[] rightSpecials = rightSpecials();
                         /*System.out.println("====================");
                         System.out.println("right specials is " + Arrays.toString(rightSpecials));
                         System.out.println("a is " + a);
                         System.out.println("rightSpecials[a] is " + rightSpecials[a]);
                         System.out.println("rightSpecials[a].getType() is " + rightSpecials[a].getType());
                         System.out.println("testItem is " + testItem);
                        System.out.println("testItem's type is " + testItem.getType());

                        if (rightSpecials()[a].getType() == testItem.getType()) incorrectItemOccurrencesRight++;
                        //else setCancelledRight = false;
                        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        //System.out.println("After running check statement setCancelledRight is "+ setCancelledRight);
                        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    } else {
                        //System.out.println("null or air");
                        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        //System.out.println("After a null setCancelledRight is "+ setCancelledRight);
                        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        setCancelledRight = false;
                    }
                    // if (PlayerItemGiver.rightSpecials()[a] == null || PlayerItemGiver.rightSpecials()[a].getType() == Material.AIR) System.out.println("PlayerItemGiver.rightSpecials()[a] is null or air");
                    //if (testItem == null || testItem.getType() == Material.AIR) System.out.println("testItem is null or air (right)");

                    //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    //System.out.println("After testing for nulls and running check statement setCancelledRight is "+ setCancelledRight);
                    //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                }
            }
            else if (rightSpecialsSlots()[x] != testSlot) incorrectSlotOccurrencesRight++;
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            //System.out.println("After checking for correct slot and running null + check statements setCancelledRight is "+ setCancelledRight);
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        }
        if (incorrectItemOccurrencesRight == 1) {
            setCancelledRight = false;
        }
        if (incorrectSlotOccurrencesRight == rightSpecialsSlots().length){
            setCancelledRight = false;
        }
        if (incorrectSlotOccurrencesLeft == leftSpecialsSlots().length){
            setCancelledLeft = false;
        }

        //System.out.println("After checking left & right slots, setCancelledLeft is " + setCancelledLeft );
        //System.out.println("After checking left & right slots, setCancelledRight is" + setCancelledRight );
        if (setCancelledLeft || setCancelledRight){
            setCancelled = true;
        }

        //System.out.println("at end of check SetCancelled = " + setCancelled);

        return setCancelled;
                                                          */
    }
}
