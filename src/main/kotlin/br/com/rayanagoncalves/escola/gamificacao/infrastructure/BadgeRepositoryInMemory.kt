package br.com.rayanagoncalves.escola.gamificacao.infrastructure

import br.com.rayanagoncalves.escola.gamificacao.domain.badge.Badge
import br.com.rayanagoncalves.escola.gamificacao.domain.badge.BadgeRepository

class BadgeRepositoryInMemory(private val badges: MutableList<Badge>): BadgeRepository {

    override fun add(badge: Badge) {
        this.badges.add(badge)
    }

    override fun findAllBadges(documentNumber: String): List<Badge> {
        return this.badges
    }
}