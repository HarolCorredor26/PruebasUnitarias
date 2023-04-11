package com.example.parcial11;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testButtonClick() {
        onView(withId(R.id.txtUsuario)).perform(typeText("harol"), closeSoftKeyboard());
        onView(withId(R.id.txtPassword)).perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.btnIngresar)).perform(click());

        onView(withId(R.id.txtUsuario)).check(matches(withText("harol")));
        onView(withId(R.id.txtPassword)).check(matches(withText("1234")));
        }


}

