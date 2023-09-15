package br.com.rayanagoncalves.escola.gamificacao.domain.badge

import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber

data class Badge(
    val studentDocumentNumber: DocumentNumber,
    val name: String
)
