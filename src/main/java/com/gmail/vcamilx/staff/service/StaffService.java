package com.gmail.vcamilx.staff.service;

import com.gmail.vcamilx.staff.service.implementation.CommandServiceImpl;
import com.gmail.vcamilx.staff.service.implementation.ListenerServiceImpl;

public class StaffService implements IService {
    @Override
    public void start() {
        new ListenerServiceImpl().start();
        new CommandServiceImpl().start();
    }
}
