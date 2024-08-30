import network.RocketComponent

class Greeting {
    private val platform = getPlatform()

    private val rocketComponent = RocketComponent()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}