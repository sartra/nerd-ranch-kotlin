fun main(args: Array<String>) {

//    println({
//        val currentYear = 2018
//        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
//    }())

//    val greetingFunction: () -> String = {
//        val currentYear = 2018
//        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
//    }
//
//    println(greetingFunction())




//    val greetingFunction: (String) -> String = {
//        val currentYear = 2018
//        "Welcome to SimVillage, $it! (copyright $currentYear)"
//    }
//    println(greetingFunction("Guyal"))


//    val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
//        val currentYear = 2018
//        println("Adding $numBuildings houses")
//        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
//    }
//
//    runSimulation("Guyal", greetingFunction)


//    runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
//        val currentYear = 2018
//        println("Adding $numBuildings houses")
//        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
//    }

    runSimulation()

}


// FUNCTION REFERENCES: - printConstructionCost sent as a fun ref in runSimulation ^
//inline fun runSimulation(playerName: String,
//                         costPrinter: (Int) -> Unit,
//                         greetingFunction: (String, Int) -> String) {
//    val numBuildings = (1..3).shuffled().last()   // Randomly selects 1, 2, or 3
//    costPrinter(numBuildings)
//    println(greetingFunction(playerName, numBuildings))
//}
//
//fun printConstructionCost(numBuildings: Int) {
//    val cost = 500
//    println("construction cost: ${cost * numBuildings}")
//}


// FUNCTION AS A RETURN TYPE:
fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
}

// This is like a “function factory” – a function that sets up another function
fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}