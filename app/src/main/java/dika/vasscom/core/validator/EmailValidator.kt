package dika.vasscom.core.validator

import android.util.Log


class EmailValidator(
    private val email: String?
): Validator<EmailValidator.Cause> {
    enum class Cause {
        EMPTY,
        INVALID,
        NONE
    }

    private fun isPatternValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(emailRegex.toRegex())
    }

    private fun getResult(): ValidateResult<Cause> {
        val value = email
        if (value == null || value.isEmpty()) {
            return ValidateResult(Cause.EMPTY)
        }

        val isValid = isPatternValid(value)
        if (!isValid) {
            return ValidateResult(Cause.INVALID)
        }
        return ValidateResult(Cause.NONE)
    }

    override fun validate(): ValidateResult<Cause> {
        val result = getResult()
        Log.d("EmailValidator", "validate: $result")
        return result
    }

}