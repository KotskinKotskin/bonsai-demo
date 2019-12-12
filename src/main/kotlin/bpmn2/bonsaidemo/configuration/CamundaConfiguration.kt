package bpmn2.bonsaidemo.configuration

import org.camunda.bpm.engine.impl.cfg.IdGenerator
import org.camunda.bpm.engine.impl.history.HistoryLevel
import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.annotation.Resource
import javax.sql.DataSource


@Configuration
@EnableProcessApplication
class CamundaConfiguration {


    @Bean
    fun idGenerator(): IdGenerator = StrongUuidGenerator()

    @Autowired
    var dataSource: DataSource? = null

    @Resource
    private val transactionManager: PlatformTransactionManager? = null

    @Bean
    fun processEngineConfiguration(
        idGenerator: IdGenerator
    ): SpringProcessEngineConfiguration = SpringProcessEngineConfiguration().also {
        it.dataSource = dataSource
        it.transactionManager = transactionManager
        it.databaseSchemaUpdate = "true"
        it.isTransactionsExternallyManaged = true
        it.isJobExecutorActivate = true
        it.idGenerator = idGenerator
        it.historyLevel = HistoryLevel.HISTORY_LEVEL_FULL

    }

    @Bean
    fun processEngine(
        processEngineConfiguration: SpringProcessEngineConfiguration
    ): ProcessEngineFactoryBean = ProcessEngineFactoryBean().also {
        it.processEngineConfiguration = processEngineConfiguration
    }

    @Bean
    fun processCorsFilter(): FilterRegistrationBean<CorsFilter> {
        val corsConfig = UrlBasedCorsConfigurationSource().also { source ->
            source.registerCorsConfiguration("/**", CorsConfiguration().also { config ->
                config.allowCredentials = true
                config.addAllowedOrigin("*")
                config.addAllowedHeader("*")
                config.addAllowedMethod("*")
            })
        }
        return FilterRegistrationBean(CorsFilter(corsConfig)).also { it.order = 0 }
    }
}