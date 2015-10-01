package ngingrich.dota2quiz;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import ngingrich.dota2quiz.generate.AbilityQuiz;
import ngingrich.dota2quiz.model.abilities.Abilities;
import ngingrich.dota2quiz.model.heroes.Heroes;
import ngingrich.dota2quiz.model.items.Items;
import ngingrich.dota2quiz.model.quiz.Answer;
import ngingrich.dota2quiz.model.quiz.Question;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int CORRECT_ANSWER_POINTS = 10;
    private static final int WRONG_ANSWER_POINTS   = 0;
    private int score = 0;
    private TextView questionText;
    private TextView scoreText;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;

    private Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            Abilities abilities = gson.fromJson(getJsonReader("abilities.json"), Abilities.class);
            Heroes heroes = gson.fromJson(getJsonReader("herodata.json"), Heroes.class);
            Items items = gson.fromJson(getJsonReader("items.json"), Items.class);
            Log.i(TAG, abilities.toString());
            Log.i(TAG, heroes.toString());
            Log.i(TAG, items.toString());
        } catch (IOException e) {
            Log.e(TAG, "Failed to parse JSON: " + e);
        }
        List<Question> questionList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            questionList.add(AbilityQuiz.generateTestQuestion());
        }

        initializeComponents();
        insertQuestion(questionList);

        /*
        Register on-click listeners
         */
        buttonA.setOnClickListener(buttonOnClickListener());
        buttonB.setOnClickListener(buttonOnClickListener());
        buttonC.setOnClickListener(buttonOnClickListener());
        buttonD.setOnClickListener(buttonOnClickListener());
    }

    private void initializeComponents() {
        questionText = (TextView) findViewById(R.id.questionText);
        scoreText    = (TextView) findViewById(R.id.scoreText);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
    }

    private void insertQuestion(List<Question> questionList) {
        currentQuestion = questionList.get(0);
        ArrayList<Answer> answers = new ArrayList<>(currentQuestion.getAnswers());
        questionText.setText(currentQuestion.getQuestion());
        updateScore();
        buttonA.setText(answers.get(0).toString());
        buttonB.setText(answers.get(1).toString());
        buttonC.setText(answers.get(2).toString());
        buttonD.setText(answers.get(3).toString());
    }

    private void updateScore() {
        scoreText.setText("Score: " + score);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener buttonOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText() == currentQuestion.getCorrectAnswer().getText()) {
                    score += CORRECT_ANSWER_POINTS;
                    updateScore();
                }
            }
        };
    }

    @NonNull
    private Reader getJsonReader(String filename) throws IOException {
        return new InputStreamReader(getAssets().open("json/"+filename));
    }
}
