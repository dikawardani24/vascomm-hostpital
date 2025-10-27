package dika.vasscom.core.local

interface UserPreference {
    suspend fun saveTokens(accessToken: String)
    suspend fun getAccessToken(): String?
    suspend fun clearTokens()
}