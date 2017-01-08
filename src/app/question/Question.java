package app.question;

import app.event.QuestionAnsweredEvent;
import javafx.scene.Node;

/**
 * Created by RJ on 2017-01-04.
 */
public interface Question {

    /* Getter & setter for the question's graphical component (for displaying purposes). */
    public Node getGraphicalPart();
    public void setGraphicalPart(Node graphicalPart);

    /* Getter & setter for the question's ID. */
    public String getID();
    public void setID(String ID);

    /* Getter & setter for the question's answer. */
    public Answer getAnswer();
    public void setAnswer(Answer answer);

    /* Emits an event for Listeners after the question has been answered. */
    public QuestionAnsweredEvent emitEvent();

}
