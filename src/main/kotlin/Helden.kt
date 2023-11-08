// Definiert eine Klasse "Hero", die von "Character" erbt
class Hero(
    name: String, // Name des Helden
    hp: Int, // Lebenspunkte des Helden
    defensiveValue: Int, // Verteidigungswert des Helden
    actions: List<Action>, // Liste von Aktionen, die der Held ausführen kann
    val backpack: Backpack = Backpack() // Rucksack des Helden mit Gegenständen
) : Character(name, hp, defensiveValue, actions) {

    var isStunned = false // Zeigt an, ob der Held betäubt ist
    var isBlinded = false // Zeigt an, ob der Held geblendet ist

    // Funktion, die die Interaktion mit dem Rucksack ermöglicht
    fun useBackpack(target: Character) {
        if (!hasUsedBackpack) {
            interactWithBackpack(target)
            hasUsedBackpack = true
        } else {
            println("$name hat in dieser Runde bereits den Rucksack benutzt!")
        }
    }

    // Hilfsfunktion für "useBackpack", die die Interaktion mit dem Rucksack abwickelt
    fun interactWithBackpack(target: Character) {
        println("\u001B[34mIn deinem Rucksack hast du:\u001B[0m")
        println("1. Heiltränke: ${backpack.healthPotions}")
        println("2. Vitamine: ${backpack.vitamins}")
        println("3. Fleisch: ${backpack.meat}")
        println("Bitte wähle einen Gegenstand zum Verwenden (1-3) oder drücke eine andere Taste, um zurückzugehen.")

        val userInput = readLine()
        when (userInput) {
            "1" -> useItem("healthPotion", target)
            "2" -> useItem("vitamins", target)
            "3" -> useItem("meat", target)
            else -> {
                println("Ungültige Wahl oder Zurückgehen.")
                hasUsedBackpack = false // Nutzer hat den Rucksack nicht benutzt, also zurücksetzen
            }
        }
    }

    // Funktion, die die Verwendung eines bestimmten Gegenstands aus dem Rucksack handhabt
    fun useItem(itemType: String, target: Character) {
        when (itemType) {
            "healthPotion" -> {
                if (backpack.healthPotions > 0) {
                    val healAmount = minOf(50, target.totalHp + target.hp)
                    target.hp += healAmount
                    backpack.healthPotions--
                    println("$name verwendet einen Heiltrank und erhält \u001B[32m$healAmount HP\u001B[0m! Seine gesamte HP ist jetzt ${target.hp}.")
                } else {
                    println("Du hast keine Heiltränke mehr.")
                }
            }
            "vitamins" -> {
                if (backpack.vitamins > 0) {
                    target.totalHp += 20
                    backpack.vitamins--
                    println("$name verwendet Vitamine und erhöht seine Gesamt-HP um \u001B[32m20\u001B[0m.")
                } else {
                    println("Du hast keine Vitamine mehr.")
                }
            }
            "meat" -> {
                if (backpack.meat > 0) {
                    val healAmount = minOf(30, target.totalHp + target.hp)
                    target.hp += healAmount
                    backpack.meat--
                    println("$name isst Fleisch und heilt \u001B[32m$healAmount HP\u001B[0m!")
                } else {
                    println("Du hast kein Fleisch mehr.")
                }
            }
        }
    }

    // Funktion zum Zurücksetzen des Zustands, ob der Rucksack benutzt wurde
    fun resetBackpackUsage() {
        hasUsedBackpack = false
    }
}

// Definiert eine Klasse "Backpack", die verschiedene Gegenstände speichert
class Backpack(
    var healthPotions: Int = 3, // Anzahl der Heiltränke
    var vitamins: Int = 3, // Anzahl der Vitamine
    var meat: Int = 3 // Anzahl von Fleischstücken
)
