import java.lang.Exception

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null // nullable int - if null you are an incompetent juggler
    val isJugglingProficient = (1..3).shuffled().last() == 3 // you have a 1/3 chance of being proficient
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1) // using the non-null !! operator on a nullable int is dangerous - will throw a KotlinNullPointerException 2/3 times
        } catch (e: Exception) {
            println(e)
        }

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
//    swordsJuggling ?: throw UnskilledSwordJugglerException()
    checkNotNull(swordsJuggling, { "Player cannot juggle swords!" }) // precondition function - checkNotNull takes two arguments: The first is a value to check for nullness, and the second is an error message to be printed to the console in the event that the first argument is null.
}

class UnskilledSwordJugglerException() :
    IllegalStateException("Player cannot juggle swords")

fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 3, { "Juggle at least 3 swords to be exciting." })
    // Juggle
}