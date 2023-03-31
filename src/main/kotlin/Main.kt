fun main(args: Array<String>) {

    var seleccion:Int = 0

    try {
        do {
            println(
                "Menú\n" +
                        "1 - Insertar ordenador\n" +
                        "2 - Buscar por codigo \n" +
                        "3 - Modificar un ordenador\n" +
                        "4 - Borrar por código\n" +
                        "5 - Borrar Todos\n" +
                        "6 - Salir"
            )
            seleccion = readln().toInt()
        } while (seleccion !in 1..6)
    }catch (e:Exception){
        println(e)
    }

    Conexion.abrirConexion()
    Conexion.cerrarConexion()

//    when(seleccion){
//        1-> Insertar()
//        2-> BuscarPorCodigo()
//        3-> modificarUnOrdenador()
//        4-> BorrarPorCodigo()
//        5-> BorrarTodos()
//        6-> Salir()
//    }

}