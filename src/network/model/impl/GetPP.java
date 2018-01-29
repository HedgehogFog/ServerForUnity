package network.model.impl;

import network.data.FastDataObject;
import network.model.Packet;

public class GetPP extends Packet {
    @Override
    public void write(String outputMsg) {
        System.out.println(outputMsg);
        getCtx().writeAndFlush(outputMsg);
    }

    @Override
    public void handle(FastDataObject fastDataObject) {
        long time = Long.parseLong(fastDataObject.getString("t"));
        long ping = System.currentTimeMillis()-time;
        System.out.println("Ping: "+ping + " ms");
        System.out.println("Writed");
        write("hello");
    }
}
