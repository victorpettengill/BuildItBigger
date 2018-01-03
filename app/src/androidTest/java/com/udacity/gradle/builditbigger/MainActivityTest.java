package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;
import com.udacity.gradle.builditbigger.listeners.JokeListener;
import com.udacity.gradle.builditbigger.tasks.JokeAsyncTask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);
        new JokeAsyncTask(new JokeListener() {
            @Override
            public void onResult(Joke joke) {

                assertNotNull(joke);
                latch.countDown();


            }
        }).execute();

        latch.await();

    }


}