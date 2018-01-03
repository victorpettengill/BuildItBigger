package br.com.victorpettengill.jokesupplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JokeSupplier {

    public Joke getJoke() {

        Joke joke1 = new Joke("The Perfect Son. ", "A: I have the perfect son. \n" +
                "B: Does he smoke? \n" +
                "A: No, he doesn't. \n" +
                "B: Does he drink whiskey? \n" +
                "A: No, he doesn't. \n" +
                "B: Does he ever come home late? \n" +
                "A: No, he doesn't. \n" +
                "B: I guess you really do have the perfect son. How old is he? \n" +
                "A: He will be six months old next Wednesday.");

        Joke joke2 = new Joke("California", "\"I was born in California.\" \n" +
                "\"Which part?\" \n" +
                "\"All of me.\"");

        Joke joke3 = new Joke("Decisions.. Decision..", "Teacher: Do you have trouble" +
                " making decisions? \n" +
                "Student: Well...yes and no.");

        List<Joke> jokes = new ArrayList<>();
        jokes.add(joke1);
        jokes.add(joke2);
        jokes.add(joke3);

        Collections.shuffle(jokes);

        return jokes.get(0);
    }

}