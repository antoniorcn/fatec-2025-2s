package edu.curso.agenda.repository

import edu.curso.agenda.model.Medicao
import org.springframework.data.jpa.repository.JpaRepository

interface MedicaoRepository : JpaRepository<Medicao, Long> {
}