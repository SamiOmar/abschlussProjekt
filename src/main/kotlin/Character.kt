import kotlin.random.Random

open class Character(var name: String, var hp: Int, var defensiveValue: Int, var actions: List<Action>) {
    var isCursed: Boolean = false
    var totalHp: Int = 100
    val sakeErholung =
        Action(name = "Sake Erholung", healing = 0, damage = 0, defensiveValue = 0, isAreaEffect = false, curse = false)
    open fun doActions(action: Action, target: Character) {
        when {
            action.damage > 0 -> {
                var finalDamage = action.damage - target.defensiveValue
                if (finalDamage < 0) finalDamage = 0

                target.hp -= finalDamage
                if (target.hp <= 0) {
                    target.hp = 0
                    println("${target.name} ist besiegt!")
                } else {
                    println("$name verwendet ${action.name} und fügt ${target.name} \u001B[31m$finalDamage Schaden\u001B[0m zu. Verbleibende HP von ${target.name}: ${target.hp}")
                }
            }

            action.healing > 0 -> {
                val randomHealAmount = Random.nextInt(10, 101)
                this.hp += randomHealAmount
                if (this.hp > this.totalHp) this.hp = this.totalHp
                println("$name verwendet ${action.name} und erhält \u001B[32m$randomHealAmount HP\u001B[0m! Seine gesamte HP ist jetzt ${this.hp}")
            }

            action.defensiveValue > 0 -> {
                this.defensiveValue += action.defensiveValue
                println("$name verwendet ${action.name} und erhöht seine Verteidigung um ${action.defensiveValue}!")
            }

            action.isAreaEffect -> {
                // Logik für Flächeneffekt-Aktionen
                println("$name verwendet ${action.name}, ein Flächeneffekt!")
            }

            action.curse -> {
                target.isCursed = true
                println("$name verwendet ${action.name} und verflucht ${target.name}!")
            }
        }
    }
    open fun takeDamage(damage: Int) {
        val damageTaken = (damage - defensiveValue).coerceAtLeast(0)
        hp -= damageTaken
        println("$name nimmt $damageTaken Schaden.")
        if (hp <= 0) {
            hp = 0
            println("$name wurde besiegt.")
        }
    }
}

