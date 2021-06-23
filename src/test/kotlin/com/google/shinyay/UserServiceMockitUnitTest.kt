package com.google.shinyay

import com.google.shinyay.event.UserCreationEvent
import com.google.shinyay.service.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
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
    fun userCreationShouldPublishEvent() {
        val result = userService!!.createUser("duke")
        Mockito.verify(applicationEventPublisher)?.publishEvent(eventArgumentCaptor!!.capture())
        assertThat(eventArgumentCaptor?.value?.username).isEqualTo("Bob")
    }

//    @InjectMocks
//    private val userService: UserService? = null
//
//    @Mock
//    private val applicationEventPublisher: ApplicationEventPublisher? = null
//
//    @Captor
//    private val argumentCaptor: ArgumentCaptor<UserCreationEvent>? = null
//
//    @Test
//    fun userCreationArgumentShouldBeCorrect() {
//        val result = userService?.createUser("Alice")
//        argumentCaptor?.capture()?.let { Mockito.verify(applicationEventPublisher)?.publishEvent(it) }
//        Assertions.assertThat(argumentCaptor?.value?.username).isEqualTo("Bob")
//    }
}