import Centro.Alumno
import Factorias.Factoria

fun main(args: Array<String>) {

    var seleccion:Int = 0

    try {
        do {
            println(
                "Menú\n" +
                        "1 - Insertar ordenador\n" +
                        "2 - Buscar por serial number \n" +
                        "3 - Modificar un ordenador\n" +
                        "4 - Borrar por serial number\n" +
                        "5 - Insertar alumn@\n" +
                        "6 - Borrar alumn@\n" +
                        "7 - Borrar todos los ordenadores\n" +
                        "8 - Mostrar todos los alumnos\n" +
                        "9 - Mostrar todas las aulas\n" +
                        "10 - Mostrar todos los ordenadores\n" +
                        "11 - Borrar todos l@s alumn@s\n" +
                        "12 - Salir\n"
            )
            seleccion = readln().toInt()
        } while (seleccion !in 1..6)
    }catch (e:Exception){
        println(e)
    }


    Conexion.addAlumno(Factoria.factoriaAlumno())
    Conexion.addAula(Factoria.factoriaAula())
    Conexion.addOrdenador(Factoria.factoriaOrdenador(201))


//    var alumnos = Conexion.obtenerAlumnoArrayList()
//    for (e in alumnos){
//        println(e)
//    }




//    when(seleccion){
//        1-> Insertar()
//        2-> BuscarPorCodigo()
//        3-> modificarUnOrdenador()
//        4-> BorrarPorCodigo()
//        5-> BorrarTodos()
//        6-> Salir()
//        7-> BorrarPorCodigo()
//        8-> BorrarTodos()
//        9-> Salir()
//    }

}