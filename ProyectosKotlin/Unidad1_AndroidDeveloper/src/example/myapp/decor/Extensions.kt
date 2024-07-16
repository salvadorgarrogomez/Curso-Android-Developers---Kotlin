package example.myapp.decor

class Extensions {
}

fun String.hasSpaces() : Boolean {
    val found = this.indexOf(' ')
    // también válido: this.indexOf(" ")
    // devuelve un índice numérico positivo en String o -1 si no se encuentra
    return found != -1
}

// Ejemplo de la funcion anterior, en una sola linea, mas compacto
// fun String.hashSpaces() = indexOf(" ") != -1

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)

// fun AquariumPlant.isRed() = color == "red"  // Ok
// fun AquariumPlant.isBig() = size > 50       // gives error, ya que la val es privada

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun main(){
    val plant = GreenLeafyPlant(10)
    plant.print()
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() // what will it print?

}
/*
fun AquariumPlant?.pull(){
    this?.apply{
        println("removing $this")
    }
}
val plant: AquariumPlant? = null
plant.pull()

 */