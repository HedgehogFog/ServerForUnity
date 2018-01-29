package network.model

import io.netty.channel.ChannelHandlerContext

class Player(var id: Int, var login: String, var ctx: ChannelHandlerContext){

    init {
        if (login == "")
            login = "user"
    }

    var x = 0.0f
    var y = 0.0f
    var z = 0.0f
}