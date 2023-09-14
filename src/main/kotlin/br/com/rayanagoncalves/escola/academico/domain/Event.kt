package br.com.rayanagoncalves.escola.academico.domain

import java.time.LocalDateTime

interface Event {

    fun moment(): LocalDateTime
}