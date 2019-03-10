package com.example.tddexamples

import com.example.tddexamples.config.SwaggerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(SwaggerConfig::class)
@SpringBootApplication
class TddExamplesApplication

fun main(args: Array<String>) {
    runApplication<TddExamplesApplication>(*args)
}

