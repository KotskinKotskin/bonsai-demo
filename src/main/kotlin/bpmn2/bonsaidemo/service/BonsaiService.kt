package bpmn2.bonsaidemo.service

import bpmn2.bonsaidemo.entity.Bonsai
import bpmn2.bonsaidemo.repository.BonsaiRepository
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.math.log

private val logger = KotlinLogging.logger {}

@Service
class BonsaiService(private val bonsaiRepository: BonsaiRepository) {

    fun getBonsai(id: UUID): Bonsai? {
        return  bonsaiRepository.findByIdOrNull(id).also { logger.info{"geted ${it}"} }
    }

    fun saveBonsai(bonsai: Bonsai): Bonsai {
        return  bonsaiRepository.save(bonsai).also {  logger.info{"saved ${it}"} }
    }
}