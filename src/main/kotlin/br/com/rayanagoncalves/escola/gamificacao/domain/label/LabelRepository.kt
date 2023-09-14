package br.com.rayanagoncalves.escola.gamificacao.domain.label

interface LabelRepository {

    fun add(label: Label)

    fun findAllLabels(documentNumber: String): List<Label>
}