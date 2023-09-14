package br.com.rayanagoncalves.escola.academico.domain

abstract class Listener {

    fun process(event: Event) {
        if(canProcess(event)) {
            this.listen(event)
        }
    }

    abstract fun listen(event: Event)

    abstract fun canProcess(event: Event): Boolean
}