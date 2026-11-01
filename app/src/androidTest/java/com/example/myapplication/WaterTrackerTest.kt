package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Положить в app/src/androidTest/java/com/example/myapplication/
class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent { WaterTracker() }
    }

    private fun drink(times: Int) {
        repeat(times) { composeTestRule.onNodeWithText("+250 мл").performClick() }
    }

    // 1) Кнопка добавления жидкости есть и работает
    @Test
    fun addWaterButton_isDisplayed_andIncreasesCounter() {
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("500 мл").assertIsDisplayed()
    }

    // 2) Кнопка «Завершить день» есть и работает
    @Test
    fun finishDayButton_isDisplayed_andResetsCounter() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()

        drink(2)
        composeTestRule.onNodeWithText("500 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    // 3) Выводится нужный текст с количеством дней подряд
    @Test
    fun streakText_increasesAfterGoal_andResetsOtherwise() {
        composeTestRule
            .onNodeWithText("Дней подряд (1500 мл и больше): 0").assertIsDisplayed()

        // День 1: выпито 1500 мл -> серия 1
        drink(6)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule
            .onNodeWithText("Дней подряд (1500 мл и больше): 1").assertIsDisplayed()

        // День 2: тоже 1500 мл -> серия 2
        drink(6)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule
            .onNodeWithText("Дней подряд (1500 мл и больше): 2").assertIsDisplayed()

        // День 3: меньше 1500 мл -> серия обнуляется
        drink(1)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule
            .onNodeWithText("Дней подряд (1500 мл и больше): 0").assertIsDisplayed()
    }
}