const val MAX_EXPERIENCE: Int = 5000
const val PUB: String = "Unicorn's Horn"
const val HERO: String = "Estragon"

fun main(args: Array<String>) {
    var hasSteed = false
    var gold = 50
    var publican = "Barkeep #1"

    val drinks = setOf<String>("wine", "mead", "laCroix")
    // traverse a set
    drinks.forEach { e -> println(e)}


    // to traverse an array of drinks:
//    for(i in drinks.indices){
//        println(drinks[i])
//    }

    var experiencePoints = 5
    println(experiencePoints)

    var heroReversed = HERO.reversed()
    println(heroReversed)

}






