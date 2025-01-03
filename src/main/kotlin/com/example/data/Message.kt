package com.example.data

import java.io.File

data class Message(
    var name : String,
    var email : String,
    var subject : String,
    var message : String,
    var file : File)
{
    override fun toString(): String
    {
        return """
            Message
            name: $name
            email: $email
            subject: $subject
            message: $message
            file: $file
        """
    }
}