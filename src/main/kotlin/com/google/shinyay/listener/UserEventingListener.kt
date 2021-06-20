package com.google.shinyay.listener

import com.google.shinyay.event.UserCreationEvent
import com.google.shinyay.logger
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UserEventingListener {

    @EventListener(UserCreationEvent::class)
    fun reportUserCreation(event: UserCreationEvent) {
        logger.info("New User Created: $event")
    }
}