/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import br.com.victorpettengill.jokesupplier.Joke;
import br.com.victorpettengill.jokesupplier.JokeSupplier;

/** An endpoint class we are exposing */
@Api(
        name = "jokeApi",
        version = "v2",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeApiEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {

        JokeSupplier supplier = new JokeSupplier();

        return supplier.getJoke();
    }

}
