package sample.papamangto.android.tdd.login

class LoginRepository : LoginContract.Repository {

    companion object {
        private var INSTANCE: LoginRepository? = null

        fun getInstance(): LoginRepository {
            return INSTANCE ?: LoginRepository().apply { INSTANCE = this }
        }
    }

    override fun login(email: String, password: String, callback: LoginResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}