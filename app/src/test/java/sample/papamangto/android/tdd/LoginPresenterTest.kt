package sample.papamangto.android.tdd

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InOrder
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import sample.papamangto.android.tdd.login.LoginContract
import sample.papamangto.android.tdd.login.LoginPresenter

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var repository: LoginContract.Repository

    private lateinit var presenter: LoginPresenter

    private lateinit var inOrder: InOrder

    @Before
    fun setup() {
        presenter = LoginPresenter(view, repository)

        inOrder = Mockito.inOrder(view, repository)
    }

    /**
     * 이메일 로그인 실패 케이스 - 잘못된 이메일 형식 입력
     */
    @Test
    fun test_onClickEmailLogin__FailLogin__EnterIncorrectEmail() {

    }
}