package Centro

class Ordenador {

    var sn: Int
    var cpu: String
    var ram: Int
    var hdd: Int
    var codAula: Int

    constructor(cod: Int, cpu: String, ram: Int, hd: Int, codAula: Int) {
        this.sn = cod
        this.cpu = cpu
        this.ram = ram
        this.hdd = hd
        this.codAula = codAula
    }

    override fun toString(): String {
        return "Aula(cod=$sn, cpu='$cpu', ram=$ram, hd=$hdd, codAula='$codAula')"
    }

}