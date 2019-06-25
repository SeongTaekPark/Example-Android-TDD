package sample.papamangto.android.tdd

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import sample.papamangto.android.tdd.login.LoginContract
import sample.papamangto.android.tdd.login.LoginPresenter
import sample.papamangto.android.tdd.login.LoginResultCallback
import sample.papamangto.android.tdd.login.UserInfo

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var repository: LoginContract.Repository

    private lateinit var presenter: LoginPresenter

    private lateinit var inOrder: InOrder

    @Captor
    private lateinit var loginResultListener: ArgumentCaptor<LoginResultCallback>

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
        `when`(view.getInputEmail()).thenReturn("taekme@naver")

        presenter.onClickEmailLogin()

        verify(view).showMessageForIncorrectEmail()
    }

    /**
     * 이메일 로그인 실패 케이스 - 잘못된 패스워드 형식 입력
     */
    @Test
    fun test_onClickEmailLogin_FailLogin_EnterIncorrectPassword() {
        `when`(view.getInputEmail()).thenReturn("roy.kim@goodoc.co.kr")
        `when`(view.getInputPassword()).thenReturn("123")

        presenter.onClickEmailLogin()

        verify(view).showMessageForIncorrectPassword()
    }

    /**
     * 이메일 로그인 성공 케이스
     */
    @Test
    fun test_onClickEmailLogin_SuccessLogin() {
        val mockUserInfo = mock(UserInfo::class.java)

        // 올바른 이메일 입력
        `when`(view.getInputEmail()).thenReturn("roy.kim@goodoc.co.kr")
        // 올바른 패스워드 입력
        `when`(view.getInputPassword()).thenReturn("roy.kim@goodoc.co.kr")

        // 이메일 로그인 버튼을 클릭
        presenter.onClickEmailLogin()
        // 입력값을 검증

        // 키보드를 숨긴다.
        inOrder.verify(view).hideSoftKeyboard()
        // 로딩 다이얼로그를 보여준다.
        inOrder.verify(view).showLoadingDialog()

        // 서버에 아이디/비밀번호를 전달해서 로그인 처리한다.
        val email = view.getInputEmail()
        val password = view.getInputPassword()
        inOrder.verify(repository).login(eq(email), eq(password), capture(loginResultListener))
        loginResultListener.value.onSuccess(mockUserInfo)
        // (로그인 성공)

        // 로딩 다이얼로그를 감춘다.
        inOrder.verify(view).hideLoadingDialog()
        // 로그인 성공 메시지를 보여준다.
        inOrder.verify(view).showMessageForSuccessLogin()
        // 로그인 화면을 종료한다.
        inOrder.verify(view).finishActivity()
    }
}