package edu.curso.agenda.repository

import edu.curso.agenda.model.Medicao
import org.springframework.data.jpa.repository.JpaRepository

interface MedicaoRepositoryDB : JpaRepository<Medicao, Long> {

}