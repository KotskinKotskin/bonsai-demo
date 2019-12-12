package bpmn2.bonsaidemo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class BonsaiDemoApplication

fun main(args: Array<String>) {
	runApplication<BonsaiDemoApplication>(*args)
}
