class Dealer(private val deck: CardDeck) {
    private var firstCard = 0

    fun takeInitialCards(): Int {
        firstCard = deck.drawCard()
        return firstCard + deck.drawCard()
    }

    fun getFirstCard(): Int {
        return firstCard
    }

    fun playTurn(initialPoints: Int): Int {
        var ochki = initialPoints
        println("\nХод дилера...")
        println("У дилера: $ochki очков")


        while (ochki < 17) {
            val novayaKarta = deck.drawCard()
            ochki += novayaKarta
            println("Дилер взял карту: $novayaKarta очков")
            println("У дилера: $ochki очков")

            if (ochki > 21) {
                println("У дилера перебор!")
                break
            }
        }

        return ochki
    }
}