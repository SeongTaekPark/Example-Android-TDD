package sample.papamangto.android.tdd.login

import android.util.Log


class LoginPresenter(val view: LoginContract.View, val repository: LoginContract.Repository) : LoginContract.Presenter {

    override fun onClickEmailLogin() {
        val inputEmail = view.getInputEmail()
        if (!Validator.isValidEmail(inputEmail)) {
            view.showMessageForIncorrectEmail()
            return
        }

        val inputPassword = view.getInputPassword()
        if (!Validator.isValidPassword(inputPassword)) {
            view.showMessageForIncorrectPassword()
            return
        }

        view.hideSoftKeyboard()
        view.showLoadingDialog()

        // 서버에 아이디/비밀번호를 전달해서 로그인 처리한다.
        val email = view.getInputEmail()
        val password = view.getInputPassword()

        repository.login(email, password, object: LoginResultCallback {
            override fun onSuccess(userInfo: UserInfo) {
                view.hideLoadingDialog()
                view.showMessageForSuccessLogin()
                view.finishActivity()
            }

            override fun onFail(code: Int, messsage: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}