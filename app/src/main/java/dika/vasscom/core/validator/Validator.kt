package dika.vasscom.core.validator

data class ValidateResult<T>(val cause: T)

interface Validator<T> {
    fun validate(): ValidateResult<T>
}