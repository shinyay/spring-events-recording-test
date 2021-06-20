package com.google.shinyay.event

class UserRemovalEvent (val username: String, val id: Long){

    override fun toString(): String {
        return "UserRemovalEvent{ username=$username, id=$id }"
    }
}