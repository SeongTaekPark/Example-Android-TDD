package sample.papamangto.android.tdd.login

interface LoginContract {
    interface View {
        fun getInputEmail(): String
        fun showMessageForIncorrectEmail()
        fun getInputPassword(): String
        fun showMessageForIncorrectPassword()
        fun hideSoftKeyboard()
        fun showLoadingDialog()
        fun hideLoadingDialog()
        fun showMessageForSuccessLogin()
        fun finishActivity()
    }

    interface Presenter {
        fun onClickEmailLogin()
    }

    interface Repository {
        fun login(email: String, password: String, callback: LoginResultCallback)
    }
}

interface LoginResultCallback {
    fun onSuccess(userInfo: UserInfo)
    fun onFail(code: Int, messsage: String)
}

