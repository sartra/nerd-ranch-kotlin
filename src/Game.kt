fun main(args: Array<String>) {
    var name = "Madrigal"
    var healthPoints = 77
    val isBlessed = true
    val isImmortal = false

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    val auraColor = if (auraVisible) "GREEN" else "NONE"

    println("(Aura: $auraColor) " +
        "(Blessed: ${if (isBlessed) "YES" else "NO"})")

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quickly"
        } else {
            "has some minor wountds."
        }
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition!"
    }

    println("$name $healthStatus")
    println(auraColor)

    var arrowsInQuiver = 2
    if (arrowsInQuiver >= 5)
        println("Plenty of arrows")
    println("Cannot hold any more arrows")


//    val race = "gnome"
//    val faction = when (race) {
//        "dwarf" -> "Keepers of the Mines"
//        "gnome" -> "Keepers of the Mines"
//        "orc" -> "Free People of the Rolling Hills"
//        "human" -> "Free People of the Rolling Hills"
//    }

}

