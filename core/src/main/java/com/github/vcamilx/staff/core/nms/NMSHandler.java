package com.github.vcamilx.staff.core.nms;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
 * Credits: Special thanks to Javier (https://github.com/Espryth)
 * from there I got the name of the packages / classes and guided me in most of the NMS,
 * besides this thanks to iAlexT (https://github.com/iAlexT)
 * who was the one who explained me about packets and other things...
 *
 * Here https://www.spigotmc.org/threads/nms-tutorials-1-introduction-to-nms.204127/
 * I found an nms tutorial, which helped me to create them.
 *
 * Sincerely yours: vCamilo
 */

public interface NMSHandler {

    /**
     * <h3>Items builder</h3>
     *
     * <p> Here, everything will return the value of the specified item converted into an ItemStack, for the versioning
     * of the different versions 1.8x up to 1.16.5. </p>
     *
     * @param name The name of the item
     * @param lore The lore of the item
     * @return The value of the constructed item.
     */

    ItemStack compass(String name, String... lore);

    ItemStack ice(String name, String... lore);

    ItemStack book(String name, String... lore);

    ItemStack lead(String name, String... lore);

    ItemStack playerHead(String name, String... lore);

    ItemStack enderEye(String name, String... lore);

    /**
     * <h3>Packets</h3>
     */

    void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut);
}
