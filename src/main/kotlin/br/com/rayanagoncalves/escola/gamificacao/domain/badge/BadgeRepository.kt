package br.com.rayanagoncalves.escola.gamificacao.domain.badge

interface BadgeRepository {

    fun add(badge: Badge)

    fun findAllBadges(documentNumber: String): List<Badge>
}