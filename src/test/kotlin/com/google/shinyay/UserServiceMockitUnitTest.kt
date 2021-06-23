package com.google.shinyay

import com.google.shinyay.event.UserCreationEvent
import com.google.shinyay.service.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.ArgumentMatchers.any
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.context.ApplicationEventPublisher

@ExtendWith(MockitoExtension::class)
class UserServiceMockitUnitTest {

    @Mock
    private val applicationEventPublisher: ApplicationEventPublisher? = null

    @Captor
    private val eventArgumentCaptor: ArgumentCaptor<UserCreationEvent>? = null

    @InjectMocks
    private val userService: UserService? = null

    @Test
    fun createUserShouldPublishEvent() {
        val result = userService!!.createUser("Alice")
        Mockito.verify(applicationEventPublisher)?.publishEvent(eventArgumentCaptor!!.capture())
        assertThat(eventArgumentCaptor?.value?.username).isEqualTo("Alice")
    }

    @Test
    fun createMultipleUsersShouldPublishEvents() {
        val result = userService!!.createUser(listOf<String>("Alice", "Bob", "Carol"))
        Mockito
            .verify(applicationEventPublisher, Mockito.times(3))
            ?.publishEvent(any(UserCreationEvent::class.java))
    }
}