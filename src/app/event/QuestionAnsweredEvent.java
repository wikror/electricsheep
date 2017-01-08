package app.event;

import app.question.Question;

/**
 * Created by RJ on 2017-01-04.
 */
public class QuestionAnsweredEvent {
    /* The question that has been answered (contains the answer as its attribute). */
    private Question answeredQuestion;

    /* Getter & setter for the question carried by the event. */
    public Question getAnsweredQuestion() {
        return this.answeredQuestion;
    }
    public void setAnsweredQuestion(Question answeredQuestion) {
        this.answeredQuestion = answeredQuestion;
    }
}
