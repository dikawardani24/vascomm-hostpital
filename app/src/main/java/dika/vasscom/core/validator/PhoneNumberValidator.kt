package dika.vasscom.core.validator

import android.util.Log
import android.util.Patterns

class PhoneNumberValidator(
    private val phoneNumber: String?
): Validator<PhoneNumberValidator.Cause> {
    enum class Cause {
        INVALID,
        EMPTY,
        NONE
    }

    private fun isPatternValid(phone: String): Boolean = Patterns.PHONE.matcher(phone)
        .matches()

    private fun getResult(): ValidateResult<Cause> {
        val phone = phoneNumber
        if (phone == null || phone.isEmpty()) return ValidateResult(Cause.EMPTY)
        if (!isPatternValid(phone)) return ValidateResult(Cause.INVALID)
        return ValidateResult(Cause.NONE)
    }

    override fun validate(): ValidateResult<Cause> {
        val result = getResult()
        Log.d("PhoneNumberValidator", result.toString())
        return result
    }
}