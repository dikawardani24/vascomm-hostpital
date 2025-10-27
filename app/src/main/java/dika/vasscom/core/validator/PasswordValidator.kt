package dika.vasscom.core.validator

import android.util.Log

class PasswordValidator(
    private val password: String?,
    private val minLength: Int = 6,
    private val maxLength: Int = 10
): Validator<PasswordValidator.Cause> {
    enum class Cause {
        NONE,
        EMPTY,
        TOO_SHORT,
        TOO_LONG,
    }

    private fun getResult(): ValidateResult<Cause> {
        val value = password
        if (value == null || value.isEmpty())  return ValidateResult(Cause.EMPTY)
        if (value.length < minLength) return ValidateResult(Cause.TOO_SHORT)
        if (value.length > maxLength) return ValidateResult(Cause.TOO_LONG)
        return ValidateResult(Cause.NONE)
    }

    override fun validate(): ValidateResult<Cause> {
        val result = getResult()
        Log.d("PasswordValidator", "validate: $result")
        return result
    }
}