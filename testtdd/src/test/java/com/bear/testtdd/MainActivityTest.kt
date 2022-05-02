package com.bear.testtdd

import Utils555
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowAlertDialog

//使用Robolectric來模擬ui介面在unit test執行
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    lateinit var activity:MainActivity
    @Before
    fun setupActivity() {
        //MockitoAnnotations.initMocks(this)
        activity=Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }
    //測試帳號符合規範是否跳頁成功並帶正確的值過去
    @Test
    fun registerSuccessShouldDirectToResult(){
        //當下activity隱藏的物件
        val shadowActivity= Shadows.shadowOf(activity)
        val userId="abc1234"
        val password="abc1111"
        activity.account.setText(userId)
        activity.password.setText(password)
        //點下註冊按鈕
        activity.login.performClick()

        //驗證註冊成功時，是否有開啟ResultActivity
        //得到意圖去下一個activity的intent
        val nextIntent = shadowActivity.nextStartedActivity
        //判斷下一個activity是否是ResultActivity
        assertEquals(nextIntent.component?.className,ResultActivity::class.java. name)
        //判斷該intent的extra是否只有一個
        assertEquals(1,nextIntent?.extras!!.size())
        //判斷該intent的extra是否是該account
        assertEquals(userId,nextIntent.extras!!.getString("account"))
    }
    @Test
    fun registerFailShouldDirectToResult(){
        val userId="1abc1234"
        val password="2abc1111"
        activity.account.setText(userId)
        activity.password.setText(password)
        //點下註冊按鈕
        activity.login.performClick()
        val dialog=ShadowAlertDialog.getLatestDialog()
        //判斷最後一個dialog是不是null
        assertNotNull(dialog)
        //判斷dialog是否有顯示
        assertTrue(dialog.isShowing)
    }
}