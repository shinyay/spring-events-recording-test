# Getting Start with Spring Events
Spring application events allow us to throw and listen to specific application events that we can process as we wish.

Events are meant for exchanging information between loosely coupled components.

Event handling in the `ApplicationContext` is provided through the `ApplicationEvent` class and the `ApplicationListener` interface.
- [Standard and Custom Events](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-functionality-events)

There are a few simple guidelines to follow:
- the event should extend `ApplicationEvent`
- the publisher should inject an `ApplicationEventPublisher` object
- the listener should implement the `ApplicationListener` interface
## Description
### Creating an ApplicationEvent
Our `Spring Event` extends `ApplicationEvent`

```kotlin
class UserCreationEvent(source: Any?, val username: String, val id: Long) : ApplicationEvent(source!!)
```

The `source` which is being passed to Super Class ,`ApplicationEvent`, should be the object on which the event occurred initially or an object with which the event is associated.

### Publishing an ApplicationEvent
We use the `ApplicationEventPublisher` interface to publish our events

```kotlin
@Service
class UserService(val eventPublisher: ApplicationEventPublisher) {
    fun createUser(userName: String) {
        this.eventPublisher.publishEvent(UserCreationEvent(this, userName))
    }
}
```

### Listening to an Application Event
We can use the `@EventListener` annotation to listen ApplicationEvent.

```kotlin
@EventListener(UserCreationEvent::class)
fun reportUserCreation(event: UserCreationEvent) {
    logger.info("New User Created: $event")
}
```

`@EventListener` automatically registers an ApplicationListener.
If you want to specify the specific event, you can put the class on the annotation:
```kotlin
@EventListener(UserCreationEvent::class)
```

### Verifying Application Events
- [Application Events](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-application-events)

To use ApplicationEvents in your tests, do the following:

- The test class should be annotated with `@RecordApplicationEvents`

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
