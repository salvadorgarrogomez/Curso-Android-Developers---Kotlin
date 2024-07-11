
import java.util.Random

/* 
fun main(args: Array<String>) {
    printHello()
    println("Hola World!")

    // Will assing kotlin.Unit
    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
    val message = "The water temperature is ${if(temperature > 50) "too warm" else "OK"}."
    println(message)

    feedTheFish()

    swim()  // uso por defecto
    swim("slow")    // argumento posicional
    swim(speed = "turtle-like") // nombrando al parametro

}
*/

fun printHello() {
    println("Hello Kotlin!")
}

// Funciones, leccion 1 punto 2.3.1
fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Funciones, leccion 1 punto 2.3.2: Expresion When
fun fishFood(day : String) : String {
    return when(day){
        "Monday" -> "pellets"
        "Wednesday" -> "trout"
        "Thursday" -> "shrimp"
        "Friday" -> "cod"
        "Sunday" -> "swordtails"
        else -> "nothing"
    }
}

// Valores predeterminados
fun swim(speed: String = "fast"){
    println("The fish is swimming at $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean{
    return when{
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30 
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

// Filtros
val decorations = listOf("rock","pagoda","plastic plant","alligator","flowerpot")

fun main(){
    println(decorations.filter{it[0] == 'p'})

    // eager, creates a new list
    val eager = decorations.filter{it[0] == 'p'}
    println("eager: $eager")
    // lay, will wait until asked to evaulate
    val filtered = decorations.asSequence().filter{it[0] == 'p'}
    println("filtered: $filtered")
    // force evaultacion of the lazy list
    val newList = filtered.toList()
    println("new List: $newList")

    val lazyMap = decorations.asSequence().map{
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("----")
    println("first: ${lazyMap.first()}")
    println("----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter{it[0] == 'p'}.map{
        println("access: $it")
        it
    }
    println("----")
    println("filtered: ${lazyMap2.toList()}")

    // Flattening a list of lists (multi-dimensional array)
    val mySports = listOf("basketball","fishing","running")
    val myPlayers = listOf("Lebron James","Ernest Hemingway","Usain Bolt")
    val MyCities = listOf("Los Angeles","Chicago","Jamaica")
    val myList = listOf(mySports, myPlayers, MyCities) // Lista de listas
    println("----")
    println("Flat: ${myList.flatten()}")

    // Utilizacion de lambdas
/*     val dirtyLevel = 20
    val waterFilter = {dirty: Int -> dirty / 2}
    println(waterFilter(dirtyLevel)) */

    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))

    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) {
        dirtyLevel -> dirtyLevel + 23}
        println(dirtyLevel)
}

    // Utilizacion de lambdas
fun updateDirty(dirty: Int, operation:(Int) -> Int): Int{
    return operation(dirty)
}
fun increaseDirty( start: Int ) = start + 1