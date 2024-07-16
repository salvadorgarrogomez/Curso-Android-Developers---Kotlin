package example.myapp

import java.lang.Math.PI

/*
class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    fun printSize(){
        println("Width: $width cm " +
                "height: $height cm " +
                "length: $length cm")
    }
}
 */

// De forma predeterminada las clases no se pueden subclasificar, para poder hacerlo se han de marcar como "open"

open class Aquarium(open var length: Int = 100,open var width: Int = 20, open var height : Int = 40) {
    init{
        println("Aquarium initializing")
    }
    /*
    init {
        // 1 litter = 1000cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }

     */
    fun printSize(){
        println(shape)
        println("Width: $width cm " +
                "Height: $height cm " +
                "Length: $length cm")
        // 1 liter = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }


    constructor (numberOfFish: Int) : this() {
        // 2000 cm^3 por pez + espacio extra para que no se derrame agua
        val tank = numberOfFish * 2000 * 1.1
        // calcular la altura necesaria
        height = (tank / (length * width)).toInt()
    }

    /*
    val volume: Int
        get() = width * height * length / 1000 // 100cm^3 = 1 liter

     */
    open var volume: Int
        get() = width * height * length / 1000
        // private: Solo es visible en esta propia clase
        // protected: Igual que private, pero tambien sera visible en las subclases
        // internal: Solo sera visible dentro del mismo package
        // public: Sra visible en cualquier lado del proyecto, por defecto en Kotlin todo es publico por tanto set(value) es lo mismo que public set(value)
        set(value){
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9
}

// Con los override podemos sobreescribir valores ya preexistentes en otra clase, para poder hacer esto, los valores originales deben de estar marcados como "open"
class TowerTank (override var height: Int, var diameter: Int) : Aquarium(height = height,width = diameter, length = diameter) {
    override var volume: Int
    // ellipse area : PI * r1 * r2
    get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value / 1000 * PI) / (width/2 * length/2)).toInt()
        }
    override var water = volume * 0.8
    override val shape = "cylinder"
}

