package bpmn2.bonsaidemo.repository.listners

import bpmn2.bonsaidemo.entity.Bonsai
import bpmn2.bonsaidemo.service.CamundaService
import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.HandleAfterDelete
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.HandleBeforeDelete
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Component
@RepositoryEventHandler(Bonsai::class)
class BonsaiEventHandler(private val camundaService: CamundaService) {

    var logger: Logger = Logger.getLogger("Class Bonsai")

    @HandleBeforeCreate
    fun handleAuthorBeforeCreate(bonsai: Bonsai) {



    }

    @HandleAfterCreate
    fun handleAuthorAfterCreate(bonsai: Bonsai) {
        camundaService.startProcess(bonsai)

    }

    @HandleBeforeDelete
    fun handleAuthorBeforeDelete(bonsai: Bonsai) {


    }



    @HandleAfterDelete
    fun handleAuthorAfterDelete(bonsai: Bonsai) {


    }
}