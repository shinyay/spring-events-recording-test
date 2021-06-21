package com.google.shinyay

import com.google.shinyay.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.RecordApplicationEvents

@SpringBootTest
@RecordApplicationEvents
class UserServiceContextTest(
	@Autowired val applicationEvents: ApplicationEvents,
	@Autowired val userService: UserService) {

	@Test
	fun createUserShouldPublishEvents() {
	}

}
