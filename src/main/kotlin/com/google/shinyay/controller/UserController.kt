package com.google.shinyay.controller

import com.google.shinyay.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class UserController(val userService: UserService) {

    @PostMapping("/users")
    fun createNewUser(@RequestBody userName: String): ResponseEntity<Long> {
        val id = userService.createUser(userName)
        return ResponseEntity.status(HttpStatus.CREATED).body(id)
    }
}