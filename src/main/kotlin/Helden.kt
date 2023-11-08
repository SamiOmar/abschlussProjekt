// Import statements for required classes should be here.

class Hero(name: String, hp: Int, defensiveValue: Int, actions: List<Action>, val backpack: Backpack = Backpack()) : Character(name, hp, defensiveValue, actions) {
    var hasUsedBackpack = false

    fun useBackpack(target: Character) {
        if (!hasUsedBackpack) {
            interactWithBackpack(target)
            hasUsedBackpack = true
        } else {
            println("$name hat in dieser Runde bereits den Rucksack benutzt!")
        }
    }

    private fun interactWithBackpack(target: Character) {
        println("\u001B[34mIn deinem Rucksack hast du:\u001B[0m")
        println("1. Heiltränke: ${backpack.healthDrink}")
        println("2. Vitamine: ${backpack.vitamins}")
        println("3. Fleisch: ${backpack.meat}")
        println("Bitte wähle einen Gegenstand zum Verwenden (1-3) oder drücke eine andere Taste, um zurückzugehen.")

        val userInput = readLine()
        when (userInput) {
            "1" -> useItem("healthDrink", target)
            "2" -> useItem("vitamins", target)
            "3" -> useItem("meat", target)
            else -> {
                println("Ungültige Wahl oder Zurückgehen.")
                hasUsedBackpack = false // Nutzer hat den Rucksack nicht benutzt, also zurücksetzen
            }
        }
    }

    private fun useItem(itemType: String, target: Character) {
        when (itemType) {
            "healthDrink" -> {
                if (backpack.healthDrink > 0) {
                    val healAmount = minOf(50, target.totalHp + target.hp)
                    target.hp += healAmount
                    backpack.healthDrink
                    println("$name verwendet einen Heiltrank und erhält \u001B[32m$healAmount HP\u001B[0m! Seine gesamte HP ist jetzt ${target.hp}.")
                } else {
                    println("Du hast keine Heiltränke mehr.")
                }
            }

            "vitamins" -> {
                if (backpack.vitamins > 0) {
                    val bonusHp = 20
                    target.totalHp += bonusHp
                    backpack.vitamins
                    println("$name verwendet Vitamine und erhöht seine Gesamt-HP um \u001B[32m$bonusHp\u001B[0m.")
                } else {
                    println("Du hast keine Vitamine mehr.")
                }
            }

            "meat" -> {
                if (backpack.meat > 0) {
                    val healAmount = minOf(30, target.totalHp + target.hp)
                    target.hp += healAmount
                    backpack.meat
                    println("$name isst Fleisch und heilt \u001B[32m$healAmount HP\u001B[0m!")
                } else {
                    println("Du hast kein Fleisch mehr.")
                }
            }
        }
    }

    fun resetBackpackUsage() {
        hasUsedBackpack = false
    }
}

class Backpack(var healthDrink: Int = 3, var vitamins: Int = 3, var meat: Int = 3)

