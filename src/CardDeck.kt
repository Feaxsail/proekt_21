import kotlin.random.Random

class CardDeck {
    fun drawCard(): Int {
        return Random.nextInt(2, 11) // Карты от 2 до 10
    }
}