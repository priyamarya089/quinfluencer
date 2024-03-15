package com.lastbrand.orderservice.configuration

import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class TransactionManagementConfigurer {

    @Bean
    fun annotationDrivenTransactionManager(dataSource: DataSource) = SpringTransactionManager(dataSource)

}