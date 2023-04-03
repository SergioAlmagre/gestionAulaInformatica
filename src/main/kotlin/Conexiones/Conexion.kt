import Centro.Alumno
import Centro.Aula
import Centro.Ordenador
import Conexiones.Constantes
import java.sql.*

object Conexion {
    // ********************* Atributos *************************
    var conexion: Connection? = null

    // Atributo a través del cual hacemos la conexión física.
    var sentenciaSQL: Statement? = null

    // ----------------------------------------------------------
    fun abrirConexion(): Int {
        var cod = 0
        try {
            // Cargar el driver/controlador JDBC de MySql
            val controlador = "com.mysql.cj.jdbc.Driver"
            val URL_BD = "jdbc:mysql://" + Constantes.servidor+":"+Constantes.puerto+"/" + Constantes.bbdd
            Class.forName(controlador)

            // Realizamos la conexión a una BD con un usuario y una clave.
            conexion = DriverManager.getConnection(URL_BD, Constantes.usuario, Constantes.passwd)
            sentenciaSQL = Conexion.conexion!!.createStatement()
//            println("Conexion realizada con éxito")
        } catch (e: Exception) {
            println("Exception: " + e.message)
            cod = -1
        }
        return cod
    }

    fun cerrarConexion(): Int {
        var cod = 0
        try {
            conexion!!.close()
//            println("Desconectado de la Base de Datos") // Opcional para seguridad
        } catch (ex: Exception) {
            println("Error al cerrar la conexión.")
            cod = -1
        }
        return cod
    }


    fun addAlumno(alumno:Alumno):Int{
        var cod = 0
        val sentencia = ("INSERT INTO " + Constantes.tablaAlumno + " VALUES ('" + alumno.dni + "'," + "'" + alumno.nombre + "','"
                + alumno.apellido1 + "'," + "'" + alumno.apellido2 + "'" + ", " + alumno.codCurso +");")
        try {
            abrirConexion()

            this.sentenciaSQL!!.executeUpdate(sentencia)
        } catch (sq: SQLException) {
            //println("Error al insertar")
            cod = sq.errorCode
        }
        cerrarConexion()
        return cod
    }

    fun addAula(aula: Aula):Int{
        var cod = 0
        val sentencia = ("INSERT INTO " + Constantes.tablaAula + " VALUES (default,'" + aula.descripcion + "'," + "'" + aula.nombreCurso + "',"
                + aula.codCurso+ ");")
        try {
            abrirConexion()

            this.sentenciaSQL!!.executeUpdate(sentencia)
        } catch (sq: SQLException) {
            //println("Error al insertar")
            cod = sq.errorCode
        }
        cerrarConexion()
        return cod
    }


    fun addOrdenador(ordenador: Ordenador):Int{
        var cod = 0
        val sentencia = ("INSERT INTO ${Constantes.tablaOrdenador} VALUES (DEFAULT, '${ordenador.cpu}', ${ordenador.ram}, " +
                "${ordenador.hdd}  ,${ordenador.codAula} );")
        try {
            abrirConexion()
            this.sentenciaSQL!!.executeUpdate(sentencia)
        }catch (ex: SQLException){
            cod = ex.errorCode
        }
        cerrarConexion()
        return cod
    }

    fun modRam(cantidadRam:Int, sn:Int):Int{
        var cod = 0
        val sentencia = ("UPDATE ${Constantes.tablaOrdenador} SET RAM = $cantidadRam WHERE " +
                "SN = $sn ;")
        try{
            abrirConexion()
            this.sentenciaSQL!!.executeUpdate(sentencia)
        }catch (ex:SQLException){
            cod = ex.errorCode
        }
        cerrarConexion()
        return cod
    }

    fun obtenerAlumnoArrayList(): ArrayList<Alumno>{
        var datos: ArrayList<Alumno> = ArrayList()
        var registros: ResultSet? = null
        var cod: Int = 0

        try{
            while (registros!!.next()){
                datos.add(
                    Alumno(
                    registros.getString("dni"),
                    registros.getString("nombre"),
                    registros.getString("apellido1"),
                    registros.getString("apellido2"),
                    registros.getInt(0)
                    )
                )
            }

        }catch ( ex:SQLException){
            println(ex)
        }
        cerrarConexion()
    return datos
    }






//    fun obtenerCodAula(codAula: String):Persona?{
//        var p : Persona? = null
//        var registros: ResultSet? = null
//        try {
//            abrirConexion()
//            val sentencia = "SELECT * FROM " + Constantes.TablaPersonas + " WHERE dni = '" + dni + "'"
//            registros = sentenciaSQL!!.executeQuery(sentencia)
//            if (registros!!.next()) {
//                p =  Persona(
//                    registros.getString("dni"),
//                    registros.getString("nombre"),
//                    registros.getString(3),
//                    registros.getInt("tfno")
//                )
//            }
//        } catch (ex: SQLException) {
//        } finally {
//            cerrarConexion()
//        }
//
//        return p
//    }








}