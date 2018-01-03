package com.udacity.gradle.builditbigger.listeners;


import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;

/**
 * Created by appimagetech on 03/01/18.
 */

public interface JokeListener {

    void onResult(Joke joke);

}