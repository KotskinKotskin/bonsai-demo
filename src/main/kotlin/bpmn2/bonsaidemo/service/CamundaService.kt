package bpmn2.bonsaidemo.service

import bpmn2.bonsaidemo.entity.Bonsai
import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Service


@Service
class CamundaService( private val runtimeService: RuntimeService) {

    fun startProcess(bonsai: Bonsai) {

        runtimeService.startProcessInstanceByKey("TestProcess", bonsai.id.toString())
    }
}