import kotlin.random.Random

val RANDOM = Random
val GUM_GUM_PISTOLE = Action("Gum-Gum Pistole", damage = RANDOM.nextInt(150, 300))
val GUM_GUM_BAZOOKA = Action("Gum-Gum Bazooka", damage = RANDOM.nextInt(60, 100))
val SCHUTZZAUBER_LUFFY = Action("Haki", damage = RANDOM.nextInt(60, 100))
val HEILZAUBER_LUFFY = Action("Fleisch Erholung", healing = RANDOM.nextInt(50, 100))

val LUFFY = Hero(
    "Monkey D. Luffy",
    200,
    30,
    listOf(GUM_GUM_PISTOLE, GUM_GUM_BAZOOKA, HEILZAUBER_LUFFY, SCHUTZZAUBER_LUFFY))

val TATSUMAKI = Action("Tatsumaki", damage = RANDOM.nextInt(50, 90))
val ONIGIRI = Action("Onigiri", damage = RANDOM.nextInt(60, 90))
val SCHUTZZAUBER_ZORO = Action("Santoryu", damage = RANDOM.nextInt(50, 100))
val HEILZAUBER_ZORO = Action("Erholung", healing = RANDOM.nextInt(50, 100))

val ZORO = Hero(
    "Zoro",
    200,
    30,
    listOf(ONIGIRI, TATSUMAKI, HEILZAUBER_ZORO, SCHUTZZAUBER_ZORO))

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
val BEFREIFUNG = Action("Befreiung", damage = RANDOM.nextInt(70, 200))
val FEUERATEM = Action("Feueratem", damage = RANDOM.nextInt(60, 200), isAreaEffect = true)
val UNTERBOSS_BESCHWÖREN = Action("Unterboss Beschwören", summon = true)
val DUNKLER_FLUCH = Action("Dunkler Fluch", curse = true)
val DUNKLER_BARRIERE_SCHUTZ = Action("Dunkle Barriere", protection = true)

// Endgegner
val BLACKBEARD = Boss(
    "Marshall D. Teach",
    350,
    50,
    listOf(UNTERBOSS_BESCHWÖREN, DUNKLER_FLUCH,DUNKLER_BARRIERE_SCHUTZ,FEUERATEM,BEFREIFUNG,SCHWARZESLOCH)
)

