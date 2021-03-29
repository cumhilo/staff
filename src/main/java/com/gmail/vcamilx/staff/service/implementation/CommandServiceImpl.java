package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.command.CheckStaffCommand;
import com.gmail.vcamilx.staff.command.InventorySeeCommand;
import com.gmail.vcamilx.staff.command.StaffCommand;
import com.gmail.vcamilx.staff.service.IService;
import com.gmail.vcamilx.staff.service.StaffService;

import java.util.Objects;

public class CommandServiceImpl implements IService {
    private void registerCommand() {
        Objects.requireNonNull(Staff.plugin.getCommand("check")).setExecutor(new CheckStaffCommand());
        Objects.requireNonNull(Staff.plugin.getCommand("inventorysee")).setExecutor(new InventorySeeCommand());
        Objects.requireNonNull(Staff.plugin.getCommand("staff")).setExecutor(new StaffCommand());
    }

    @Override
    public void start() {
        registerCommand();
    }

    @Override
    public void interrupt() {

    }
}
