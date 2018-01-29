package network.controller

object LoginConroller {
    fun generatePlayer(id: Int, login: String, x: Float, y: Float, z: Float) : String{
        return "action:login;id:$id;login:$login;x:$x;y:$y;z:$z;"
    }

    fun regPlayer(id: Int): String {
        return "action:reg;id:$id;"
    }
}