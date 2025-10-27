package dika.vasscom.core.domain

interface UseCase<T> {
    suspend fun execute(): T
}