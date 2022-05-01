package com.bear.testtdd

import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.android.synthetic.main.number_select_component.view.*
import org.junit.Assert.*
import org.junit.Test

class NumberSelectAndroidTest(){
    @Test
    fun testAddButtonThenValueShouldAdd() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val numberSelectComponent=NumberSelectComponent(appContext)
        numberSelectComponent.setDefaultValue(10)
        numberSelectComponent.addButton.performClick()
        assertEquals(11,numberSelectComponent.textValue)
    }
    @Test
    fun testMinusButtonThenValueShouldAdd() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val numberSelectComponent=NumberSelectComponent(appContext)
        numberSelectComponent.setDefaultValue(10)
        numberSelectComponent.minusButton.performClick()
        assertEquals(9,numberSelectComponent.textValue)
    }
    @Test
    fun testMinValueLimit() {

        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val numberSelect = NumberSelectComponent(context)
        numberSelect.setDefaultValue(2)
        numberSelect.setMinValue(2)
        numberSelect.minusButton.performClick()

        assertEquals(2, numberSelect.textValue)
    }
    @Test
    fun testMaxValueLimit() {

        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val numberSelect = NumberSelectComponent(context)
        numberSelect.setDefaultValue(2)
        numberSelect.setMaxValue(2)
        numberSelect.addButton.performClick()

        assertEquals(2, numberSelect.textValue)
    }
}