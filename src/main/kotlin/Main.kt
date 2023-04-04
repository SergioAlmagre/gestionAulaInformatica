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
                        "13 - Borrar por serial number\n" +
                        "14 - Borrar alumn@\n" +
                        "15 - Borrar todos los ordenadores\n" +
                        "16 - Borrar todos l@s alumn@s\n" +
                        "17 - Borrar todas las aulas\n" +
                        "18 - Destruir la base de datos\n" +
                        "19 - Construir la base de datos\n" +
                        "20 - Meter datos a cascoporrillo\n" +
                        "21 - Salir\n"
            )
            seleccion = readln().toInt()
        } while (seleccion !in 1..21 && seleccion != 21)
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
        7-> BorrarPorCodigo()
        8-> BorrarTodos()
        9-> Salir()
        10-> mostrarTodosLosAlumnos()
        11-> mostrarTodasLasAulas()
        12-> mostrarTodosLosOrdenadores()
        13-> Salir()
        14-> Salir()
        15-> Conexion.borrarTodosLosOrdenadores()
        16-> Conexion.borrarTodosLosAlumnos()
        17-> Conexion.borrarTodasAulas()
        18-> Salir()
        19-> Salir()
        20-> meterDatosACascoporrillo()
        21-> println("Hasta la vista")
    }


//    Conexion.borrarOrdenador(20)
//    Conexion.borrarAlumno("105618958")
//    Conexion.borrarAula(21)


//    println(Conexion.obtenerAlumno("105618958"))
//    println(Conexion.obtenerAula(21))
//    println(Conexion.obtenerOrdenador(25))



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











