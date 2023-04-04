import Centro.Alumno
import Factorias.Factoria
import java.sql.SQLException
import kotlin.random.Random

fun main(args: Array<String>) {

    var seleccion:Int = 0

    try {
        do {
            println(
                "Menú\n" +
                        "1 - Insertar aula\n" +
                        "2 - Insertar ordenador\n" +
                        "3 - Insertar alumn@\n" +
                        "4 - Modificar datos de un aula\n" +
                        "5 - Modificar datos de un ordenador\n" +
                        "6 - Modificar datos de un alumn@\n" +
                        "7 - Mostrar un aula por codigo de aula \n" +
                        "8 - Mostrar un ordenador por serial number \n" +
                        "9 - Mostrar un alumn@ por DNI \n" +
                        "10 - Mostrar todos los alumn@s\n" +
                        "11 - Mostrar todas las aulas\n" +
                        "12 - Mostrar todos los ordenadores\n" +
                        "13 - Borrar ordenador por serial number\n" +
                        "14 - Borrar alumn@ por DNI\n" +
                        "15 - Borrar aula por código" +
                        "16 - Borrar todos los ordenadores\n" +
                        "17 - Borrar todos l@s alumn@s\n" +
                        "18 - Borrar todas las aulas\n" +
                        "19 - Destruir la base de datos\n" +
                        "20 - Construir la base de datos\n" +
                        "21 - Meter datos a cascoporrillo\n" +
                        "22 - Salir\n"
            )
            seleccion = readln().toInt()
        } while (seleccion !in 1..22 && seleccion != 22)
    }catch (e:Exception){
        println(e)
    }

    when(seleccion){
        1-> Conexion.addAula(Factoria.factoriaAula())
        2-> Conexion.addOrdenador(Factoria.factoriaOrdenador(201))
        3-> Conexion.addAlumno(Factoria.factoriaAlumno())
        4-> modOAula()
        5-> modOrdenador()
        6-> modAlumno()
        7-> mostrarAula()
        8-> mostrarOrdenador()
        9-> mostrarAlumno()
        10-> mostrarTodosLosAlumnos()
        11-> mostrarTodasLasAulas()
        12-> mostrarTodosLosOrdenadores()
        13-> borrarOrdenador()
        14-> borrarAlumno()
        15-> borrarAula()
        16-> Conexion.borrarTodosLosOrdenadores()
        17-> Conexion.borrarTodosLosAlumnos()
        18-> Conexion.borrarTodasAulas()
        19-> destruirBbdd()
        20-> construirBbdd()
        21-> meterDatosACascoporrillo()
        22-> println("Hasta la vista")
    }
}

    fun construirBbdd(){
        var sentencia = ""
        for (i in 0..6){
            print ("- ")
            Thread.sleep(500)
        }
    }
    fun destruirBbdd(){
        var eleccion = -1
        var confirmacion = -1

        try {
            println("0 - Cancelar\n" +
                    "1 - Borrar BBDD")
            var eleccion = readln().toInt()

            if (eleccion == 1){
                println("Borrar la base de datos es un paso irreversible, ¿quieres hacerlo?\n" +
                        "¿Estás serguro de destruir la bases de datos?\n" +
                        "0 - Cancelar\n" +
                        "1 - Borrar BBDD\n")
                confirmacion = readln().toInt()
            }
            if (confirmacion == 1){
                var sentencia = ""
            }

        }catch (ex:Exception){
            println(ex)
        }

        if (eleccion == 0 || confirmacion == 0){
            println("proceso cancelado")
        }else{
            println("Base de datos destruida")
        }

    }

    fun borrarAula(){
        try {
            var codAula = readln().toInt()
            Conexion.borrarAula(codAula)
        }catch (ex:Exception){
            println(ex)
        }
        println("Borrado con éxito")
    }

    fun borrarOrdenador(){
        try {
            var sn = readln().toInt()
            Conexion.borrarOrdenador(sn)
        }catch (ex:Exception){
            println(ex)
        }
        println("Borrado con éxito")
    }

    fun borrarAlumno(){
        try {
            var dni = readln()
            Conexion.borrarAlumno(dni)
        }catch (ex:Exception){
            println(ex)
        }
        println("Borrado con éxito")
    }

    fun mostrarAula(){
        try {
            println("Introduce el código del aula que desees ver")
            var codAula = readln().toInt()
            println(Conexion.obtenerAula(codAula))
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun mostrarAlumno(){
        try {
            println("Introduce el DNI del alumno que desees ver")
            var dni = readln()
            println(Conexion.obtenerAlumno(dni))
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun mostrarOrdenador(){
        try {
            println("Introduce el numero de serie del ordenador que desees ver")
            var sn = readln().toInt()
            println(Conexion.obtenerOrdenador(sn))
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun modOrdenador(){

        try {
            println("Introduce el número de serie del ordenador que quieras modificar\n")
            var sn = readln().toInt()

        println("¿Que parte deseas modificar?\n" +
                "1-RAM\n" +
                "2-CPU\n" +
                "3-HDD\n" +
                "3-CodAula\n")

        var seleccion = readln().toInt()

            when (seleccion){
                1->{
                    println("¿Cuanta RAM quieres instalar?")
                    var ram = readln().toInt()
                    Conexion.modRam(ram,sn)
                }
                2->{
                    println("¿Que CPU quieres instalar?")
                    var cpu = readln()
                    Conexion.modCpu(cpu,sn)
                }
                3->{
                    println("¿Cuantos Gb quieres instalar?")
                    var hdd = readln().toInt()
                    Conexion.modHdd(hdd,sn)
                }
                4->{
                    println("¿A que aula quieres migrar?")
                    var codAula = readln().toInt()
                    Conexion.modCodAula(codAula,sn)
                }
            }
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun modOAula(){

        try {
            println("Introduce el codigo del aula que quieras modificar\n")
            var codAula = readln().toInt()

            println("¿Que deseas modificar?\n" +
                    "1-Descripción\n" +
                    "2-Nombre del curso\n" +
                    "3-Codigo del curso\n")

            var seleccion = readln().toInt()

            when (seleccion){
                1->{
                    println("Introduce la nueva descripción")
                    var descripcion = readln()
                    Conexion.modDescripcionAula(descripcion,codAula)
                }
                2->{
                    println("Introduce el nuevo nombre del curso")
                    var nombCurso = readln()
                    Conexion.modNombreCursoAula(nombCurso,codAula)
                }
                3->{
                    println("Introduce el nuevo curso")
                    var curso = readln().toInt()
                    Conexion.modCodCursoAula(curso,codAula)
                }
            }
        }catch (ex:Exception){
            println(ex)
        }
    }


    fun modAlumno(){

        try {
            println("Introduce el DNI del alumno que quieras modificar\n")
            var dni = readln()

            println("¿Que datos deseas modificar?\n" +
                    "1-Nombre\n" +
                    "2-Apellido 1\n" +
                    "3-Apellido 2\n" +
                    "3-Codigo del curso\n")

            var seleccion = readln().toInt()

            when (seleccion){
                1->{
                    println("Introduce el nuevo nombre")
                    var nombre = readln()
                    Conexion.modNombreAlumno(nombre,dni)
                }
                2->{
                    println("Introduce el nuevo apellido 1")
                    var apellido = readln()
                    Conexion.modApellido1Alumno(apellido,dni)
                }
                3->{
                    println("Introduce el nuevo apellido 2")
                    var apellido = readln()
                    Conexion.modApellido2Alumno(apellido,dni)
                }
                4->{
                    println("Introduce el nuevo codigo del curso")
                    var codCurso = readln().toInt()
                    Conexion.modCodCursoAlumno(codCurso,dni)
                }
            }
        }catch (ex:Exception){
            println(ex)
        }
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

    fun meterDatosACascoporrillo(){
        for (i in 0..40){
            Conexion.addAlumno(Factoria.factoriaAlumno())
            Conexion.addAula(Factoria.factoriaAula())
            Conexion.addOrdenador(Factoria.factoriaOrdenador(Random.nextInt(100,300)))
        }
    }











