package sample.papamangto.android.tdd.login

import java.util.regex.Pattern

class Validator {
    companion object {
        fun isValidEmail(inputEmail: String): Boolean {
            val patternString = "^[A-Z0-9a-z\\._%+-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$"
            val pattern = Pattern.compile(patternString)
            val matcher = pattern.matcher(inputEmail)
            return matcher.matches()
        }

        fun isValidPassword(inputPassword: String): Boolean {
            val patternString = "^[A-Z0-9a-z\\._%+-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}\$"
            val pattern = Pattern.compile(patternString)
            val matcher = pattern.matcher(inputPassword)
            return matcher.matches()
        }
    }
}