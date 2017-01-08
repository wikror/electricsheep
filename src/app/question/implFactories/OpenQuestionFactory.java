package app.question.implFactories;

import app.question.Question;
import app.question.QuestionFactory;
import app.question.implQuestions.OpenQuestion;

import java.util.List;

/**
 * Created by RJ on 2017-01-04.
 */
public class OpenQuestionFactory implements QuestionFactory {
    //TODO
    /* Creates a Question object from String input read from a .ques file by a QuesReader object.
    Input: List<String> lines - a list containing lines between BEGIN QUESTION and END QUESTION markups in a .ques file;
    for open questions, the list is assumed to have 2 lines (ID and displayed content).
    Output: OpenQuestion question - an OpenQuestion object with its unique ID and content as specified in the .ques.
     */
    @Override
    public Question createQuestion(List<String> lines) {

        //Initialize the question:
        OpenQuestion question = new OpenQuestion();

        //Parse the lines to get question's attributes:
        String idLine = lines.get(0);
        String ID = idLine.split("=")[1];
        question.setID(ID);
        String contentLine = lines.get(1);
        question.setQuestionContent(contentLine);

        //Return the question as created above.
        return question;
    }
}
