import ColorConstants.blueColor
import ColorConstants.greenColor
import ColorConstants.redColor
import ColorConstants.resetColor
import kotlin.random.Random

val RANDOM = Random
val GUM_GUM_PISTOLE = Action("Gum-Gum Pistole", damage = RANDOM.nextInt(150, 300))
val GUM_GUM_BAZOOKA = Action("Gum-Gum Bazooka", damage = RANDOM.nextInt(60, 100))
val SCHUTZZAUBER_LUFFY = Action("Haki", damage = RANDOM.nextInt(60, 100))
val HEILZAUBER_LUFFY = Action("Fleisch Erholung", healing = RANDOM.nextInt(50, 100))

val LUFFY = Hero(
    "Monkey D. Luffy",
    200,
    10,
    listOf(GUM_GUM_PISTOLE, GUM_GUM_BAZOOKA,SCHUTZZAUBER_LUFFY, HEILZAUBER_LUFFY))

val TATSUMAKI = Action("Tatsumaki", damage = RANDOM.nextInt(50, 90))
val ONIGIRI = Action("Onigiri", damage = RANDOM.nextInt(60, 90))
val SCHUTZZAUBER_ZORO = Action("Santoryu", damage = RANDOM.nextInt(50, 100))
val HEILZAUBER_ZORO = Action("Erholung", healing = RANDOM.nextInt(50, 100))

val ZORO = Hero(
    "Zoro",
    200,
    30,
    listOf(ONIGIRI, TATSUMAKI, SCHUTZZAUBER_ZORO, HEILZAUBER_ZORO))

val MIRAGE_TEMPO = Action("Mirage Tempo", damage = RANDOM.nextInt(50, 80))
val DONNERBOLZEN_TEMPO = Action("Donnerbolzen Tempo", damage = RANDOM.nextInt(40, 80))
val SCHUTZZAUBER_NAMI = Action("Wetterzauber", damage = RANDOM.nextInt(50, 100))
val HEILZAUBER_NAMI = Action("Orangentrank", healing = RANDOM.nextInt(50, 100))

val NAMI = Hero(
    "Nami",
    200,
    30,
    listOf(MIRAGE_TEMPO, DONNERBOLZEN_TEMPO, HEILZAUBER_NAMI, SCHUTZZAUBER_NAMI))

val HEROES = listOf(LUFFY, ZORO, NAMI)

// Aktionen des Endgegners
val SCHWARZESLOCH = Action("Schwarzes Loch", damage = RANDOM.nextInt(80, 200))
val BESCHÄDIGUNG = Action("schädigung", damage = RANDOM.nextInt(70, 200))
val FEUERATEM = Action("Feueratem", damage = RANDOM.nextInt(60, 200), isAreaEffect = true)
val UNTERBOSS_BESCHWÖREN = Action("Unterboss Beschwören", summon = true)
val DUNKLER_FLUCH = Action("Dunkler Fluch", curse = true)
val DUNKLER_BARRIE1RE_SCHUTZ = Action("Dunkle Barriere protection", protection = true)

// Endgegner
val BLACKBEARD = Boss(
    "Marshall D. Teach",
    350,
    50,
    listOf(BESCHÄDIGUNG)
    //listOf(UNTERBOSS_BESCHWÖREN, DUNKLER_FLUCH,DUNKLER_BARRIE1RE_SCHUTZ,FEUERATEM,BESCHÄDIGUNG,SCHWARZESLOCH)
)

val ENEMIES = mutableListOf<Enemy>(BLACKBEARD)


