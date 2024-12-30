package com.example.data

import java.io.File

data class Message(
    var name : String,
    var email : String,
    var subject : String,
    var message : String,
    var file : File)