package sample.papamangto.android.tdd.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import sample.papamangto.android.tdd.Injector
import sample.papamangto.android.tdd.R

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, Injector.provideLoginRespository())

        emailLoginButton.setOnClickListener {
            presenter.onClickEmailLogin()
        }
    }

    override fun getInputEmail(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessageForIncorrectEmail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInputPassword(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessageForIncorrectPassword() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideSoftKeyboard() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessageForSuccessLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun finishActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
