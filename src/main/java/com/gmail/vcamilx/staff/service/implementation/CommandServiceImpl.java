package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.command.CheckStaffCommand;
import com.gmail.vcamilx.staff.command.FreezeCommand;
import com.gmail.vcamilx.staff.command.InventorySeeCommand;
import com.gmail.vcamilx.staff.command.StaffChatCommand;
import com.gmail.vcamilx.staff.command.StaffCommand;
import com.gmail.vcamilx.staff.service.IService;
import me.yushust.inject.InjectAll;

@InjectAll
@SuppressWarnings("unused")
public class CommandServiceImpl implements IService {

    private Staff staff;

    private CheckStaffCommand checkStaffCommand;
    private InventorySeeCommand inventorySeeCommand;
    private StaffChatCommand staffChatCommand;
    private StaffCommand staffCommand;
    private FreezeCommand freezeCommand;

    private void registerCommand() {
        staff.getCommand("check").setExecutor(checkStaffCommand);
        staff.getCommand("inventorysee").setExecutor(inventorySeeCommand);
        staff.getCommand("staffchat").setExecutor(staffChatCommand);
        staff.getCommand("staff").setExecutor(staffCommand);
        staff.getCommand("freeze").setExecutor(freezeCommand);
    }

    @Override
    public void start() {
        registerCommand();
    }
}
