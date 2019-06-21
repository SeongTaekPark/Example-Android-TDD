package sample.papamangto.android.tdd.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import sample.papamangto.android.tdd.Injector
import sample.papamangto.android.tdd.R

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, Injector.provideLoginRespository())
    }
}
