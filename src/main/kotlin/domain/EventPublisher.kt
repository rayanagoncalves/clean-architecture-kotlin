package domain

class EventPublisher(private val listeners: MutableList<Listener>) {

    fun add(listener: Listener) {
        this.listeners.add(listener)
    }

    fun publish(event: Event) {
        this.listeners.forEach { it.process(event) }
    }
}