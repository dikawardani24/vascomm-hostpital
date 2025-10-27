package dika.vasscom.core.validator

import android.util.Log

class NameValidator(
    private val name: String?
): Validator<NameValidator.Cause> {
    enum class Cause {
        EMPTY,
        NONE,
        INVALID
    }

    private fun isPatternValid(name: String): Boolean {
        return "^[a-zA-Z\\s\\-'.]*$".toRegex()
            .matches(name)
    }

    private fun getResult(): ValidateResult<Cause> {
        val value = name
        if (value == null) return ValidateResult(Cause.EMPTY)
        if (value.isEmpty()) return ValidateResult(Cause.EMPTY)
        if (!isPatternValid(value)) return ValidateResult(Cause.INVALID)
        return ValidateResult(Cause.NONE)
    }

    override fun validate(): ValidateResult<Cause> {
        val result = getResult()
        Log.d("NameValidator", "validate: $result")
        return result
    }
}