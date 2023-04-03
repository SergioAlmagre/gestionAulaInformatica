import Centro.Alumno
import Factorias.Factoria

fun main(args: Array<String>) {

    var seleccion:Int = 0

//    try {
//        do {
//            println(
//                "Menú\n" +
//                        "1 - Insertar aula\n" +
//                        "1 - Insertar ordenador\n" +
//                        "5 - Insertar alumn@\n" +
//                        "3 - Modificar datos de un aula\n" +
//                        "3 - Modificar datos de un ordenador\n" +
//                        "3 - Modificar datos de un alumno\n" +
//                        "2 - Mostrar ordenador por serial number \n" +
//                        "8 - Mostrar todos los alumnos\n" +
//                        "9 - Mostrar todas las aulas\n" +
//                        "10 - Mostrar todos los ordenadores\n" +
//                        "4 - Borrar por serial number\n" +
//                        "6 - Borrar alumn@\n" +
//                        "7 - Borrar todos los ordenadores\n" +
//                        "11 - Borrar todos l@s alumn@s\n" +
//                        "11 - Borrar todas las aulas\n" +
//                        "12 - Salir\n"
//            )
//            seleccion = readln().toInt()
//        } while (seleccion !in 1..6)
//    }catch (e:Exception){
//        println(e)
//    }


    Conexion.modRam(128,1)
    Conexion.modCpu("Ryzen",1)
    Conexion.modHdd(2000,1)
    Conexion.modCodAula(202,1)


//    Conexion.addAlumno(Factoria.factoriaAlumno())
//    Conexion.addAula(Factoria.factoriaAula())
//    Conexion.addOrdenador(Factoria.factoriaOrdenador(201))
//    mostrarTodosLosOrdenadores()
//    mostrarTodosLosAlumnos()
//    mostrarTodasLasAulas()


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


fun mostrarTodosLosOrdenadores(){
    var ordenadores = Conexion.obtenerOrdenadorArrayList()
    for (e in ordenadores){
        println(e)
    }
}

fun mostrarTodosLosAlumnos(){
    var alumnos = Conexion.obtenerAlumnoArrayList()
    for (e in alumnos){
        println(e)
    }
}

fun mostrarTodasLasAulas(){
    var aulas = Conexion.obtenerAulasArrayList()
    for (e in aulas){
        println(e)
    }
}