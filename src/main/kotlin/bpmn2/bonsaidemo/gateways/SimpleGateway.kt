package bpmn2.bonsaidemo.gateways

import bpmn2.bonsaidemo.entity.Bonsai
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component

@Component("simpleGateway")
class SimpleGateway: RootGatewayDecision() {

    override fun makeDecision(execution: DelegateExecution): Boolean {
        var bonsai =  this.getBonsai(execution)

        return bonsai?.height!!.compareTo(5.00) >0
    }

}