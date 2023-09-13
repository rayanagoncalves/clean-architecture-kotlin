package domain

import java.time.LocalDateTime

interface Event {

    fun moment(): LocalDateTime
}