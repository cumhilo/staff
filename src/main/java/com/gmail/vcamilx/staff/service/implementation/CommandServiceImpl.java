package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.command.CheckStaffCommand;
import com.gmail.vcamilx.staff.command.InventorySeeCommand;
import com.gmail.vcamilx.staff.command.StaffChatCommand;
import com.gmail.vcamilx.staff.command.StaffCommand;
import com.gmail.vcamilx.staff.service.IService;

import java.util.Objects;

public class CommandServiceImpl implements IService {
    private void registerCommand() {
        Objects.requireNonNull(Staff.getPlugin().getCommand("check")).setExecutor(new CheckStaffCommand());
        Objects.requireNonNull(Staff.getPlugin().getCommand("inventorysee")).setExecutor(new InventorySeeCommand());
        Objects.requireNonNull(Staff.getPlugin().getCommand("staffchat")).setExecutor(new StaffChatCommand());
        Objects.requireNonNull(Staff.getPlugin().getCommand("staff")).setExecutor(new StaffCommand());
    }

    @Override
    public void start() {
        registerCommand();
    }
}
