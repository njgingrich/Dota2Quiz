package ngingrich.dota2quiz.generate;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ngingrich.dota2quiz.model.abilities.Abilities;
import ngingrich.dota2quiz.model.abilities.AbilityDatum;
import ngingrich.dota2quiz.model.abilities.Cmb;
import ngingrich.dota2quiz.model.quiz.Answer;
import ngingrich.dota2quiz.model.quiz.Difficulty;
import ngingrich.dota2quiz.model.quiz.Question;
import ngingrich.dota2quiz.model.quiz.QuestionType;

/**
 * Created by nathan on 8/2/15.
 */
public class AbilityQuiz {
    private static final String TAG = AbilityQuiz.class.getSimpleName();
    Abilities abilities;

    public AbilityQuiz(Abilities abilities) {
        this.abilities = abilities;
    }

    public Question generateQuestion() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                return generateTestQuestion();
            case 1:
                return generateManaCostQuestion();
            case 2:
                return generateCooldownQuestion();
            default:
                throw new UnsupportedOperationException("Invalid option");
        }
    }

    public static Question generateTestQuestion() {
        Question q = new Question("What is the damage of level 4 Crystal Nova?",
            Difficulty.MEDIUM, QuestionType.A_DAMAGE);
        q.addAnswer(new Answer(true, "250"));
        q.addAnswer(new Answer("100"));
        q.addAnswer(new Answer("200"));
        q.addAnswer(new Answer("300"));
        return q;
    }

    /**
     * Generate a question about an ability's cooldown.
     *
     * @return A question with 4 responses
     */
    private Question generateCooldownQuestion() {
        // Get a valid ability with a cooldown
        AbilityDatum datum = getAbilityDatumWithCooldown();

        // Get the level of the ability (randomly)
        String[] costs = getCooldownsOfAbility(datum);
        Log.i(TAG, "costs: " + costs[0]);
        int level = new Random().nextInt(costs.length) + 1;

        // Create the question
        Question q = new Question("What is the cooldown of Level " + level + " " + datum.getDname() + "?",
                Difficulty.MEDIUM, QuestionType.A_COOLDOWN);
        List<Double> generatedAnswers = getGeneratedAnswers(Double.parseDouble(costs[level-1]));

        q.addAnswer(new Answer(true, costs[level-1]));
        q.addAnswer(new Answer(generatedAnswers.get(0).toString()));
        q.addAnswer(new Answer(generatedAnswers.get(1).toString()));
        q.addAnswer(new Answer(generatedAnswers.get(2).toString()));
        return q;
    }

    /**
     * Generate a question about an ability's manacost. The question will look something
     * like this:
     *
     * Q: What is the manacost of Level 3 Mana Void?
     * A: 220 B: 250 C: 275 D: 300 (C is correct)
     * @return A question with 4 responses
     */
    private Question generateManaCostQuestion() {
        // Get a valid ability with a manacost
        AbilityDatum datum = getAbilityDatumWithManacost();

        // Get the level of the ability (randomly)
        String[] costs = getManacostsOfAbility(datum);
        Log.i(TAG, "costs: " + costs[0]);
        int level = new Random().nextInt(costs.length) + 1;
        Log.i(TAG, "randomly chose " + level + " from " + costs.length);

        // Create the question
        Question q = new Question("What is the mana cost of Level " + level + " " + datum.getDname() + "?",
                Difficulty.MEDIUM, QuestionType.A_MANA_COST);

        /*
         * Generate the responses and add them to the question.
         * To do this, generate +5,+10,+15,+20,+25 and the converse,
         * then we'll select 3 of them
        */
        List<Double> generatedAnswers = getGeneratedAnswers(Double.parseDouble(costs[level-1]));

        q.addAnswer(new Answer(true, costs[level-1]));
        q.addAnswer(new Answer(generatedAnswers.get(0).toString()));
        q.addAnswer(new Answer(generatedAnswers.get(1).toString()));
        q.addAnswer(new Answer(generatedAnswers.get(2).toString()));

        return q;
    }

    private String[] getManacostsOfAbility(AbilityDatum datum) {
        Cmb cmb = datum.getCmb().get(0);
        if (cmb.getType().equals("cooldown")) { // then get the other one
            cmb = datum.getCmb().get(1);
            Log.i(TAG, "Returning manacosts for cmb: " + cmb);
        }
        return cmb.getValue().split("/");
    }

    public String[] getCooldownsOfAbility(AbilityDatum datum) {
        Cmb cmb = datum.getCmb().get(0);
        if (cmb.getType().equals("manacost")) {
            cmb = datum.getCmb().get(1);
        }
        return cmb.getValue().split("/");
    }

    private AbilityDatum getAbilityDatum() {
        return abilities.getRandomDatum();
    }

    private AbilityDatum getAbilityDatumWithManacost() {
        AbilityDatum datum = getAbilityDatum();

        while (true) {
            // if size is 0, start over
            // if get(0) is "cooldown", check if get(1) != null
                // if get(1) is not null, get(1) must be manacost

            if (datum.getCmb().size() == 0) {
                Log.i(TAG, "size was 0, trying again");
            } else {
                List<Cmb> cmbList = datum.getCmb();
                Log.i(TAG, "found cmb list:");
                for (Cmb cmb : cmbList) {
                    Log.i(TAG, cmb.toString());
                }
                if (cmbList.get(0).getType().equals("cooldown")) {
                    if (cmbList.get(1) != null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            datum = getAbilityDatum();
        }
        return datum;
    }

    private AbilityDatum getAbilityDatumWithCooldown() {
        AbilityDatum datum = getAbilityDatum();

        while (true) {
            // if size is 0, start over
            // if get(0) is "manacost", check if get(1) != null
            // if get(1) is not null, get(1) must be cooldown

            if (datum.getCmb().size() == 0) {
                Log.i(TAG, "size was 0, trying again");
            } else {
                List<Cmb> cmbList = datum.getCmb();
                Log.i(TAG, "found cmb list:");
                for (Cmb cmb : cmbList) {
                    Log.i(TAG, cmb.toString());
                }
                if (cmbList.get(0).getType().equals("manacost")) {
                    if (cmbList.get(1) != null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            datum = getAbilityDatum();
        }
        return datum;
    }

    private List<Double> getGeneratedAnswers(double cost) {
        int AMOUNT_TO_GENERATE = 3;
        List<Double> costs = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            costs.add(cost + (5 * i));
            costs.add(cost - (5 * i));
        }
        Random r = new Random();
        Collections.shuffle(costs);

        // Get 3 answers
        return costs.subList(0, AMOUNT_TO_GENERATE);
    }
}
