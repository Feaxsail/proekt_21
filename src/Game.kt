class Game {
    private var ochkiIgroka = 0
    private var ochkiDilera = 0
    private var sigrannoIgr = 0
    private var pobedIgroka = 0

    fun start() {
        while (true) {
            sigrannoIgr++
            println("\n--- Игра $sigrannoIgr ---")

            val round = Round()
            round.play()


            if (round.result.contains("Вы выиграли")) pobedIgroka++

            ochkiIgroka += if (round.playerPoints <= 21) round.playerPoints else 0
            ochkiDilera += if (round.dealerPoints <= 21) round.dealerPoints else 0

            printStatistics()


            print("\nХотите сыграть еще раз? (да/нет): ")
            if (readLine()?.lowercase() != "да") {
                println("\nСпасибо за игру! Итоговый счет: $pobedIgroka побед из $sigrannoIgr")
                break
            }
        }
    }

    private fun printStatistics() {
        println("\nСтатистика:")
        println("Побед: $pobedIgroka из $sigrannoIgr")
        println("Общий счет: Вы $ochkiIgroka - $ochkiDilera Дилер")
    }
}