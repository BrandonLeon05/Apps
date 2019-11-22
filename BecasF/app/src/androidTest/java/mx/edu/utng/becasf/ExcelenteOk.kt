package mx.edu.utng.becasf


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import mx.edu.utng.becasf.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExcelenteOk {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun excelenteOk() {
        val appCompatEditText = onView(
allOf(withId(R.id.etxEdad),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        appCompatEditText.perform(replaceText("25"), closeSoftKeyboard())
        
        val appCompatEditText2 = onView(
allOf(withId(R.id.etxPromedio),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatEditText2.perform(replaceText("98"), closeSoftKeyboard())
        
        val appCompatEditText3 = onView(
allOf(withId(R.id.etxIngreso),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
5),
isDisplayed()))
        appCompatEditText3.perform(replaceText("2000"), closeSoftKeyboard())
        
        val appCompatEditText4 = onView(
allOf(withId(R.id.etxHermanos),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        appCompatEditText4.perform(replaceText("3"), closeSoftKeyboard())
        
        val appCompatEditText5 = onView(
allOf(withId(R.id.etxFolio),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
7),
isDisplayed()))
        appCompatEditText5.perform(replaceText("123"), closeSoftKeyboard())
        
        val appCompatEditText6 = onView(
allOf(withId(R.id.etxBeca),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
10),
isDisplayed()))
        appCompatEditText6.perform(replaceText("3"), closeSoftKeyboard())
        
        val appCompatButton = onView(
allOf(withId(R.id.btnSolicitar), withText("Solicitar"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
12),
isDisplayed()))
        appCompatButton.perform(click())
        
        val appCompatButton2 = onView(
allOf(withId(R.id.btnRegresar), withText("Regresar"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatButton2.perform(click())
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
