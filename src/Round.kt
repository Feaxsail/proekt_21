class Round {
    var playerPoints = 0
    var dealerPoints = 0
    var result = ""

    fun play() {
        val deck = CardDeck()
        val player = Player(deck)
        val dealer = Dealer(deck)


        playerPoints = player.takeInitialCards()
        dealerPoints = dealer.takeInitialCards()

        println("Ваши карты: $playerPoints очков")
        println("Карта дилера: ${dealer.getFirstCard()} очков")


        playerPoints = player.playTurn(playerPoints)


        if (playerPoints <= 21) {
            dealerPoints = dealer.playTurn(dealerPoints)
        }


        result = determineWinner(playerPoints, dealerPoints)
        println("\n$result")
    }

    private fun determineWinner(ochkiIgroka: Int, ochkiDilera: Int): String {
        return when {
            ochkiIgroka > 21 -> " Вы проиграли! Перебор."
            ochkiDilera > 21 -> " Вы выиграли! У дилера перебор."
            ochkiIgroka > ochkiDilera -> " Вы выиграли! $ochkiIgroka против $ochkiDilera"
            ochkiIgroka < ochkiDilera -> " Вы проиграли! $ochkiIgroka против $ochkiDilera"
            else -> " Ничья! $ochkiIgroka против $ochkiDilera"
        }
    }
}