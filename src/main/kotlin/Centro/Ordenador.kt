package Centro

class Ordenador {

    var cod: Int
    var cpu: String
    var ram: Int
    var hd: Int
    var codAula: String

    constructor(cod: Int, cpu: String, ram: Int, hd: Int, codAula: String) {
        this.cod = cod
        this.cpu = cpu
        this.ram = ram
        this.hd = hd
        this.codAula = codAula
    }

    override fun toString(): String {
        return "Aula(cod=$cod, cpu='$cpu', ram=$ram, hd=$hd, codAula='$codAula')"
    }

}