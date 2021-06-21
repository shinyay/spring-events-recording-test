package com.google.shinyay

import com.google.shinyay.event.UserCreationEvent
import com.google.shinyay.service.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.RecordApplicationEvents


@SpringBootTest
@RecordApplicationEvents
class UserServiceContextTest() {
	@Autowired
	private val applicationEvents: ApplicationEvents? = null

	@Autowired
	private val userService: UserService? = null

	@Test
	fun createUserShouldPublishEvents() {



		this.userService?.createUser("Alice")

		assertEquals(1, applicationEvents
			?.stream(UserCreationEvent::class.java)
			?.filter { event: UserCreationEvent -> event.username == "Alice" }
			?.count())
		applicationEvents?.stream()?.forEach(System.out::println)
	}

}
