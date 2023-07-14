package cl.awakelab.individualdocemodulocinco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    var usuarios = mutableListOf<Usuario>()

    println("Ingrese cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()

    for (i in 1..cantidadUsuarios) {
        println("Ingrese nombre")
        var nombre = readln()
        while (!validarNombre(nombre)){
            println("Nmbre inválido, ingrese un nombre válido")
            nombre = readln()
        }

        var apellido = readln()
        var edad = readln().toInt()
        var correo = readln()
        var sistemaSalud = readln()
        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios) {
        println(u)
    }

}

fun validarNombre(nombre: String): Boolean {
    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}

fun validarApellido(apellido: String): Boolean{
    return apellido.length in 1..20 && apellido.matches("-?[0-9]+(\\\\.[0-9]+)?".toRegex())
}

data class Usuario(
    var nombre: String,
    var apellido: String,
    var edad: Int,
    var correo: String,
    var sistemaSalud: String
)