package com.example.data

import com.github.javafaker.Faker

class TestData
{
    companion object
    {
        //Main URL of the Automation Exercise
        val url: String = "https://www.automationexercise.com"

        var emal : String = TestData().generateEmail()
    }

    fun generateEmail() : String
    {
        return Faker().internet().emailAddress()
    }
}