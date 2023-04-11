package com.example.parcial11;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegistroEspressoTest {
    @Rule
    public ActivityScenarioRule<Registros> activityScenarioRule =
            new ActivityScenarioRule<>(Registros.class);

    @Before
    public void setUp() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            DBHelper db = new DBHelper(activity);
            db.deleteAllData(); // limpiamos la tabla de usuarios antes de cada prueba
        });
    }
    @Test
    public void testInsertData() {
        onView(withId(R.id.name)).perform(typeText("Luis Corredor"), closeSoftKeyboard());
        onView(withId(R.id.contact)).perform(typeText("3506606778"), closeSoftKeyboard());
        onView(withId(R.id.dob)).perform(typeText("1977-06-11"), closeSoftKeyboard());
        onView(withId(R.id.btnInsert)).perform(click());

    }

    @Test
    public void testInsertDataWithError() {
        // aquí se prueba el caso donde se ingresan datos inválidos y se espera un mensaje de error
        onView(withId(R.id.name)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.contact)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.dob)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.btnInsert)).perform(click());
    }
}
