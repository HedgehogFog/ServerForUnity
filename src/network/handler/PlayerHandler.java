package network.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import network.data.FastDataObject;
import network.manager.PacketManager;
import network.model.Packet;

import java.io.IOException;

public class PlayerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String o) throws Exception {
        FastDataObject fdo = new FastDataObject(o);
        String action = fdo.getParameter("action");

        Packet packet = PacketManager.getPacket(action);
        packet.setChannel(ctx);

        try {
            packet.handle(fdo);
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
