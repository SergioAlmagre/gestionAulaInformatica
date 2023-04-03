package Factorias

import Centro.Alumno
import Centro.Aula
import Centro.Ordenador
import kotlin.random.Random

object Factoria {

    fun factoriaOrdenador(codAula:Int):Ordenador{

        var cpus = arrayOf("Intel core i3","Intel core i5","intel core i7","Intel core i9")
        var cpu = cpus[Random.nextInt(0,cpus.size-1)]
        var ram = Random.nextInt(4,64)
        var hdds = arrayOf(250,500,750,1000,1500,2000)
        var hdd = hdds[Random.nextInt(0,hdds.size-1)]

        return Ordenador(0,cpu,ram,hdd,codAula)
    }

    fun factoriaAlumno():Alumno{

        var dni = Random.nextInt(100000000,999999999).toString()
        val nombres = arrayOf("María", "Juan", "Lucía", "Pablo", "Lola", "Javier", "Ana", "Pedro", "Carmen", "Sergio", "Sara", "Ricardo", "Alicia", "Diego", "Laura", "Miguel", "Elena", "Carlos", "Raquel", "Jorge")
        var nombre = nombres[Random.nextInt(0,nombres.size-1)]
        val apellidos = arrayOf("García", "Martínez", "López", "González", "Rodríguez", "Fernández", "Pérez", "Gómez", "Sánchez", "Romero", "Navarro", "Vázquez", "Torres", "Díaz", "Muñoz", "Alvarez", "Ruíz", "Jiménez", "Moreno", "Hernández")
        var apellido1 = apellidos[Random.nextInt(0,apellidos.size-1)]
        var apellido2 = apellidos[Random.nextInt(0,apellidos.size-1)]
        var codCurso = Random.nextInt(0,300)

        return Alumno(dni, nombre,apellido1,apellido2,codCurso )
    }

    fun factoriaAula():Aula{

        val clasesInformatica = arrayOf("Programación Orientada a Objetos", "Estructuras de Datos", "Base de Datos", "Redes de Computadoras", "Algoritmos y Complejidad", "Inteligencia Artificial", "Sistemas Operativos", "Interacción Persona-Computadora", "Desarrollo Web", "Seguridad Informática")
        var descripciones = clasesInformatica[Random.nextInt(0,clasesInformatica.size-1)]
        var nombresCursos = arrayOf("DAM 1","DAM 2", "DAW 1", "DAW 2", "Ciberseguridad", "ASIR")
        var nombreCurso = nombresCursos[Random.nextInt(0,nombresCursos.size-1)]
        var codCurso = Random.nextInt(0,200)

        return Aula(0,descripciones,nombreCurso,codCurso)
    }


}