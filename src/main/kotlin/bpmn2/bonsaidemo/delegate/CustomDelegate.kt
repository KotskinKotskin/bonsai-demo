package bpmn2.bonsaidemo.delegate

import bpmn2.bonsaidemo.entity.Bonsai
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.stereotype.Component


@Component("customDelegate")
class CustomDelegate: RootDelegate() {
    override fun doExecute(execution: DelegateExecution, bonsai: Bonsai?): Bonsai? {

        bonsai?.description = "modifyByDelegate"


        return bonsai

    }


}