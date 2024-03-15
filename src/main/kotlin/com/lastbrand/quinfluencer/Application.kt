package com.lastbrand.quinfluencer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@ComponentScan("com.lastbrand")
class Application {

    val ALLOWED_IPS = arrayOf(
        "http://localhost:4200",
        "http://localhost:8000",
        "http://localhost:*",
        "http://vendor.lastbrand.com",
        "http://vendor.onequince.com",
        "https://vendor.lastbrand.com",
        "https://productcatalog.onequince.com",
        "https://vendor.onequince.com",
        "http://admin.lastbrand.com",
        "https://admin.lastbrand.com",
        "http://lastbrand.com",
        "http://onequince.com",
        "https://lastbrand.com",
        "https://onequince.com",
        "http://lastbrand.myshopify.com",
        "https://lastbrand.myshopify.com",
        "http://vendor-staging.lastbrand.com.s3-website.ap-south-1.amazonaws.com",
        "http://vendor-staging.onequince.com.s3-website.ap-south-1.amazonaws.com",
        "https://productcatalog-staging.onequince.com",
        "https://productcatalog-integ.onequince.com",
        "https://vendor-staging.onequince.com"
    )

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/influencer/**")
                    .allowedOrigins(*ALLOWED_IPS)
                    .allowedMethods("*")
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
