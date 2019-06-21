package sample.papamangto.android.tdd.login

class LoginRepository : LoginContract.Repository {

    companion object {
        private var INSTANCE: LoginRepository? = null

        fun getInstance(): LoginRepository {
            return INSTANCE ?: LoginRepository().apply { INSTANCE = this }
        }
    }
}