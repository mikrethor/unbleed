package com.ablx.unbleed.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
internal class TestController{



    //Name can't contain .
    @GetMapping("/hello/{name:.+}")
    fun hello(@PathVariable(value="name")name: String) =
            "Hello ${name}"



}