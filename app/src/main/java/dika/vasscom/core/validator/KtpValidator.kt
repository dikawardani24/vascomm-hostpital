package dika.vasscom.core.validator

import android.util.Log

class KtpValidator(
    private val ktpNumber: String?,
): Validator<KtpValidator.Cause> {
    enum class Cause {
        NONE,
        NOT_ENOUGH_DIGIT,
        MAX_DIGIT_EXCEEDED,
        NOT_DIGIT,
        EMPTY
    }

    private fun isDigitOnly(ktpNumber: String): Boolean = "^[0-9]*$".toRegex()
        .matches(ktpNumber)

    private fun getResult(): ValidateResult<Cause> {
        val ktp = ktpNumber
        if (ktp == null || ktp.isEmpty()) return ValidateResult(Cause.EMPTY)
        if (ktp.length < 16) return ValidateResult(Cause.NOT_ENOUGH_DIGIT)
        if (ktp.length > 16) return ValidateResult(Cause.MAX_DIGIT_EXCEEDED)
        if (!isDigitOnly(ktp)) return ValidateResult(Cause.NOT_DIGIT)
        return ValidateResult(Cause.NONE)
    }

    override fun validate(): ValidateResult<Cause> {
        val result = getResult()
        Log.d("KTP Validator", "Result: $result")
        return result
    }
}