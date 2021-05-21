package com.github.vcamilx.staff.service.implementation;

import com.github.vcamilx.staff.core.service.IService;
import com.github.vcamilx.staff.manager.database.MongoManager;

import javax.inject.Inject;

public class DatabaseServiceImpl implements IService {

    @Inject
    private MongoManager mongoManager;

    public void start() {
        mongoManager.connection();
    }

    public void stop() {
        mongoManager.disconnect();
    }
}
