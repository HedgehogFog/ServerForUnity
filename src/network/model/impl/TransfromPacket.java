package network.model.impl;

import network.data.FastDataObject;
import network.model.Packet;

public class TransfromPacket extends Packet {
    @Override
    public void write(String outputMsg) {
        System.out.println(outputMsg);
        getCtx().writeAndFlush(outputMsg);
    }

    @Override
    public void handle(FastDataObject fastDataObject) {
        float x = Float.parseFloat(fastDataObject.getString("x"));
        float y = Float.parseFloat(fastDataObject.getString("y"));
        float z = Float.parseFloat(fastDataObject.getString("z"));
        System.out.println("Player pos: " + x + ", " + y + ", " + z);
//        write("hello");
    }
}
