package example.myapp


fun buildAquarium(){
    /*
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()
    */

    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // Default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // Default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // Everithing custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")
}

fun main(){
    buildAquarium()
}
