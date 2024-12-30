package com.example.data

import com.example.tools.enums.Country
import com.example.tools.enums.Genders
import com.github.javafaker.Faker
import java.io.File

class TestData
{
    companion object
    {
        //Main URL of the Automation Exercise
        val url: String = "https://www.automationexercise.com"

        val customer : Customer = Customer(
            Faker().name().firstName(),
            Faker().name().lastName(),
            Genders.FEMALE,
            Faker().internet().emailAddress(),
            Faker().date().birthday(26, 77),
            Faker().company().name(),
            Faker().address().streetAddress(),
            Country.Canada,
            Faker().address().state(),
            Faker().address().city(),
            Faker().address().zipCode(),
            Faker().phoneNumber().phoneNumber()
        )

        var message : Message = Message(
            Faker().name().firstName(),
            Faker().internet().emailAddress(),
            Faker().harryPotter().spell(),
            Faker().harryPotter().quote(),
            createFile()
        )

        var email : String = "1478@gmail.com"
        var password : String = "11111111"
    }
}

fun createFile() : File
{
    var file = File("C:\\Users\\Quantaria\\Desktop\\file.txt")
    file.writeText(Faker().harryPotter().quote())
    return file
}