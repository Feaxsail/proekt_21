class Player(private val deck: CardDeck) {
    fun takeInitialCards(): Int {
        return deck.drawCard() + deck.drawCard()
    }

    fun playTurn(initialPoints: Int): Int {
        var ochki = initialPoints

        while (ochki <= 21) {
            print("Взять еще карту? (да/нет): ")
            val vibor = readLine()?.lowercase()

            if (vibor == "да") {
                val novayaKarta = deck.drawCard()
                ochki += novayaKarta
                println("Вы взяли карту: $novayaKarta очков")
                println("Всего очков: $ochki")

                if (ochki > 21) {
                    println("Перебор! У вас $ochki очков")
                    break
                }
            } else if (vibor == "нет") {
                println("Вы остановились на $ochki очках")
                break
            } else {
                println("Пожалуйста, введите 'да' или 'нет'")
            }
        }

        return ochki
    }
}