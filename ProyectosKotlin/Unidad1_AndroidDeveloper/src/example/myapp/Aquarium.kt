package example.myapp

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

class Aquarium(var length: Int = 100, var width: Int = 20, var height : Int = 40) {
    init{
        println("Aquarium initializing")
    }
    init {
        // 1 litter = 1000cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }

    fun printSize(){
        println("Width: $width cm " +
                "Height: $height cm " +
                "Length: $length cm")
    }

    constructor (numberOfFish: Int) : this() {
        // 2000 cm^3 por pez + espacio extra para que no se derrame agua
        val tank = numberOfFish * 2000 * 1.1
        // calcular la altura necesaria
        height = (tank / (length * width)).toInt()
    }
}
