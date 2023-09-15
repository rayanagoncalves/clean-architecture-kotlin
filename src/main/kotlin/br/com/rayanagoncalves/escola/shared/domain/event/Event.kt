package br.com.rayanagoncalves.escola.shared.domain.event

import java.time.LocalDateTime

interface Event {

    fun moment(): LocalDateTime
    fun type(): EventType
    fun information(): Map<String, Any>
}