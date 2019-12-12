package bpmn2.bonsaidemo.delegate

import bpmn2.bonsaidemo.entity.Bonsai
import bpmn2.bonsaidemo.service.BonsaiService
import mu.KotlinLogging
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.UUID


private val logger = KotlinLogging.logger {}

abstract class RootDelegate() : JavaDelegate {

    @Autowired
    lateinit var bonsaiService: BonsaiService


    fun getBonsai(execution: DelegateExecution): Bonsai? {
        logger.info { "get entity for ${logString(execution)}"}
        return bonsaiService.getBonsai(UUID.fromString(execution.businessKey))

    }

    fun saveBonsai(bonsai: Bonsai): Bonsai {
        return bonsaiService.saveBonsai(bonsai)
    }

    override fun execute(p0: DelegateExecution) {
        var returnBonsai = doExecute(p0, this.getBonsai(p0)).also { logger.info{ "execute for ${logString(p0)}"} }
        if (returnBonsai != null) {
            this.saveBonsai(returnBonsai).also { logger.info{ "save entity for ${logString(p0)}"} }
        }
    }
    abstract fun doExecute(execution: DelegateExecution, bonsai: Bonsai?): Bonsai?

    private fun logString(execution: DelegateExecution): String {
        return "processInstanceId=${execution.processInstanceId}, " +
            "activityName = ${execution.currentActivityName}, " +
            "activityId = ${execution.currentActivityId} " +
            "businessKey = ${execution.businessKey},  "
    }
}