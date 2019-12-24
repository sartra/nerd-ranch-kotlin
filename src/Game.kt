fun main(args: Array<String>) {
    var name = "Madrigal"
    var healthPoints = 77
    val isBlessed = true
    val isImmortal = false
    val race = "gnome"

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    // Aura
    val (auraVisible, auraColor) = auraColor(isBlessed, healthPoints, isImmortal, karma)

    if(auraVisible) println("Aura is $auraColor")



    println("(Aura: $auraColor) " +
        "(Blessed: ${if (isBlessed) "YES" else "NO"})")

    printPlayerStatus(healthPoints, isBlessed, name)

    var arrowsInQuiver = 2
    if (arrowsInQuiver >= 5)
        println("Plenty of arrows")
    println("Cannot hold any more arrows")


    assignRace(race)

    castFireball(33)

}



private fun assignRace(race: String) {
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "unknown race"
    }
    println("race: $faction")
}

private fun printPlayerStatus(healthPoints: Int, isBlessed: Boolean, name: String) {
    val healthStatus = formatttedHealthStatus(healthPoints, isBlessed)

    println("$name $healthStatus")
}

private fun auraColor(
    isBlessed: Boolean,
    healthPoints: Int,
    isImmortal: Boolean,
    karma: Int
): Pair<Boolean, String> {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    val auraColor = when (karma) {
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        else -> "GREEN"
    }
    return Pair(auraVisible, auraColor)
}

// single expression
//private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
//    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun formatttedHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quickly"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition!"
    }

//private fun castFireball(numFireballs: Int  = 2) =  // sets default to 2 if no arg is passed
//    println("A glass of Fireball springs into existence (x$numFireballs)")
//

private fun castFireball(numFireballs: Int  = 2): Pair<Int, String> {
    println("A glass of Fireball springs into existence (x$numFireballs)")
    val inebriation = when (numFireballs) {
        in 40..50 -> "Extreme fireball inebriation"
        in 20..39 -> "Moderate fireball inebriation"
        else -> "Not yet inebriated by fireballs"
    }
    println(inebriation)
    return Pair(numFireballs, inebriation)
}
