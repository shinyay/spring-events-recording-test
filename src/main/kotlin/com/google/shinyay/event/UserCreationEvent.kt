package com.google.shinyay.event

import org.springframework.context.ApplicationEvent

class UserCreationEvent(source: Any?, val username: String, val id: Long) : ApplicationEvent(source!!) {

    override fun toString(): String {
        return "UserCreationEvent{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", timestamp=" + super.getTimestamp() +
                '}'
    }
}