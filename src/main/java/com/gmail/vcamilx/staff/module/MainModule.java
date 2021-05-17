package com.gmail.vcamilx.staff.module;

import com.gmail.vcamilx.staff.Staff;
import me.yushust.inject.AbstractModule;
import org.bukkit.plugin.Plugin;

public class MainModule extends AbstractModule {

    private final Staff staff;

    public MainModule(Staff staff) {
        this.staff = staff;
    }

    @Override
    protected void configure() {
        install(
            new ServiceModule(),
            new StorageModule()
        );
        bind(Staff.class).toInstance(staff);
        bind(Plugin.class).to(Staff.class);
    }
}
