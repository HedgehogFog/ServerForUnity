package network.model.impl

import network.controller.LoginConroller
import network.data.Data
import network.data.FastDataObject
import network.model.Packet
import network.model.Player

import java.io.IOException
import java.net.SocketAddress

class LoginPacket : Packet() {
    @Throws(IOException::class)
    override fun write(outputMsg: String) {
        ctx.writeAndFlush(outputMsg)
    }

    @Throws(IOException::class)
    override fun handle(fastDataObject: FastDataObject) {
        val login = fastDataObject.getString("login")
        val address = ctx.channel().remoteAddress()

        Data.playerList.add(Player(Data.currentId++, login, ctx))
        write(LoginConroller.regPlayer(Data.currentId - 1))

        for (player in Data.playerList) {
            if (player.ctx.channel().remoteAddress() != address){
                player.ctx.write(LoginConroller.generatePlayer(Data.currentId - 1, login, 0.0f, 0.0f, 0.0f))
            } else{
                for (other in Data.playerList) {
                    if (player.ctx.channel().remoteAddress() != address) {
                        player.ctx.writeAndFlush(LoginConroller.generatePlayer(other.id, other.login, other.x, other.y, other.z))
                    }
                }
            }
        }

    }
}
