/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Comprehensive tests for MainActivity and ShowTextActivity.
 * Tests various scenarios including text input, button interactions, and text validation.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ComprehensiveBehaviorTest {

    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test, and close it
     * after test completes. This is a replacement for {@link androidx.test.rule.ActivityTestRule}.
     */
    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testInitialTextViewContent() {
        // Validate correct strings in the TextView in the main activity
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("Hello Espresso!")));
    }

    @Test
    public void testEnter123AndChangeTextButton() {
        // Enter "123" and press Change Text button, and test the string
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed to "123"
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }

    @Test
    public void testEnter123AndOpenActivityButton() {
        // Enter "123" and press Open Activity and Change Text button, and test the string in ShowTextActivity
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check that the text was displayed in ShowTextActivity
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }

    @Test
    public void testEmptyInputAndChangeTextButton() {
        // Without entering anything and press Change Text button and test the string (empty/null)
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed to empty string
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }

    @Test
    public void testEmptyInputAndOpenActivityButton() {
        // Without entering anything and press Open Activity and Change Text button, and test the string in ShowTextActivity (null)
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check that the text was displayed as empty string in ShowTextActivity
        // Note: ShowTextActivity uses Strings.nullToEmpty() which converts null to empty string
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testEnterAbcdefAndChangeTextButton() {
        // Enter "abcdef" and press Change Text button, and test the string
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("abcdef"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed to "abcdef"
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")));
    }

    @Test
    public void testEnterAbcdefAndOpenActivityButton() {
        // Enter "abcdef" and press Open Activity and Change Text button, and test the string in ShowTextActivity
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("abcdef"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check that the text was displayed in ShowTextActivity
        onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")));
    }

    @Test
    public void testShowTextActivityInitialContent() {
        // Navigate to ShowTextActivity first
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        
        // Validate correct strings in the TextView in the ShowTextActivity
        // When no text is entered, it should show empty string due to Strings.nullToEmpty()
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testShowTextActivityWithCustomText() {
        // Enter custom text and navigate to ShowTextActivity
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("Custom Test Text"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        
        // Validate the custom text is displayed in ShowTextActivity
        onView(withId(R.id.show_text_view)).check(matches(withText("Custom Test Text")));
    }
} 