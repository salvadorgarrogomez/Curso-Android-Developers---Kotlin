package example.myapp


fun buildAquarium(){
    /*
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()


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

     */

    /*
    val aquarium6 = Aquarium(numberOfFish = 29)
        aquarium6.printSize()
        // println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")
        aquarium6.volume = 70
        aquarium6.printSize()
        aquarium6.volume = 10
        aquarium6.printSize()

     */
    val aquarium6 = Aquarium(length = 25,width = 25,height = 40)
        aquarium6.printSize()
    val myTower = TowerTank(diameter = 25,height = 40)
        myTower.printSize()
}

fun makeFish(){
    val shark = Shark()
    val pleco = Plecostomus()
    // val whale = Whale()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
    // println("Whale: ${whale.color}")
    // whale.eat()
}

fun main(){
    // buildAquarium()
    makeFish()
}
