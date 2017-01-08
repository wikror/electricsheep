package app.question.implQuestions;

import app.event.QuestionAnsweredEvent;
import app.question.Answer;
import app.question.Question;
import javafx.scene.Node;

/**
 * Created by RJ on 2017-01-04.
 */
public class OpenQuestion implements Question {
    /* Javafx representation for displaying the question: */
    private Node graphicalPart;
    /* The question's answer: */
    private Answer answer;
    /* The question's unique ID: */
    private String ID;
    /* The question as displayed to the subject: */
    private String questionContent;


    /* Getter & setter for the graphical component: */
    @Override
    public Node getGraphicalPart() {
        return this.graphicalPart;
    }
    @Override
    public void setGraphicalPart(Node graphicalPart) {
        this.graphicalPart = graphicalPart;
    }

    /* Getter & setter for the ID: */
    @Override
    public String getID() {
        return this.ID;
    }
    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    /* Getters & setters for the answer: */
    @Override
    public Answer getAnswer() {
        return this.answer;
    }
    @Override
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    /* Getters & setters for the content: */
    public String getQuestionContent() {
        return this.questionContent;
    }
    public void setQuestionContent(String content) {
        this.questionContent = content;
    }

    /* Method emitting an event after the question is answered.
    Output: QuestionAnsweredEvent event, containing the question itself and its answer.
     */
    @Override
    public QuestionAnsweredEvent emitEvent() {
        //TODO
        return null;
    }
}
