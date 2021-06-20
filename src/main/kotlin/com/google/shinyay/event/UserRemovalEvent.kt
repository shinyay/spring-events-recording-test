package com.google.shinyay.event

class UserRemovalEvent (val username: String){

    override fun toString(): String {
        return "UserRemovalEvent{ username=$username }"
    }
}