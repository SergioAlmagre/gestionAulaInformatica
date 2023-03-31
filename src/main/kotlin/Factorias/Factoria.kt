package Factorias

import Centro.Ordenador
import kotlin.random.Random

object Factoria {

    fun factoriaOrdenador(sn:Int,codAula:Int):Ordenador{

        var cpus = arrayOf("Intel core i3","Intel core i5","intel core i7","Intel core i9")
        var cpu = cpus[Random.nextInt(0,cpus.size-1)]
        var ram = Random.nextInt(4,64)
        var hdds = arrayOf(250,500,750,1000,1500,2000)
        var hdd = hdds[Random.nextInt(0,hdds.size-1)]

        var ordenador = Ordenador(sn,cpu,ram,hdd,codAula)

        return ordenador
    }


}