package com.example.data

import com.example.tools.enums.Country
import com.example.tools.enums.Genders
import java.util.*

data class Customer(
    var firstName : String,
    var lastName : String,
    var gender : Genders,
    var email : String,
    var dateOfBirths : Date,
    var company : String,
    var address : String,
    var country: Country,
    var state : String,
    var city : String,
    var zipcode : String,
    var mobileNumber : String)
{
    override fun toString(): String
    {
        return """
            Customer info
            first name: $firstName
            last name: $lastName
            gender: $gender
            email: $email
            date of birth: $dateOfBirths
            company: $company
            address: $address
            country: ${country.countryName}
            state: $state
            city: $city
            zipcode: $zipcode
            mobile phone: $mobileNumber
        """
    }
}