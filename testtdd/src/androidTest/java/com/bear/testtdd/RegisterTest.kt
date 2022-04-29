package com.bear.testtdd

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@LargeTest
class RegisterTest{
    @Rule
    @JvmField
    val activityTestRule=ActivityTestRule(MainActivity::class.java)//開啟activity
    @Test
    fun WrongPassword_should_startActivity(){
        inputWrongRegisterData()
        onView(withId(R.id.login)).perform(click())
        onView(withText("註冊失敗")).inRoot(isDialog()).check(matches(isDisplayed()))
    }
    fun inputWrongRegisterData(){
        //輸入帳號
        onView(withId(R.id.account)).perform(clearText(),typeText("5abc1123"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.password)).perform(clearText(),typeText("4454754"), ViewActions.closeSoftKeyboard())

    }
    @Test
    fun rightPassword_should_startActivity(){
        inputRightRegisterData()
        onView(withId(R.id.login)).perform(click())
        onView(withText("註冊成功")).check(matches(isDisplayed()))
    }

    fun inputRightRegisterData(){
        //輸入帳號
        onView(withId(R.id.account)).perform(clearText(),typeText("abc1123"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.password)).perform(clearText(),typeText("aaa12"), ViewActions.closeSoftKeyboard())
    }
}