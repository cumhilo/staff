package com.github.vcamilx.staff.manager.database;

import com.github.vcamilx.staff.Staff;
import redis.clients.jedis.JedisPool;

import javax.inject.Inject;

public class JedisProvider {

    private final JedisPool pool;

    @Inject
    public JedisProvider(Staff staff) {
        this.pool = new JedisPool(
                staff.getConfig().getString("database.redis.host"),
                staff.getConfig().getInt("database.redis.port")
        );
    }

    public JedisPool getJedisPool() {
        return pool;
    }
}