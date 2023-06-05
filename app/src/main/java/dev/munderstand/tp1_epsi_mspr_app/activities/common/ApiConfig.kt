package dev.munderstand.tp1_epsi_mspr_app.activities.common

class ApiConfig {
    companion object {
        const val BASE_URL = "http://88.125.155.66:32768/api"
        const val LOGIN_ENDPOINT = "$BASE_URL/login_check"
        const val REGISTER_ENDPOINT = "$BASE_URL/register"
        const val ACCOUNT_ENDPOINT = "$BASE_URL/main/account"
        // Add other endpoints as needed
    }
}
