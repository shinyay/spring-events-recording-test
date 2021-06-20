package com.google.shinyay.service

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service


@Service
class UserService(val eventPublisher: ApplicationEventPublisher) {

}