val ENEMIES = mutableListOf<Enemy>(BLACKBEARD)
val mutableEnemies: MutableList<Enemy> = ENEMIES.toMutableList()



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
    println("\u001B[34m1- Monkey D. Luffy\u001B[0m: der zukünftige König der Piraten. " +
            "Bekannt für seine Gummikräfte dank der Gum-Gum-Frucht und seinen unerschütterlichen Willen, sein Ziel zu erreichen.")
    println("\u001B[32m2- Zoro\u001B[0m: der Schwertkämpfer mit drei Schwertern. " +
            "Ein Meister der Schwertkunst, der davon träumt, der größte Schwertkämpfer der Welt zu werden.")
    println("\u001B[35m3- Nami\u001B[0m: die Navigatorin und Kartographin der Strohhutpiraten. " +
            "Mit einem außergewöhnlichen Sinn für Richtung und Wetter hilft sie dem Team, durch die gefährlichen Gewässer zu navigieren.")
    println("________________________________________________________________________________________")
    println("information zum Gegner aus One Piece Serie")
    println("\u001B[31m1- Marshall D. Teach\u001B[0m, auch bekannt als Blackbeard, ein machthungriger Pirat, der nach der ultimativen Macht strebt. " +
            "Er ist gefürchtet für seine Dunkelheitskräfte, die er durch die Yami Yami no Mi erlangt hat.")
    println("\u001B[33m2- Crocodile\u001B[0m, der ehemalige Shichibukai und Anführer von Baroque Works. " +
            "Seine Sandkräfte, die er von der Suna Suna no Mi hat, ermöglichen es ihm, sich in Sand zu verwandeln und Wüstenstürme zu erzeugen.")
    println("________________________________________________________________________________________")
    println("")
    fun activeCharcters(characters: List<Character>): List<Character> {
        return characters.filter { it.hp > 0 }
    }
    fun showStatus(heroes: List<Character>, enemies: List<Character>) {
        println("\nInformation zu Helden ⚔️:")
        heroes.forEachIndexed { index, hero ->
            println("${index + 1}- ${hero.name} hat \u001B[32m${hero.hp} HP\u001B[0m")
        }
        println("────────────────────────────────────────────────────────────────")
        println("\nInformation zu Gegnern ⚔️:")
        enemies.forEachIndexed { index, enemy ->
            println("${index + 1}- ${enemy.name} hat \u001B[32m${enemy.hp} HP\u001B[0m")
        }
        println()
    }

    fun showAction(hero: Character) {
        println("\u001B[34mVerfügbare Aktionen für ${hero.name}:\u001B[0m")
        hero.actions.forEachIndexed { index, action ->
            println("${index + 1}. ${action.name}")
        }
        // Plus eins für den Rucksack als mögliche Aktion
        if (hero is Hero) {
            println("${hero.actions.size + 1}. Rucksack benutzen")
        }
    }
    var hasAnyHeroUsedBackpackThisRound = false

    fun doActionForHero() {

        val heroesList = mutableListOf<Character>(LUFFY, ZORO, NAMI)
        while (heroesList.isNotEmpty()) {
            println("\u001B[34mWähle einen Helden für den Angriff aus:\u001B[0m")
            heroesList.forEachIndexed { index, hero ->
                println("${index + 1}. ${hero.name}")
            }

            val selectedIndex = readln().toInt()
            val selectedHero = heroesList.getOrElse(selectedIndex - 1) { heroesList.first() }

            showAction(selectedHero)


            val auswahl = readln().toInt()
            if (selectedHero is Hero && auswahl == selectedHero.actions.size + 1) {
                if  (!hasAnyHeroUsedBackpackThisRound && !selectedHero.hasUsedBackpack) {
                    selectedHero.useBackpack(selectedHero)
                    selectedHero.hasUsedBackpack = true // Setze den Indikator, dass der Rucksack benutzt wurde
                    hasAnyHeroUsedBackpackThisRound = true // Setze den globalen Indikator, dass der Rucksack benutzt wurde
                } else {
                    if (selectedHero.hasUsedBackpack)
                        println("${selectedHero.name} hat in dieser Runde bereits den Rucksack benutzt!")
                    else
                        println("Ein anderer Held hat in dieser Runde bereits den Rucksack benutzt!")
                }

            } else {
                    val action = selectedHero.actions.getOrElse(auswahl - 1) { selectedHero.actions.first() }
                    if (selectedHero.name == "Monkey D. Luffy" && action.name == "Gum-Gum Pistole") {
                        playSound(gumPistol) // Spielen Sie den Soundeffekt hier ab
                    }
                    else
                        if (selectedHero.name == "Monkey D. Luffy" && action.name == "Gum-Gum Bazooka") {
                            playSound(GumGumBazooka) // Spielen Sie den Soundeffekt hier ab
                        }
                        else
                            if (selectedHero.name == "Monkey D. Luffy" && action.name == "Haki") {
                                playSound(Haki) // Spielen Sie den Soundeffekt hier ab
                            }
                else
                    if (selectedHero.name == "Zoro" && action.name == "Tatsumaki") {
                    playSound(Tatsumaki) // Spielen Sie den Soundeffekt hier ab
                }
                else
                    if (selectedHero.name == "Zoro" && action.name == "Onigiri") {
                        playSound(Onigiri) // Spielen Sie den Soundeffekt hier ab
                    }
                    else
                        if (selectedHero.name == "Zoro" && action.name == "Santoryu") {
                            playSound(Santoryu) // Spielen Sie den Soundeffekt hier ab
                        }
                        else
                            if (selectedHero.name == "Nami" && action.name == "Mirage Tempo") {
                                playSound(MirageTempo) // Spielen Sie den Soundeffekt hier ab
                            }
                            else
                                if (selectedHero.name == "Nami" && action.name == "Donnerbolzen Tempo") {
                                    playSound(DonnerbolzenTempo) // Spielen Sie den Soundeffekt hier ab
                                }
                                else
                                    if (selectedHero.name == "Nami" && action.name == "Wetterzauber") {
                                        playSound(Wetterzauber) // Spielen Sie den Soundeffekt hier ab
                                    }
                val ziel = activeCharcters(mutableEnemies).shuffled().firstOrNull()
                ziel?.let {
                    selectedHero.doActions(action, it)
                }
            }
            // Nachdem der Angriff durchgeführt wurde, den ausgewählten Charakter aus der Liste entfernen
            heroesList.removeAt(selectedIndex - 1)
        }

        // Setze den Indikator zurück, dass der Rucksack benutzt wurde
        listOf(LUFFY, ZORO, NAMI).forEach { hero ->
            if (true) {
                hero.hasUsedBackpack = false
            }
        }

    }
    fun doActionForEnemies(heroes: List<Hero>) {
        val newEnemiesToAdd = mutableListOf<Enemy>()

        println("Beginne die Aktionen der Gegner.")
        var underBossCret = false

        ENEMIES.forEach { enemy ->
            println("Aktuelle stand der Gegner: ${enemy.name} mit ${enemy.hp} HP")
            if (enemy.hp > 0) {
                val action = enemy.actions.shuffled().first()
                println("Die Gewählte Aktion von ${enemy.name} ist: ${action.name}")

                when {
                    action.summon -> {
                        // Beschwören eines Unterbosses
                        println("${enemy.name} beschwört einen Unterboss!")

                        if (!hasSummonedUnderboss) {
                            underBossCret = true
                            hasSummonedUnderboss = true
                            println("Ein Unterboss wurde auf das Schlachtfeld gerufen!")
                        }
                    }

                    action.isAreaEffect -> {
                        // Aktionen mit Flächeneffekt
                        heroes.filter { it.hp > 0 }.forEach { hero ->
                            hero.takeDamage(action.damage)
                            println("${hero.name} erleidet ${action.damage} Schadenspunkte durch ${action.name}.")
                        }
                    }

                    action.curse -> {
                        // Verfluchte Aktionen
                        val target = heroes.filter { it.hp > 0 }.shuffled().first()
                        target.isCursed = true
                        println("${target.name} ist jetzt von ${action.name} verflucht!")
                    }
                }
            }

        }
if (underBossCret){
    val sandBlast = Action(name = "Sand Blast", damage = 15, isAreaEffect = true)
    val quicksand = Action(name = "Quicksand", damage = 0, summon = true)
    val sandstorm = Action(name = "Sandstorm", damage = 20, isAreaEffect = true, speedUp = true)
    val desertSpada = Action(name = "Desert Spada", damage = 30, curse = true)
    val underboss = Underboss("Crokodil", 150, 10, listOf(sandBlast, quicksand, sandstorm, desertSpada))
    ENEMIES.add(underboss) // Füge den Unterboss zur temporären Liste hinzu
}
        // Nachdem alle Gegner durchlaufen wurden, füge alle neuen Gegner zur Hauptliste hinzu
        newEnemiesToAdd.addAll(newEnemiesToAdd)
    }

    fun applyCurseDamage(heroes: List<Character>) {
        heroes.forEach { hero ->
            if (hero.isCursed) {
                val curseDamage = hero.totalHp * 0.1
                hero.hp -= curseDamage.toInt()
                println("${hero.name} leidet unter dem Fluch und verliert ${curseDamage.toInt()} HP.")
            }
        }
    }
     fun removeCurseIfNecessary(heroes: List<Character>) {
        heroes.forEach { hero ->
            if (hero.isCursed && hero.hp <= hero.hp * 0.2) {
                hero.isCursed = false
                println("${hero.name} ist nun vom Fluch befreit.")
            }
        }
    }
    while (activeCharcters(HEROES).isNotEmpty() && activeCharcters(ENEMIES).isNotEmpty()) {
        println("____________________________________________________________________________")
        applyCurseDamage(HEROES)
        removeCurseIfNecessary(HEROES)
        showStatus(HEROES,ENEMIES)
        println("____________________________________________________________________________")
        doActionForHero()
        println("____________________________________________________________________________")
        doActionForEnemies(HEROES)
    }
    if (activeCharcters(HEROES).isNotEmpty()) {
        println("Die Helden haben gewonnen!")
    } else {
        println("Die Gegner haben gewonnen!")
    }
}