package ngingrich.dota2quiz.generate;

import android.support.annotation.NonNull;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import ngingrich.dota2quiz.model.abilities.Abilities;

/**
 * Created by nathan on 10/21/15.
 */
public class AbilityQuizTest {
    private Abilities abilities;
    private AbilityQuiz quiz;

    @Test(expected=UnsupportedOperationException.class)
    public void testGenerateQuestion() {
        quiz.generateQuestion();
    }


    @Before
    public void setUp() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            this.abilities = gson.fromJson(getJsonReader("abilities.json"), Abilities.class);
            quiz = new AbilityQuiz(abilities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private Reader getJsonReader(String filename) throws IOException {
        return null;
    }
}
