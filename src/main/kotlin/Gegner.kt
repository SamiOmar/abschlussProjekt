
// Gegner-Klassen
open class Enemy(name: String, hp: Int, defensiveValue: Int, actions: List<Action>) : Character(name, hp, defensiveValue, actions)

// Endgegner-Klasse
class Boss(name: String, hp: Int, defensiveValue: Int, actions: List<Action>) : Enemy(name, hp, defensiveValue, actions)
    var hasSummonedUnderboss = false

// Unterboss-Klasse
class Underboss(name: String, hp: Int, defensiveValue: Int, actions: List<Action>) : Enemy(name, hp, defensiveValue, actions)

