import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
var pints = 0
var remainingDragonsBreath = 5.0
var pintsLeftInCask = (5 / 0.125).toInt()

fun main(args: Array<String>) {

    placeOrder("shandy,Dragon's Breath,5.91")

//    placeOrder("elixir,Shirley's Temple,4.12")

    // unicode chars
    val omSymbol = '\u0950'
    print(omSymbol)

    // traversing a string
//    "Dragon's Breath".forEach {
//        println("$it\n")
//    }
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    // Destructuring can often be used to simplify the assignment of variables. Any time the result is a list, a destructuring assignment is allowed. In addition to List, other types that support destructuring include Maps and Pairs
    val (type, name, price) = menuData.split(',')

    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDouble())
    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name! IT'S GOT WHAT ADVENTURERS CRAVE!")}"

    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
}

// replace accepts a regular expression (more on that in a moment) to determine what characters it should act on and calls an anonymous function that you define to determine what to replace the matched characters with.
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value.toLowerCase()) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

fun performPurchase(price: Double) {
    pints++
    pintsLeftInCask = (pintsLeftInCask - (0.125 * pints)).toInt()
    remainingDragonsBreath = remainingDragonsBreath - (5 * 0.125)
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")


    if (totalPurse > price) {
        val remainingBalance = totalPurse - price
        println("Remaining balance: ${"%.2f".format(remainingBalance)}")
        val remainingGold = remainingBalance.toInt()
        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
        playerGold = remainingGold
        playerSilver = remainingSilver
        displayBalance()
    } else {
        displayBalance()
        println("GAME OVER --- You do not have enough $$$")
    }
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver, Pints: $pints, remaining Dragons Breath: $remainingDragonsBreath gallons, Pints left in cask: $pintsLeftInCask pints left in cask")
}