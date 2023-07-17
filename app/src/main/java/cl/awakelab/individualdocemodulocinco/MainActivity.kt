package cl.awakelab.individualdocemodulocinco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
*/

fun main() {
    val usuarios = ingresarUsuarios()

    println("\nUsuarios registrados (ordenados por edad de menor a mayor):")
    usuarios.forEachIndexed { index, usuario ->
        println("Usuario ${index + 1}:")
        println("Nombre: ${usuario.nombre}")
        println("Apellido: ${usuario.apellido}")
        println("Edad: ${usuario.edad}")
        println("Correo: ${usuario.correo}")
        println("Sistema de salud: ${usuario.sistemaSalud}")
        println()
    }
}

fun ingresarUsuarios(): List<Usuario> {
    val usuarios = mutableListOf<Usuario>()

    println("Ingrese la cantidad de usuarios a registrar:")
    val cantidadUsuarios = readLine()?.toIntOrNull()

    if (cantidadUsuarios == null || cantidadUsuarios <= 0) {
        println("Cantidad Inválida. Saliendo...")
        return usuarios
    }

    for (u in 1..cantidadUsuarios) {
        println("Ingrese nombre del Usuario $u")
        var nombre = readLine()?.trim()

        while (nombre == null || !validarNombre(nombre)) {
            println("Nombre inválido, ingrese un nombre válido")
            nombre = readLine()?.trim()
        }

        println("Ingrese apellido del Usuario $u")
        var apellido = readLine()?.trim()

        while (apellido == null || !validarApellido(apellido)) {
            println("Apellido inválido. Ingrese nuevamente:")
            apellido = readLine()?.trim()
        }

        println("Ingrese edad del Usuario $u")
        var edad = readLine()?.toIntOrNull()

        while (edad == null || !validarEdad(edad)) {
            println("Edad inválida. Ingrese nuevamente:")
            edad = readLine()?.toIntOrNull()
        }

        println("Ingrese correo del Usuario $u")
        var correo = readLine()?.trim()

        while (correo == null || !validarCorreo(correo)) {
            println("Correo inválido. Ingrese nuevamente:")
            correo = readLine()?.trim()
        }

        println("Ingrese sistema de salud del Usuario $u (Fonasa/Isapre/Particular)")
        var sistemaSalud = readLine()?.trim()

        while (sistemaSalud == null || !validarSistema(sistemaSalud)) {
            println("Sistema de salud inválido. Ingrese nuevamente:")
            sistemaSalud = readLine()?.trim()
        }

        val usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }

    return usuarios.sortedBy { it.edad }
}

fun validarNombre(nombre: String): Boolean {
    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}

fun validarApellido(apellido: String): Boolean {
    return apellido.matches("[a-zA-Z]+".toRegex())
}

fun validarEdad(edad: Int): Boolean {
    return edad > 0
}

fun validarCorreo(correo: String): Boolean {
    return correo.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}".toRegex())
}

/*fun validarSistemaSalud(sistemaSalud: String): Boolean {
    return sistemaSalud in listOf("fonasa", "isapre", "particular")
}*/

fun validarSistema(sistemaSalud: String): Boolean {
    if (sistemaSalud.uppercase().lowercase() == "Fonasa" || sistemaSalud.uppercase()
            .lowercase() == "Isapre" || sistemaSalud.uppercase().lowercase() == "Particular"
    ) {
        return false

    }
    return true
}
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val correo: String,
    val sistemaSalud: String
)





