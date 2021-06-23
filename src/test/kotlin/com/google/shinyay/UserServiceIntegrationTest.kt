package com.google.shinyay

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceIntegrationTest(@Autowired val testRestTemplate: TestRestTemplate) {

    @Test
    fun createUserShouldReturnCreated() {
        val result = testRestTemplate.postForEntity("/api/v1/users", "Alice", Long::class.java)
        assertThat(result.statusCodeValue).isEqualTo(201)
    }
}