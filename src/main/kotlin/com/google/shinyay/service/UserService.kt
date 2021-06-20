package com.google.shinyay.service

import com.google.shinyay.event.UserCreationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.util.concurrent.ThreadLocalRandom


@Service
class UserService(val eventPublisher: ApplicationEventPublisher) {

    fun createUser(userName: String): Long {
        val primaryKey = ThreadLocalRandom.current().nextLong(1, 1000)
        this.eventPublisher.publishEvent(UserCreationEvent(this, userName, primaryKey))
        return primaryKey
    }

    fun createUser(userNames: List<String>): List<Long> {
        val ids: MutableList<Long> = arrayListOf()

        for (username in userNames) {
            ids.add(createUser(username!!))
        }
        return ids
    }
}