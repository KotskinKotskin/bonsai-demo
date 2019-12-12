package bpmn2.bonsaidemo.configuration

import bpmn2.bonsaidemo.repository.BonsaiRepository
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = arrayOf(BonsaiRepository::class))
@EnableJpaAuditing
class PersistenceConfig  {}