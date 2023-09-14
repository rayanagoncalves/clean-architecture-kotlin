package br.com.rayanagoncalves.escola.gamificacao.infrastructure

import br.com.rayanagoncalves.escola.gamificacao.domain.label.Label
import br.com.rayanagoncalves.escola.gamificacao.domain.label.LabelRepository

class LabelRepositoryInMemory(private val labels: MutableList<Label>): LabelRepository {

    override fun add(label: Label) {
        this.labels.add(label)
    }

    override fun findAllLabels(documentNumber: String): List<Label> {
        return this.labels
    }
}