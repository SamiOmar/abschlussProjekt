import kotlin.random.Random

// Gegner-Klassen
open class Enemy(name: String, hp: Int, defensiveValue: Int, actions: List<Action>) : Character(name, hp, defensiveValue, actions){


    open fun doActionsForEnemies(action: Action, targets: List<Character>) {
        when {
            action.damage > 0 -> {
                // Feind verursacht Schaden
                for (target in targets) {
                    var finalDamage = action.damage - target.defensiveValue
                    finalDamage = finalDamage.coerceAtLeast(0)
                    target.hp -= finalDamage
                    if (target.hp <= 0) {
                        target.hp = 0
                        println("${target.name} ist besiegt!")
                    } else {
                        println("$name greift ${target.name} an und verursacht $finalDamage Schaden.")
                    }
                }
            }

            action.healing > 0 -> {
                // Feind heilt sich selbst oder Verbündete
                val randomHealAmount = Random.nextInt(10, action.healing)
                this.hp += randomHealAmount
                this.hp = this.hp.coerceAtMost(this.totalHp)
                println("$name heilt sich selbst und erhält $randomHealAmount HP zurück.")
            }

            action.defensiveValue > 0 -> {
                // Feind erhöht seine Verteidigung
                this.defensiveValue += action.defensiveValue
                println("$name erhöht seine Verteidigung um ${action.defensiveValue}.")
            }

            action.isAreaEffect -> {
                // Feind führt Flächeneffekt-Aktion aus
                println("$name verwendet ${action.name} und trifft alle Gegner im Bereich!")
                targets.forEach { target ->
                    target.takeDamage(action.damage)
                }
            }

            action.curse -> {
                // Feind verflucht ein Ziel oder mehrere Ziele
                targets.forEach { target ->
                    target.isCursed = true
                    println("$name verflucht ${target.name}!")
                }
            }

            action.summon -> {
                // Spezifisch für Boss oder Unterboss
                println("$name beschwört Verstärkung!")
                // Logik zum Hinzufügen von Verstärkung
            }

            action.speedUp -> {
                // Feind erhöht seine Geschwindigkeit
                println("$name erhöht seine Geschwindigkeit!")
                // Logik zur Geschwindigkeitserhöhung
            }
        }
    }
    }


// Endgegner-Klasse
class Boss(name: String, hp: Int, defensiveValue: Int, actions: List<Action>) : Enemy(name, hp, defensiveValue, actions) {
    var hasSummonedUnderboss = false
    var isProtected: Boolean = false


}

// Unterboss-Klasse
class Underboss(name: String, hp: Int, defensiveValue: Int, actions: List<Action>) : Enemy(name, hp, defensiveValue, actions) {
}