fun main() {
    //playSound("src/main/kotlin/audio/One Piece.wav", shouldLoop = true, volumeLevel = 0.7f)
    val gumPistol: String = "src/main/kotlin/audio/gum gum pistol .wav"
    val GumGumBazooka: String = "src/main/kotlin/audio/Gum-Gum Bazooka.wav"
    val Haki: String = "src/main/kotlin/audio/Haki.wav"

    val Tatsumaki: String = "src/main/kotlin/audio/Tatsumaki.wav"
    val Onigiri: String = "src/main/kotlin/audio/Onigiri.wav"
    val Santoryu: String = "src/main/kotlin/audio/Santoryu.wav"

    val DonnerbolzenTempo: String = "src/main/kotlin/audio/Donnerbolzen Tempo.wav"
    val MirageTempo: String = "src/main/kotlin/audio/Mirage Tempo.wav"
    val Wetterzauber: String = "src/main/kotlin/audio/Wetterzauber.wav"

    println("____________________________________________________________________________")
    println("\u001B[33m\uD83C\uDF1F Willkommen bei Goldener Syntax! \uD83C\uDF1F\u001B[0m")
    println("\u001B[32mBitte beachte die folgenden Spielregeln:\u001B[0m")
    println("\u001B[36m1. Jeder Held darf pro Runde nur eine Aktion ausführen.\u001B[0m")
    println("\u001B[36m2. Der Rucksack enthält Items, die deine HP erhöhen oder andere Vorteile bringen.\u001B[0m")
    println("\u001B[36m3. Rücksack ist einmal verwendbare Aktionen können bis zum Ende der Runde nicht wieder gewählt werden.\u001B[0m")
    println("\u001B[36m4. Wähle deine Aktionen weise, um deine Feinde zu besiegen.\u001B[0m")
    println("________________________________________________________________________________________")
    println("information zum Helden aus One Piece Serie")
    println(
        "\u001B[34m1- Monkey D. Luffy\u001B[0m: der zukünftige König der Piraten. " +
                "Bekannt für seine Gummikräfte dank der Gum-Gum-Frucht und seinen unerschütterlichen Willen, sein Ziel zu erreichen."
    )
    println(
        "\u001B[32m2- Zoro\u001B[0m: der Schwertkämpfer mit drei Schwertern. " +
                "Ein Meister der Schwertkunst, der davon träumt, der größte Schwertkämpfer der Welt zu werden."
    )
    println(
        "\u001B[35m3- Nami\u001B[0m: die Navigatorin und Kartographin der Strohhutpiraten. " +
                "Mit einem außergewöhnlichen Sinn für Richtung und Wetter hilft sie dem Team, durch die gefährlichen Gewässer zu navigieren."
    )
    println("________________________________________________________________________________________")
    println("information zum Gegner aus One Piece Serie")
    println(
        "\u001B[31m1- Marshall D. Teach\u001B[0m, auch bekannt als Blackbeard, ein machthungriger Pirat, der nach der ultimativen Macht strebt. " +
                "Er ist gefürchtet für seine Dunkelheitskräfte, die er durch die Yami Yami no Mi erlangt hat."
    )
    println(
        "\u001B[33m2- Crocodile\u001B[0m, der ehemalige Shichibukai und Anführer von Baroque Works. " +
                "Seine Sandkräfte, die er von der Suna Suna no Mi hat, ermöglichen es ihm, sich in Sand zu verwandeln und Wüstenstürme zu erzeugen."
    )
    println("________________________________________________________________________________________")
    println("")


    //_____________________________________________________________________________________________
    // Funktion, die alle Charaktere zurückgibt, die noch am Leben sind (HP > 0).
    fun activeCharcters(characters: List<Character>): List<Character> {
        return characters.filter { it.hp > 0 }
    }

    fun showStatus(heroes: List<Character>, enemies: List<Character>) {
        // Status der Helden ausgeben
        println("\nInformation zu Helden ⚔️:")
        heroes.forEachIndexed { index, hero ->
            // Zeigt den Namen und die verbleibenden HP des Helden an
            println("${index + 1}- ${hero.name} hat \u001B[32m${hero.hp} HP\u001B[0m")
        }
        // Trennlinie zur besseren Übersicht
        println("────────────────────────────────────────────────────────────────")

        // Status der Gegner ausgeben
        println("\nInformation zu Gegnern ⚔️:")
        enemies.forEachIndexed { index, enemy ->
            // Zeigt den Namen und die verbleibenden HP des Gegners an
            println("${index + 1}- ${enemy.name} hat \u001B[32m${enemy.hp} HP\u001B[0m")
        }
        // Zusätzliche Leerzeile für die Übersicht
        println()
    }

    // Funktion zur Anzeige der verfügbaren Aktionen eines Charakters
    fun showAction(hero: Character) {
        // Gibt den Titel der Aktionenliste in blauer Schriftfarbe aus
        println("\u001B[34mVerfügbare Aktionen für ${hero.name}:\u001B[0m")
        // Listet alle Aktionen des Helden auf
        hero.actions.forEachIndexed { index, action ->
            println("${index + 1}. ${action.name}")
        }
        // Wenn der Charakter ein Held ist, wird die Option "Rucksack benutzen" als zusätzliche Aktion angezeigt
        if (hero is Hero) {
            println("${hero.actions.size + 1}. Rucksack benutzen")
        }
    }

    // Variable, um zu prüfen, ob in dieser Runde bereits ein Held den Rucksack verwendet hat
    var hasAnyHeroUsedBackpackThisRound = false

    // Funktion zum Abspielen von Soundeffekten für bestimmte Aktionen eines Helden
    fun playSoundForAction(hero: Character, action: Action) {
        // Zuordnung von Soundeffekten zu spezifischen Aktionen der Helden
        val soundEffect = when {
            hero.name == "Monkey D. Luffy" && action.name == "Gum-Gum Pistole" -> gumPistol
            hero.name == "Monkey D. Luffy" && action.name == "Gum-Gum Bazooka" -> GumGumBazooka
            hero.name == "Monkey D. Luffy" && action.name == "Haki" -> Haki
            hero.name == "Zoro" && action.name == "Tatsumaki" -> Tatsumaki
            hero.name == "Zoro" && action.name == "Onigiri" -> Onigiri
            hero.name == "Zoro" && action.name == "Santoryu" -> Santoryu
            hero.name == "Nami" && action.name == "Mirage Tempo" -> MirageTempo
            hero.name == "Nami" && action.name == "Donnerbolzen Tempo" -> DonnerbolzenTempo
            hero.name == "Nami" && action.name == "Wetterzauber" -> Wetterzauber
            // Wenn keine spezifische Zuordnung vorhanden ist, wird kein Soundeffekt abgespielt
            else -> null
        }
        // Spielt den Soundeffekt ab, wenn einer zugeordnet wurde
        soundEffect?.let { playSound(it) }
    }


    // Funktion, die die Logik für die Heldenaktionen in einer Kampfrunde abwickelt
    fun doActionForHero() {
        // Initialisierung der Liste der spielbaren Helden
        val heroesList = mutableListOf<Character>(LUFFY, ZORO, NAMI)
        // Schleife läuft so lange, bis alle Helden gehandelt haben
        while (heroesList.isNotEmpty()) {
            // Aufforderung an den Spieler, einen Helden für den nächsten Zug auszuwählen
            println("\u001B[34mWähle einen Helden für den Angriff aus:\u001B[0m")
            heroesList.forEachIndexed { index, hero ->
                println("${index + 1}. ${hero.name}")
            }

            // Einlesen der Heldenauswahl und Überprüfung auf gültige Eingabe
            val selectedIndex = readln().toIntOrNull() ?: continue // Schutz vor ungültigen Eingaben
            // Auswahl des Helden basierend auf dem Index, ignoriert ungültige Indizes
            val selectedHero = heroesList.getOrNull(selectedIndex - 1) ?: continue

            // Anzeige der verfügbaren Aktionen für den ausgewählten Helden
            showAction(selectedHero)

            // Einlesen der Aktion, die ausgeführt werden soll, und Überprüfung auf gültige Eingabe
            val auswahl = readln().toIntOrNull() ?: continue
            // Überprüfung, ob die Auswahl dem Einsatz des Rucksacks entspricht
            if (selectedHero is Hero && auswahl == selectedHero.actions.size + 1) {
                // Überprüfung, ob der Rucksack in dieser Runde noch verfügbar ist
                if (!hasAnyHeroUsedBackpackThisRound && !selectedHero.hasUsedBackpack) {
                    // Benutzung des Rucksacks und Aktualisierung der Statusvariablen
                    selectedHero.useBackpack(selectedHero)
                    selectedHero.hasUsedBackpack = true
                    hasAnyHeroUsedBackpackThisRound = true
                } else {
                    // Meldung, dass der Rucksack in dieser Runde nicht verwendet werden kann
                    println("${selectedHero.name} kann den Rucksack in dieser Runde nicht benutzen!")
                }
            } else {
                // Auswahl und Ausführung der Aktion, wenn es sich nicht um den Rucksack handelt
                val action = selectedHero.actions.getOrNull(auswahl - 1) ?: continue
                // Abspielen eines Soundeffekts, falls zugeordnet
                playSoundForAction(selectedHero, action)

                // Auswahl eines zufälligen aktiven Gegners als Ziel
                val target = activeCharcters(ENEMIES).shuffled().firstOrNull()
                // Ausführung der Aktion gegen das ausgewählte Ziel
                target?.let {
                    selectedHero.doActions(action, it)
                }
            }
            // Entfernung des Helden aus der Liste, da dieser bereits gehandelt hat
            heroesList.removeAt(selectedIndex - 1)
        }

        // Zurücksetzen des Indikators für die Rucksacknutzung am Ende der Runde
        heroesList.forEach { it.hasUsedBackpack = false }
    }


    fun createUnderboss(): Underboss {
        // Erstellen und zurückgeben des Unterbosses
        val sandBlast = Action(name = "Sand Blast", damage = 15, isAreaEffect = true)
        val quicksand = Action(name = "Quicksand", damage = 0, summon = true)
        val sandstorm = Action(name = "Sandstorm", damage = 20, isAreaEffect = true, speedUp = true)
        val desertSpada = Action(name = "Desert Spada", damage = 30, curse = true)
        return Underboss("Crokodil", 150, 10, listOf(sandBlast, quicksand, sandstorm, desertSpada))

    }

    // Verarbeitet die Aktionen der Gegner und wendet sie auf die Helden an.
    fun doActionForEnemies(heroes: List<Hero>) {
        val newEnemiesToAdd = mutableListOf<Enemy>()

        println("            ${blueColor}Beginne die Aktionen der Gegner.${resetColor}")

        // Geht alle Feinde durch und lässt sie ihre Aktionen ausführen.
        ENEMIES.forEach { enemy ->
            // Anzeigen von Informationen über den Feind.
            println("Der Gegner: ${redColor}${enemy.name}${resetColor} hat ${greenColor}${enemy.hp} HP${resetColor}.")
            // Feind handelt nur, wenn er noch am Leben ist.
            if (enemy.hp > 0)  {
                val action = enemy.actions.shuffled().first()
                println("${enemy.name} verwendet die Aktion ${redColor}${action.name}${resetColor}")

                // Je nach gewählter Aktion werden verschiedene Effekte auf die Helden angewendet.
                when (action.name) {
                    "Schwarzes Loch" -> {
                        val target =
                            heroes.filter { it.hp > 0 }.shuffled().first() // Einen zufälligen lebenden Helden auswählen
                        target.takeDamage(action.damage)
                        println("${target.name} erleidet durch ${action.name} Aktionen und seine verbleibende HP: ${greenColor}${target.hp} HP${resetColor}")
                    }

                    "schädigung" -> {
                        val target =
                            heroes.filter { it.hp > 0 }.shuffled().first() // Einen zufälligen lebenden Helden auswählen
                        val damage = action.damage // Hier nehmen Sie den Schaden aus der Action-Instanz
                        target.takeDamage(damage)
                        println("${target.name} erleidet durch ${action.name} Aktionen und seine verbleibende HP: ${greenColor}${target.hp} HP${resetColor}")
                    }

                    "Feueratem" -> {
                        val damage = action.damage // Hier nehmen Sie den Schaden aus der Action-Instanz
                        // Angenommen takeDamage gibt den tatsächlichen Schaden zurück
                        heroes.filter { it.hp > 0 }.forEach { hero ->
                            val damageTaken = hero.takeDamage(damage)
                            println("${hero.name} ${redColor}$damageTaken Schaden${resetColor}. Verbleibende HP: ${greenColor}${hero.hp} HP${resetColor}")
                        }
                    }

                    "Unterboss Beschwören" -> {
                        if (!hasSummonedUnderboss) {
                            println("${enemy.name} beschwört einen Unterboss!")
                            val underboss = createUnderboss()
                            newEnemiesToAdd.add(underboss)
                            hasSummonedUnderboss = true // Verhindern, dass mehr als ein Unterboss beschworen wird
                        }
                    }

                    "Dunkler Fluch" -> {
                        val target = heroes.filter { it.hp > 0 }.shuffled().first()
                        target.isCursed = true
                        println("${target.name} ist nun mit ${action.name} verflucht und wird in jeder Runde Schaden erleiden.")
                    }

                    "Dunkle Barriere protection" -> {
                        enemy.isProtected = true // Angenommen, die Boss-Klasse hat ein isProtected-Flag
                        println("${enemy.name} ist durch ${action.name} nun geschützt und wird weniger Schaden erleiden.")
                    }

                    "Sand Blast" -> {
                        // Angenommen, Sand Blast trifft alle Helden mit einem Flächenschaden
                        heroes.filter { it.hp > 0 }.forEach { hero ->
                            val damageTaken = hero.takeDamage(action.damage)
                            println("${enemy.name} trifft ${hero.name} mit ${action.name}, verursacht $damageTaken Schaden. Verbleibende HP: ${hero.hp} HP")
                        }
                    }

                    "Quicksand" -> {
                        // Quicksand könnte einen Helden verlangsamen oder handlungsunfähig machen
                        val target =
                            heroes.filter { it.hp > 0 }.shuffled().first() // Einen zufälligen lebenden Helden auswählen
                        target.isStunned = true // Angenommen, es gibt ein isStunned-Flag in der Hero-Klasse
                        println("${target.name} ist durch ${action.name} gelähmt und kann in der nächsten Runde nicht agieren.")
                    }

                    "Sandstorm" -> {
                        // Sandstorm könnte ähnlich wie Sand Blast Flächenschaden verursachen und vielleicht die Genauigkeit der Helden verringern
                        heroes.filter { it.hp > 0 }.forEach { hero ->
                            val damageTaken = hero.takeDamage(action.damage)
                            hero.isBlinded = true // Angenommen, es gibt ein isBlinded-Flag in der Hero-Klasse
                            println("${enemy.name} erzeugt einen ${action.name}, verursacht bei ${hero.name} $damageTaken Schaden und verringert die Genauigkeit.")
                        }
                    }

                    "Desert Spada" -> {
                        val target = heroes.filter { it.hp > 0 }.shuffled().first()
                        val damageTaken = target.takeDamage(action.damage)
                        target.isCursed = true // Angenommen, es gibt eine Eigenschaft isCursed in Ihrer Charakterklasse
                        println("${target.name} erleidet durch ${action.name} $damageTaken Schaden und ist nun verflucht.")
                    }

                    else -> {
                        println("Unbekannte Aktion: ${action.name}")
                    }
                }
            }
        }

        ENEMIES.addAll(newEnemiesToAdd)
    }


    // Wendet Fluchschaden auf die Helden an, falls sie verflucht sind.
    fun applyCurseDamage(heroes: List<Character>) {
        heroes.forEachIndexed { index, hero ->
            if (hero.isCursed) {
                val curseDamage = (hero.totalHp * 0.1).toInt()
                hero.hp -= curseDamage
                println("${index + 1}- ${hero.name} leidet unter dem Fluch und verliert $curseDamage HP.")
            }
        }
    }

    // Entfernt den Fluch von Helden, falls notwendig.
    fun removeCurseIfNecessary(heroes: List<Character>) {
        heroes.forEach { hero ->
            if (hero.isCursed && hero.hp <= hero.totalHp * 0.2) {
                hero.isCursed = false
                println("${hero.name} ist nun vom Fluch befreit.")
            }
        }
    }

    // Hauptspiel-Loop.
    while (activeCharcters(HEROES).isNotEmpty() && activeCharcters(ENEMIES).isNotEmpty()) {
        // Spielstatus und Aktionen der Charaktere in jeder Runde.
        println("____________________________________________________________________________")
        applyCurseDamage(HEROES)
        removeCurseIfNecessary(HEROES)
        showStatus(HEROES, ENEMIES)
        println("____________________________________________________________________________")
        doActionForHero()
        println("____________________________________________________________________________")
        doActionForEnemies(HEROES)
    }

// Bestimmt den Ausgang des Spiels basierend auf den verbleibenden Charakteren.
    if (activeCharcters(HEROES).isNotEmpty()) {
        println("Die Helden haben gewonnen!")
    } else {
        println("Die Gegner haben gewonnen!")
    }
}