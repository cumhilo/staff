/*
 * SimpleNMS
 *
 *  Credits: Special thanks to Javier (https://github.com/Espryth)
 * from there I got the name of the packages / classes and guided me in most of the NMS,
 * besides this thanks to iAlexT (https://github.com/iAlexT)
 * who was the one who explained me about packets and other things...
 *
 * Here https://www.spigotmc.org/threads/nms-tutorials-1-introduction-to-nms.204127/
 * I found an nms tutorial, which helped me to create them.
 *
 * Sincerely yours: vCamilo
 */

package com.github.vcamilx.staff.util.verion;

import com.github.vcamilx.staff.core.nms.NMSHandler;
import com.github.vcamilx.staff.version.NMSHandler_1_16_R3;
import com.github.vcamilx.staff.version.NMSHandler_1_8_R3;
import org.bukkit.Bukkit;

import java.util.regex.Pattern;

public class SimpleNMS {

    private static NMSHandler nmsHandler;
    private final String SERVER_VERSION;

    public SimpleNMS() {
        this.SERVER_VERSION = Bukkit.getServer().getClass().getPackage().getName().split(Pattern.quote("."))[3];
    }

    public static NMSHandler getNMSHandler() {
        return nmsHandler;
    }

    public boolean enableNMS() {
        switch (SERVER_VERSION) {
            case "v1_8_R3":
                nmsHandler = new NMSHandler_1_8_R3();
                break;
            case "v1_16_R3":
                nmsHandler = new NMSHandler_1_16_R3();
                break;
            default:
                Bukkit
                        .getLogger()
                        .warning("you're current version isn't compatible with abilities plugin..");
                return false;
        }
        return true;
    }

    public void disableNMS() {
        nmsHandler = null;
        Bukkit
                .getLogger()
                .info("Disabling NMS version..");
    }

    public String getVersion() {
        return SERVER_VERSION;
    }
}
