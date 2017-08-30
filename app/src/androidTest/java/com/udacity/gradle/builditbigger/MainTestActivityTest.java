package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

/**
 * Created by dariomartin on 29/8/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainTestActivityTest {

    @Rule
    public IntentsTestRule<MainTestActivity> activityRule = new IntentsTestRule<>(MainTestActivity.class);

    private IdlingResource idlingResource;

    @Before
    public void registerIdlingResource() {
        idlingResource = activityRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(idlingResource);
    }

    @Test
    public void clickFirstRecipe_ShowsRecipeSteps() {

        onView(withId(R.id.joke_button)).perform(click());

        MainTestActivity loginActivity = activityRule.getActivity();

        loginActivity.setTestCallback(new MainTestActivity.TestCallback() {
            @Override
            public void onResponse(String joke) {
                assertTrue(!joke.isEmpty());
            }
        });
    }

}