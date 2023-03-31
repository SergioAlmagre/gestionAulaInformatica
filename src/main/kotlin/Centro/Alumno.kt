package Centro

class Alumno {

    var dni: String
    var nombre: String
    var apellido1: String
    var apellido2: String
    var codCurso: Int


    constructor(dni: String, nombre: String, apellido1: String, apellido2: String, curso: Int) {
        this.dni = dni
        this.nombre = nombre
        this.apellido1 = apellido1
        this.apellido2 = apellido2
        this.codCurso = curso
    }

    override fun toString(): String {
        return "Alumno(dni='$dni', nombre='$nombre', apellido1='$apellido1', apellido2='$apellido2', curso='$codCurso')"
    }


}