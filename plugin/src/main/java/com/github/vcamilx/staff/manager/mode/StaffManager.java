package com.github.vcamilx.staff.manager.mode;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.manager.database.MongoManager;
import com.github.vcamilx.staff.manager.inventory.StaffInventory;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import com.github.vcamilx.staff.util.storage.implementation.ManagerStorageImpl;
import com.github.vcamilx.staff.util.verion.SimpleNMS;
import me.yushust.inject.InjectAll;
import me.yushust.inject.InjectIgnore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@InjectAll
public class StaffManager {

    @InjectIgnore
    private static final ManagerStorageImpl managerStorage = new ManagerStorageImpl();

    private Staff staff;
    private StaffInventory staffInventory;
    private MongoManager mongoManager;

    /**
     * Here, we will find a method which will allow us to add a metadata and the inventory to the player without the
     * need to repeat code unnecessarily, besides allowing us to have everything more organized.
     *
     * @param player the player to which the metadata and the inventory is to be applied
     */

    public void setStaff(Player player) {
        if (!isStaff(player)) {
            managerStorage.add(player.getUniqueId(), player.getInventory().getContents());
            player.getInventory().clear();
            staffInventory.inventory(player);

            player.setGameMode(GameMode.CREATIVE);
            setVanish(player);

            SimpleNMS.getNMSHandler().sendTitle(
                    player,
                    ChatUtil
                            .color(staff
                                    .getConfig()
                                    .getString("messages.staff.join.title.title")),
                    ChatUtil
                            .color(staff
                                    .getConfig()
                                    .getString("messages.staff.join.title.subtitle")),
                    staff
                            .getConfig()
                            .getInt("messages.staff.join.title.fadeIn"),
                    staff
                            .getConfig()
                            .getInt("messages.staff.join.title.stay"),
                    staff
                            .getConfig()
                            .getInt("messages.staff.join.title.fadeOut"));

            player
                    .sendMessage(
                            ChatUtil.color(staff
                                    .getConfig()
                                    .getString("messages.staff.join.chat")));
            return;
        }

        managerStorage.find(player.getUniqueId()).ifPresent(itemStacks -> {
            player.getInventory().setContents(managerStorage.getValue(player.getUniqueId()));
            managerStorage.remove(player.getUniqueId());
        });

        player.setGameMode(GameMode.SURVIVAL);
        setVanish(player);

        SimpleNMS.getNMSHandler().sendTitle(
                player,
                ChatUtil
                        .color(staff
                                .getConfig()
                                .getString("messages.staff.leave.title.title")),
                ChatUtil
                        .color(staff
                                .getConfig()
                                .getString("messages.staff.leave.title.subtitle")),
                staff
                        .getConfig()
                        .getInt("messages.staff.leave.title.fadeIn"),
                staff
                        .getConfig()
                        .getInt("messages.staff.leave.title.stay"),
                staff
                        .getConfig()
                        .getInt("messages.staff.leave.title.fadeOut"));
        player.sendMessage(
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.chat")));
    }

    /**
     * Here you can hide a player from other online players on the server.
     *
     * @param player The player who will be hidden from the other players.
     */

    private void setVanish(Player player) {
        Bukkit.getOnlinePlayers().forEach(player1 -> {
            if (!player1.hasPermission("staff.mode") && !player1.canSee(player)) {
                player1.showPlayer(staff, player);
                return;
            }

            player1.hidePlayer(staff, player);
        });
    }

    /**
     * @param player the player we want to check if he is in StaffMode
     * @return true or false, depending on whether the player exists in the map.
     */

    public boolean isStaff(Player player) {
        return getManagerStorage().exists(player.getUniqueId());
    }

    /**
     * @return gets the concurrent HashMap of the ManagerStorage
     */

    public static ManagerStorageImpl getManagerStorage() {
        return managerStorage;
    }
}