package Centro

class Aula {

      var codAula:Int
      var descripcion: String
      var nombreCurso: String
      var codCurso: Int
      var ordenadores: ArrayList<Ordenador>


    constructor(codAula: Int, descripcion: String, nombreCurso: String, codCurso: Int) {
        this.codAula = codAula
        this.descripcion = descripcion
        this.nombreCurso = nombreCurso
        this.codCurso = codCurso
        this.ordenadores = ArrayList()
    }

    override fun toString(): String {
        return "Aula(codAula='$codAula', descripcion='$descripcion', nombreCurso='$nombreCurso', codCurso=$codCurso, ordenadores=$ordenadores)"
    }


}