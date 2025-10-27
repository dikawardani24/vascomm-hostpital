package dika.vasscom.core.validator

import android.util.Log

class NewPasswordValidator(
    private val newPassword: String?,
    private val confirmPassword: String?,
    private val minLength: Int = 6,
    private val maxLength: Int = 10
): Validator<NewPasswordValidator.Cause> {
    enum class Cause {
        MIN_LENGTH,
        MAX_LENGTH,
        NO_MATCH,
        EMPTY_NEW,
        EMPTY_CONFIRM,
        NONE
    }

    private fun getResult(): ValidateResult<Cause> {
        val newPass = newPassword
        val confirmPass = confirmPassword

        if (newPass == null || newPass.isEmpty())
            return ValidateResult(Cause.EMPTY_NEW)
        if (confirmPass == null || confirmPass.isEmpty())
            return ValidateResult(Cause.EMPTY_CONFIRM)
        if (newPass.length < minLength)
            return ValidateResult(Cause.MIN_LENGTH)
        if (newPass.length > maxLength)
            return ValidateResult(Cause.MAX_LENGTH)
        if (newPass != confirmPass)
            return ValidateResult(Cause.NO_MATCH)
        return ValidateResult(Cause.NONE)
    }

    override fun validate(): ValidateResult<Cause> {
        val result = getResult()
        Log.d("NewPasswordValidator", result.toString())
        return result
    }
}