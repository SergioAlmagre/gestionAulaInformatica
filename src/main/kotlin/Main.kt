
import Factorias.Factoria
import java.sql.SQLException
import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {

    var seleccion = 0

    do {
        fantasiaMenu()
        try {
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
                        "15 - Borrar aula por código\n" +
                        "16 - Borrar todos los ordenadores\n" +
                        "17 - Borrar todos l@s alumn@s\n" +
                        "18 - Borrar todas las aulas\n" +
                        "19 - Destruir la base de datos\n" +
                        "20 - Construir la base de datos\n" +
                        "21 - Meter datos a cascoporrillo\n" +
                        "22 - Salir\n"
            )
            seleccion = readln().toInt()
        }catch (e:Exception){
            println(e)
        }

        when(seleccion){
            1-> insertarAula()
            2-> instertarOrdenador()
            3-> insertarAlumno()
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
    } while (seleccion in 1..21)
}

    fun fantasiaMenu(){
        println("Cargando menu de inicio")
        for (i in 0..10){
            print("- ")
            Thread.sleep(200)
        }
        println()
    }
    fun insertarAlumno(){
        Conexion.addAlumno(Factoria.factoriaAlumno())
        println("Datos insertados")
    }

    fun insertarAula(){
        Conexion.addAula(Factoria.factoriaAula())
        println("Datos insertados")
    }

    fun instertarOrdenador(){

        do{
            var ok = false
            try {
                mostrarTodasLasAulas()
                println("¿En que aula quieres poner el ordenador?")
                var codAula = readln().toInt()
                Conexion.addOrdenador(Factoria.factoriaOrdenador(codAula))
                ok = true
                println("Datos insertados")
            }catch (ex:Exception){
                println(ex)
            }
        }while(!ok)

    }

    fun construirBbdd(){
        Conexion.crearBaseDeDatos()
        for (i in 0..6){
            print ("- ")
            Thread.sleep(500)
        }
        println("Base de datos creada con éxito")
    }
    fun destruirBbdd(){
        var eleccion = -1
        var confirmacion = -1

        try {
            println("¿Estás serguro de querer borrar toda la base de datos?\n" +
                    "0 - Cancelar\n" +
                    "1 - Borrar BBDD\n")
            eleccion = readln().toInt()

            if (eleccion == 1){
                println("Borrar la base de datos es un proceso irreversible, ¿seguro que quieres hacerlo?\n" +
                        "0 - Cancelar\n" +
                        "1 - Borrar BBDD\n")
                confirmacion = readln().toInt()
            }
            if (confirmacion == 1){
                Conexion.borrarBaseDeDatos()
            }

        }catch (ex:Exception){
            println(ex)
        }

        if (eleccion == 0 || confirmacion == 0){
            println("proceso cancelado")
        }else{
            println("Base de datos borrada")
        }
    }

    fun borrarAula(){
        try {
            mostrarTodasLasAulas()
            println("Introduce el codigo del aula que desees borrar")
            val codAula = readln().toInt()
            Conexion.borrarAula(codAula)
            println("Borrado con éxito")
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun borrarOrdenador(){
        try {
            println("Introduce el numero de serie del ordenador que desees borrar")
            val sn = readln().toInt()
            Conexion.borrarOrdenador(sn)
            println("Borrado con éxito")
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun borrarAlumno(){
        try {
            println("Introduce el DNI del alumno que desees borrar")
            val dni = readln()
            Conexion.borrarAlumno(dni)
            println("Borrado con éxito")
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun mostrarAula(){
        try {
            println("Introduce el código del aula que desees ver")
            val codAula = readln().toInt()
            println(Conexion.obtenerAula(codAula))
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun mostrarAlumno(){
        try {
            println("Introduce el DNI del alumno que desees ver")
            val dni = readln()
            println(Conexion.obtenerAlumno(dni))
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun mostrarOrdenador(){
        try {
            println("Introduce el numero de serie del ordenador que desees ver")
            val sn = readln().toInt()
            println(Conexion.obtenerOrdenador(sn))
        }catch (ex:Exception){
            println(ex)
        }
    }

    fun modOrdenador(){

        try {
            println("Introduce el número de serie del ordenador que quieras modificar\n")
            val sn = readln().toInt()

        println("¿Que parte deseas modificar?\n" +
                "1-RAM\n" +
                "2-CPU\n" +
                "3-HDD\n" +
                "3-CodAula\n")

            when (readln().toInt()){
                1->{
                    println("¿Cuanta RAM quieres instalar?")
                    val ram = readln().toInt()
                    Conexion.modRam(ram,sn)
                }
                2->{
                    println("¿Que CPU quieres instalar?")
                    val cpu = readln()
                    Conexion.modCpu(cpu,sn)
                }
                3->{
                    println("¿Cuantos Gb quieres instalar?")
                    val hdd = readln().toInt()
                    Conexion.modHdd(hdd,sn)
                }
                4->{
                    println("¿A que aula quieres migrar?")
                    val codAula = readln().toInt()
                    Conexion.modCodAula(codAula,sn)
                }
            }
        }catch (ex:Exception){
            println(ex)
        }
        println("Datos insertados")
    }

    fun modOAula(){

        try {
            println("Introduce el codigo del aula que quieras modificar\n")
            val codAula = readln().toInt()

            println("¿Que deseas modificar?\n" +
                    "1-Descripción\n" +
                    "2-Nombre del curso\n" +
                    "3-Codigo del curso\n")

            when (readln().toInt()){
                1->{
                    println("Introduce la nueva descripción")
                    val descripcion = readln()
                    Conexion.modDescripcionAula(descripcion,codAula)
                }
                2->{
                    println("Introduce el nuevo nombre del curso")
                    val nombCurso = readln()
                    Conexion.modNombreCursoAula(nombCurso,codAula)
                }
                3->{
                    println("Introduce el nuevo curso")
                    val curso = readln().toInt()
                    Conexion.modCodCursoAula(curso,codAula)
                }
            }
        }catch (ex:Exception){
            println(ex)
        }
        println("Datos insertados")
    }


    fun modAlumno(){

        try {
            println("Introduce el DNI del alumno que quieras modificar\n")
            val dni = readln()

            println("¿Que datos deseas modificar?\n" +
                    "1-Nombre\n" +
                    "2-Apellido 1\n" +
                    "3-Apellido 2\n" +
                    "3-Codigo del curso\n")

            when (readln().toInt()){
                1->{
                    println("Introduce el nuevo nombre")
                    val nombre = readln()
                    Conexion.modNombreAlumno(nombre,dni)
                }
                2->{
                    println("Introduce el nuevo apellido 1")
                    val apellido = readln()
                    Conexion.modApellido1Alumno(apellido,dni)
                }
                3->{
                    println("Introduce el nuevo apellido 2")
                    val apellido = readln()
                    Conexion.modApellido2Alumno(apellido,dni)
                }
                4->{
                    println("Introduce el nuevo codigo del curso")
                    val codCurso = readln().toInt()
                    Conexion.modCodCursoAlumno(codCurso,dni)
                }
            }
        }catch (ex:Exception){
            println(ex)
        }
        println("Datos insertados")
    }


    fun mostrarTodosLosOrdenadores(){
        val ordenadores = Conexion.obtenerOrdenadorArrayList()
        for (e in ordenadores){
            println(e)
        }
    }

    fun mostrarTodosLosAlumnos(){
        val alumnos = Conexion.obtenerAlumnoArrayList()
        for (e in alumnos){
            println(e)
        }
    }

    fun mostrarTodasLasAulas(){
        val aulas = Conexion.obtenerAulasArrayList()
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
        println("Datos insertados")
    }











