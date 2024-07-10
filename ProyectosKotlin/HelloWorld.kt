fun main() {
    println("Hola, Mundo!")
    println("Hola, Kotlin!")

    // Variables 
    var myString = "Ejemplo de cadena de texto"
    println(myString)

    var myInt = 6
    // myInt = myInt + 5
    println("Este es el valor dado a la variable myInt: " + myInt)
    // Ejemplo de interpolacion
    println("Este es el valor dado a la variable myInt: $myInt")
    println(myInt)
    println(myInt - 1)

    var myDouble: Double = 6.5
    println(myDouble)

    var myFloat = 5.5f
    println(myFloat)

    var myBoolean = true
    println(myBoolean)

    // Constantes
    val myConst = "Mi propiedad constante"
    println(myConst)
 
    // Control de flujo
    // && (y)
    // || (o)
    if (myInt == 5 && myString == "Ejemplo de cadena de texto" ) {
        println("El número es igual que 5")
    } else if (myInt > 5 || myString == "Hola") {
        println("El número es mayor que 5")
    } else {
        println("El número es distinto de 5")
    }

    // Listados
    var myList = listOf("Salvador", "Garro", "Gomez")
    println(myList[0])
    println(myList)
    var myListMutable = mutableListOf("Rocio","Juarez")
    myListMutable.add("Legaz")
    println(myListMutable)

    // Sets 
    // No acepta duplicados
    val mySet = setOf("Salvador", "Garro", "Gomez", "Garro")
    println(mySet)

    // Mapas
    val myMap = mutableMapOf("Salvador" to 31, "Rocio" to 29, "Ana" to 25)
    myMap["Isa"] = 30
    println(myMap["Salvador"])
    println(myMap["Ana"])
    println(myMap["Isa"])

    // Bucles
    for (value in myList){
        println(value)
    }

    for (value in myMap){
        println(value)
    }

    var myCounter = 0
    while (myCounter < myList.count()){
        println(myList[myCounter])
        myCounter++
    }

    // Opcionales
    var myOptional: String? = null
    println(myOptional)
    myOptional = "Hola"
    println(myOptional)

    myFunction()

    var MyClass = MyClass("Salvador", 31)
    println(MyClass.name)
    println(MyClass.age)
} 

    // Funciones
fun myFunction(){
    println("Ejemplo de funcion")
}

// Clases

class MyClass(val name: String, val age: Int){

}

/*
    Comentarios
*/
// Comentarios