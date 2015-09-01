package ngingrich.dota2quiz.generate;

import android.support.annotation.NonNull;

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
    Abilities abilities;

    public AbilityQuiz(Abilities abilities) {
        this.abilities = abilities;
    }

    public Question generateQuestion() {
        //return generateManaCostQuestion();
        return generateCooldownQuestion();
    }

    /**
     * Generate a question about an ability's cooldown.
     *
     * @return A question with 4 responses
     */
    private Question generateCooldownQuestion() {
        // Get a valid ability with a manacost
        AbilityDatum datum = getAbilityDatum();

        // Get the level of the ability (randomly)
        String[] costs = getCooldownsOfAbility(datum);
        int level = new Random().nextInt(costs.length + 1);

        // Create the question
        Question q = new Question("What is the cooldown of Level " + level + " " + datum.getDname(),
                Difficulty.MEDIUM, QuestionType.A_COOLDOWN);
        List<Integer> generatedAnswers = getGeneratedAnswers(Integer.parseInt(costs[level-1]));

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
        AbilityDatum datum = getAbilityDatum();

        // Get the level of the ability (randomly)
        String[] costs = getManacostsOfAbility(datum);
        int level = new Random().nextInt(costs.length + 1);

        // Create the question
        Question q = new Question("What is the mana cost of Level " + level + " " + datum.getDname(),
                Difficulty.MEDIUM, QuestionType.A_MANA_COST);

        /*
         * Generate the responses and add them to the question.
         * To do this, generate +5,+10,+15,+20,+25 and the converse,
         * then we'll select 3 of them
        */
        List<Integer> generatedAnswers = getGeneratedAnswers(Integer.parseInt(costs[level-1]));

        q.addAnswer(new Answer(true, costs[level-1]));
        q.addAnswer(new Answer(generatedAnswers.get(0).toString()));
        q.addAnswer(new Answer(generatedAnswers.get(1).toString()));
        q.addAnswer(new Answer(generatedAnswers.get(2).toString()));

        return q;
    }

    private String[] getManacostsOfAbility(AbilityDatum datum) {
        Cmb cmb = datum.getCmb().get(0);
        if (cmb.getType().equals("cooldown")) {
            cmb = datum.getCmb().get(1);
        }
        return cmb.getType().split("/");
    }

    private String[] getCooldownsOfAbility(AbilityDatum datum) {
        Cmb cmb = datum.getCmb().get(0);
        if (cmb.getType().equals("cooldown")) {
            cmb = datum.getCmb().get(1);
        }
        return cmb.getType().split("/");
    }

    private AbilityDatum getAbilityDatum() {
        AbilityDatum datum = abilities.getRandomDatum();
        while (datum.getCmb().size() == 0) {
            // Get a new datum if the ability doesn't have a manacost (passives)
            datum = abilities.getRandomDatum();
        }
        return datum;
    }

    private List<Integer> getGeneratedAnswers(int cost) {
        int AMOUNT_TO_GENERATE = 3;
        List<Integer> costs = new ArrayList<>();
        int costsLength = costs.size();

        for (int i = 1; i <= costsLength; i++) {
            // Positives first
            if (i <= 5) {
                costs.add(cost + (5 * i));
                // Negatives after
            } else {
                costs.add(cost - (5 * i));
            }
        }
        Random r = new Random();
        Collections.shuffle(costs);

        // Get 3 answers
        return costs.subList(0, AMOUNT_TO_GENERATE);
    }
}
