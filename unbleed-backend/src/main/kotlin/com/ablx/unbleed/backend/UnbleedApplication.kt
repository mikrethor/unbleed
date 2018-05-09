package com.ablx.unbleed.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class UnbleedApplication

fun main(args: Array<String>) {
    SpringApplication.run(UnbleedApplication::class.java, *args)
}
