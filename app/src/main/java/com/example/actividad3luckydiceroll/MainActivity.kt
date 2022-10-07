package com.example.actividad3luckydiceroll

// Importación de librerias
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var btn1: Button? = null
    var txt: TextView? = null
    var mensaje: TextView? = null
    // El metodo onCreate es llamado cuando la app se abre por primera vez, El resto configura el elemento MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mensaje= findViewById<EditText>(R.id.Mensaje)
        btn1 = findViewById<Button>(R.id.button)
    }



    fun Crear(view: View) {
        var rollResult=0
        val myFirstDice = dann(6)

        rollResult = myFirstDice.roll()

        txt?.setText(rollResult.toString())
        val luckyNumber = 6
        // Se utiliza esta sentencia para las pruebas en base a resultados
        // luego se imprime los resultados en pantalla

        when (rollResult) {
            luckyNumber -> mensaje?.setText("Ganaste!")
            1 -> mensaje?.setText("¡Lo siento mucho! Obtuviste un 1. Inténtalo de nuevo!")
            2 -> mensaje?.setText("Lamentablemente, sacaste un 2. Inténtalo de nuevo!")
            3 -> mensaje?.setText("Desafortunadamente, sacaste un 3. Inténtalo de nuevo!")
            5 -> mensaje?.setText("¡No llores! Obtuviste un 5. Inténtalo de nuevo!")
            4 -> mensaje?.setText("¡Disculpa! Obtuviste un 4. Inténtalo de nuevo!")
        }
    }
}


class dann (val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}