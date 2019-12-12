package bpmn2.bonsaidemo.repository

import bpmn2.bonsaidemo.entity.Bonsai
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Transactional
@RepositoryRestResource(collectionResourceRel = "bonsai", path = "bonsai")
interface BonsaiRepository: PagingAndSortingRepository<Bonsai, UUID> {

    fun findByName(@Param("name") name: String): List<Bonsai>
}