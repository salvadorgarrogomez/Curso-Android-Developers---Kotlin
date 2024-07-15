package example.myapp

/*
abstract class AquariumFish : FishAction {
    abstract val color: String
    // Ejemplo de valor por defecto si no se espifica en la clase
    override fun eat() = println("yum")
}

class Shark: AquariumFish() {
    override val color = "grey"
    override fun eat(){
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish() {
    override val color = "gold"
    override fun eat(){
        println("eat algae")
    }
}

class Whale: AquariumFish() {
    override val color = "blue"
}

 */

interface FishAction{
    fun eat()
}

interface FishColor{
    val color:String
}

class Plecostomus(fishColor: FishColor = GoldColor): FishAction by PrintingFishAction("eat algae"), FishColor by fishColor{}
/*
class Plecostomus: FishAction, FishColor by GoldColor{
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

 */

class Shark(fishColor: FishColor = GreyColor): FishAction by PrintingFishAction("hunt and eat fish"), FishColor by fishColor{}
/*
class Shark: FishAction, FishColor{
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

 */

class PrintingFishAction(val food: String) : FishAction{
    override fun eat() {
        println(food)
    }
}

object GoldColor: FishColor{
    override val color = "gold"
}

object GreyColor: FishColor{
    override val color = "grey"
}




