// Import der Farbkonstanten, die in Ihrem Projekt definiert sein müssen.
import ColorConstants.blueColor
import ColorConstants.magentaColor
import ColorConstants.redColor
import ColorConstants.resetColor
import kotlin.random.Random

// Basisklasse, die einen Charakter im Spiel repräsentiert
open class Character(
    var name: String, // Der Name des Charakters
    var hp: Int, // Die Lebenspunkte des Charakters
    var defensiveValue: Int, // Der Verteidigungswert des Charakters
    var actions: List<Action> // Die Aktionen, die der Charakter ausführen kann
) {
    var isProtected = false // Zeigt an, ob der Charakter geschützt ist
    open var hasUsedBackpack = false // Zeigt an, ob der Rucksack in dieser Runde schon benutzt wurde
    var isCursed: Boolean = false // Zeigt an, ob der Charakter verflucht ist
    var totalHp: Int = 100 // Die Gesamtlebenspunkte, die der Charakter maximal haben kann

    // Eine Aktion, die keine Auswirkungen hat und als Platzhalter dient
    val sakeRecovery = Action("Sake Erholung", healing = 0, damage = 0, defensiveValue = 0, isAreaEffect = false, curse = false)

    // Funktion, die es dem Charakter erlaubt, eine Aktion auszuführen
    open fun doActions(action: Action, target: Character) {
        when {
            action.damage > 0 -> { // Wenn die Aktion Schaden anrichtet
                var finalDamage = action.damage - target.defensiveValue
                finalDamage = finalDamage.coerceAtLeast(0)

                target.hp -= finalDamage
                if (target.hp <= 0) {
                    target.hp = 0
                    println("${target.name} ist besiegt!")
                } else {
                    println("$name verwendet ${action.name} und fügt ${target.name} \u001B[31m$finalDamage Schaden\u001B[0m zu. Verbleibende HP von ${target.name}: ${target.hp}")
                }
            }

            action.healing > 0 -> { // Wenn die Aktion Heilung bewirkt
                val randomHealAmount = Random.nextInt(10, 101)
                this.hp += randomHealAmount
                if (this.hp > this.totalHp) this.hp = this.totalHp
                println("$name verwendet ${action.name} und erhält \u001B[32m$randomHealAmount HP\u001B[0m! Seine gesamte HP ist jetzt ${this.hp}")
            }

            action.defensiveValue > 0 -> { // Wenn die Aktion die Verteidigung erhöht
                this.defensiveValue += action.defensiveValue
                println("$name verwendet ${action.name} und erhöht seine Verteidigung um ${action.defensiveValue}!")
            }

            action.isAreaEffect -> { // Wenn die Aktion einen Flächeneffekt hat
                println("$name verwendet ${action.name}, ein Flächeneffekt!")
            }

            action.curse -> { // Wenn die Aktion einen Fluch auslöst
                target.isCursed = true
                println("$name verwendet ${action.name} und verflucht ${target.name}!")
            }
        }
    }

    // Funktion, die berechnet, wie viel Schaden ein Charakter nimmt
    open fun takeDamage(damage: Int): Int {
        val damageTaken = (damage - defensiveValue).coerceAtLeast(0)
        hp -= damageTaken

        val heroText = name
        val damageText = "${redColor}$damageTaken${resetColor}"
        val message = "$heroText ist getroffen und hat $damageText Schaden."

        println("${blueColor}$message")

        if (hp <= 0) {
            hp = 0
            println("${blueColor}$heroText${resetColor} wurde besiegt.")
        }

        return damageTaken
    }
}
