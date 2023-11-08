open class Enemy(
    name: String, // Der Name des Gegners
    hp: Int, // Lebenspunkte des Gegners
    defensiveValue: Int, // Verteidigungswert des Gegners
    actions: List<Action> // Liste von Aktionen, die der Gegner ausführen kann
) : Character(name, hp, defensiveValue, actions)

// 'Boss' ist eine spezialisierte Form von 'Enemy' für Endgegner.
class Boss(
    name: String, // Der Name des Endgegners
    hp: Int, // Lebenspunkte des Endgegners
    defensiveValue: Int, // Verteidigungswert des Endgegners
    actions: List<Action> // Liste von Aktionen, die der Endgegner ausführen kann
) : Enemy(name, hp, defensiveValue, actions)
var hasSummonedUnderboss = false


// 'Underboss' ist eine Unterklasse von 'Enemy', speziell für Unterbosse.
class Underboss(
    name: String, // Der Name des Unterbosses
    hp: Int, // Lebenspunkte des Unterbosses
    defensiveValue: Int, // Verteidigungswert des Unterbosses
    actions: List<Action> // Liste von Aktionen, die der Unterboss ausführen kann
) : Enemy(name, hp, defensiveValue, actions) {
}
