package com.github.vcamilx.staff.manager.database;

import com.github.vcamilx.staff.Staff;
import me.yushust.inject.InjectIgnore;
import redis.clients.jedis.Jedis;

import javax.inject.Inject;

@SuppressWarnings("ConstantConditions")
public class JedisProvider {
    @Inject
    private Staff staff;

    @InjectIgnore
    private final Jedis jedis = new Jedis(
            staff
                    .getConfig()
                    .getString("database.redis.host"),
            staff
                    .getConfig()
                    .getInt("database.redis.port")
    );

    public Jedis getJedis() {
        return jedis;
    }
}