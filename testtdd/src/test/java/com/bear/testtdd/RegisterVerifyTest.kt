package com.bear.testtdd

import org.junit.Test

import org.junit.Assert.*

class RegisterVerifyTest {

    @Test
    fun checkAccountInValid() {
        val registerVerify=RegisterVerify()
        val respected=false
        val actual=registerVerify.checkAccount("abc")
        assertEquals(respected,actual)
    }
    @Test
    fun checkAccountValid() {
        val registerVerify=RegisterVerify()
        val respected=true
        val actual=registerVerify.checkAccount("abc21213")
        assertEquals(respected,actual)
    }
}