package app.question.implQuestions;

import app.event.QuestionAnsweredEvent;
import app.question.Answer;
import app.question.Question;
import javafx.scene.Node;

/**
 * Created by RJ on 2017-01-04.
 */
public class RadioQuestion implements Question {
    /* Javafx representation for displaying the question: */
    private Node graphicalPart;
    /* The question's answer: */
    private Answer answer;

    //TODO
    @Override
    public Node getGraphicalPart() {
        return null;
    }

    @Override
    public void setGraphicalPart(Node graphicalPart) {
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public void setID(String ID) {
    }

    @Override
    public Answer getAnswer() {
        return null;
    }

    @Override
    public void setAnswer(Answer answer) {
    }

    @Override
    public QuestionAnsweredEvent emitEvent() {
        return null;
    }
}
