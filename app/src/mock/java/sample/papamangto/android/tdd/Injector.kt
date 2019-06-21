package sample.papamangto.android.tdd

import sample.papamangto.android.tdd.login.LoginContract
import sample.papamangto.android.tdd.login.LoginRepository

object Injector {
    fun provideLoginRespository(): LoginContract.Repository {
        return LoginRepository.getInstance()
    }
}