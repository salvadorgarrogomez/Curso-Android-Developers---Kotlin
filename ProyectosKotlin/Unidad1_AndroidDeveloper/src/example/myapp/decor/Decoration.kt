package example.myapp.decor

data class Decoration(val rocks: String) {
}

// Here is a data class with 3 properties
data class Decoration2(val rocks: String, val wood: String, val diver: String) {
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}
enum class Direction(val degress: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun makeDecorations(){
    val decoration1 = Decoration("granite")
    println(decoration1)
    val decoration2 = Decoration("slate")
    println(decoration2)
    val decoration3 = Decoration("slate")
    println(decoration3)

    // Comparativa para obtener true o false al comparar distintos valores
    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))

    // Ambas formas realizan el mismo trabajo, .equals es igual al ==
    // println(decoration1 == decoration2)
    // println(decoration3 == decoration2)

    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)
    // Assign all properties to variables
    val(rocks, wood, diver) = d5
    println(rocks)
    println(wood)
    println(diver)

}

class Choice{
    companion object{
        var name: String = "lyric"
        // const val name: String = "lyric"
        fun showDescription(name:String) = println("My favorite $name")
    }
}

fun main(){
    /* makeDecorations()
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degress)
     */
    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")

    val fish = listOf("shark","whale","salmon","barbo")
    val twoLists = fish.partition{isFreshWater(it)}
    println("freshwater: ${twoLists.first}")
    println("saltwater: ${twoLists.second}")
}

fun isFreshWater(fish: String) : Boolean {
    return when(fish){
        "shark" -> false
        "whale" -> false
        "salmon" -> true
        "barbo" -> true
        else -> false
    }
}