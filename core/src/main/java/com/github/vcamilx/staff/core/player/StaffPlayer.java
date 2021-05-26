package com.github.vcamilx.staff.core.player;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.UUID;

public class StaffPlayer {

    private String playerName;
    private UUID playerId;
    private Date firstActivity;
    private Date lastActivity;
    private int sanctions;
    private boolean staffMode;
    private boolean staffChat;
    private boolean socialSpy;
    private boolean vanished;
    private ItemStack[] inventory;

    public StaffPlayer(Player player) {
        this.playerName = player.getName();
        this.playerId = player.getUniqueId();
        this.firstActivity = new Date();
        this.lastActivity = new Date();
        this.sanctions = 0;
        this.staffMode = true;
        this.staffChat = true;
        this.socialSpy = true;
        this.vanished = true;
        this.inventory = player.getInventory().getContents();
    }

    @ConstructorProperties({
            "playerName",
            "playerId",
            "firstActivity",
            "lastActivity",
            "sanctions",
            "staffMode",
            "staffChat",
            "socialSpy",
            "vanished",
            "inventory"
    })
    public StaffPlayer(
            String playerName,
            UUID playerId,
            Date firstActivity,
            Date lastActivity,
            int sanctions,
            boolean staffMode,
            boolean staffChat,
            boolean socialSpy,
            boolean vanished,
            ItemStack[] inventory) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.firstActivity = firstActivity;
        this.lastActivity = lastActivity;
        this.sanctions = sanctions;
        this.staffMode = staffMode;
        this.staffChat = staffChat;
        this.socialSpy = socialSpy;
        this.vanished = vanished;
        this.inventory = inventory;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public Date getFirstActivity() {
        return firstActivity;
    }

    public void setFirstActivity(Date firstActivity) {
        this.firstActivity = firstActivity;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public int getSanctions() {
        return sanctions;
    }

    public void setSanctions(int sanctions) {
        this.sanctions = sanctions;
    }

    public boolean isStaffMode() {
        return staffMode;
    }

    public void setStaffMode(boolean staffMode) {
        this.staffMode = staffMode;
    }

    public boolean isStaffChat() {
        return staffChat;
    }

    public void setStaffChat(boolean staffChat) {
        this.staffChat = staffChat;
    }

    public boolean isSocialSpy() {
        return socialSpy;
    }

    public void setSocialSpy(boolean socialSpy) {
        this.socialSpy = socialSpy;
    }

    public boolean isVanished() {
        return vanished;
    }

    public void setVanished(boolean vanished) {
        this.vanished = vanished;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = inventory;
    }
}
