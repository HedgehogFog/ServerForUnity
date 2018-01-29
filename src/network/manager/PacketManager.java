package network.manager;

import network.model.Packet;
import network.model.impl.GetPP;
import network.model.impl.LoginPacket;
import network.model.impl.TransfromPacket;

import java.util.HashMap;
import java.util.Map;

public class PacketManager {
    public final static Map<String, Class<? extends Packet>> packets = new HashMap<>();
    static {
        packets.put("login", LoginPacket.class);
        packets.put("ping", GetPP.class);
        packets.put("move", TransfromPacket.class);
    }


    public static Packet getPacket(String action) {
        try {
            return packets.get(action).newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
