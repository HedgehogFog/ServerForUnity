package network.model;

import io.netty.channel.ChannelHandlerContext;
import network.data.FastDataObject;
import network.handler.PlayerHandler;

import java.io.IOException;

public abstract class Packet {
    private PlayerHandler player;
    private ChannelHandlerContext ctx;

    public PlayerHandler getPlayer() {
        return player;
    }

    public void setPlayer(PlayerHandler player) {
        this.player = player;
    }

    public abstract void write(String outputMsg) throws IOException;
    public abstract void handle(FastDataObject fastDataObject) throws IOException;

    public void setChannel(ChannelHandlerContext channel){
        ctx = channel;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }
}
