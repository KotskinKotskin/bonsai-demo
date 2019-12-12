package bpmn2.bonsaidemo.gateways

import bpmn2.bonsaidemo.entity.Bonsai
import bpmn2.bonsaidemo.service.BonsaiService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.runtime.Execution
import org.springframework.beans.factory.annotation.Autowired
import java.util.UUID


abstract class RootGatewayDecision() {

    @Autowired
    lateinit var bonsaiService: BonsaiService

    fun getBonsai(execution: DelegateExecution): Bonsai? {
        return bonsaiService.getBonsai(UUID.fromString(execution.businessKey))

    }

    fun saveBonsai(bonsai: Bonsai): Bonsai {
        return bonsaiService.saveBonsai(bonsai)
    }



abstract fun makeDecision(execution: DelegateExecution): Boolean

}

