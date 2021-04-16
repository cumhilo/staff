package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.command.*;
import com.gmail.vcamilx.staff.service.IService;
import me.yushust.inject.InjectAll;

import java.util.Objects;

@InjectAll
public class CommandServiceImpl implements IService {

    private Staff staff;

    private CheckStaffCommand checkStaffCommand;
    private InventorySeeCommand inventorySeeCommand;
    private StaffChatCommand staffChatCommand;
    private StaffCommand staffCommand;
    private FreezeCommand freezeCommand;

    private void registerCommand() {
        Objects.requireNonNull(staff.getCommand("check")).setExecutor(checkStaffCommand);
        Objects.requireNonNull(staff.getCommand("inventorysee")).setExecutor(inventorySeeCommand);
        Objects.requireNonNull(staff.getCommand("staffchat")).setExecutor(staffChatCommand);
        Objects.requireNonNull(staff.getCommand("staff")).setExecutor(staffCommand);
        Objects.requireNonNull(staff.getCommand("freeze")).setExecutor(freezeCommand);
    }

    @Override
    public void start() {
        registerCommand();
    }
}
