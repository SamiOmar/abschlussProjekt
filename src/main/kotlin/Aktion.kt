class Action(
    val name: String = "",
    val damage: Int = 0,
    val healing: Int = 0,
    val protection: Boolean = false,
    val isAreaEffect: Boolean = false,//Für Entgegner
    val curse: Boolean = false,//Für Entgegner
    val summon: Boolean = false,//Für Entgegner
    val speedUp: Boolean = false,//Für Entgegner
    val defensiveValue: Int = 0
)

