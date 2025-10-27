package dika.vasscom.core.domain.useCase

import dika.vasscom.core.domain.model.User
import dika.vasscom.core.local.UserPreference

class SaveTokenUseCase(
    private val userPreference: UserPreference
) {
    suspend fun execute(user: User) =
        userPreference.saveTokens(user.token)
}