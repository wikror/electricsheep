package app.io;

import app.exceptions.InvalidQuesException;
import app.question.Question;
import app.question.QuestionFactory;
import app.question.implFactories.OpenQuestionFactory;
import app.question.implFactories.RadioQuestionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by RJ on 2017-01-04.
 */
public class QuesReader {

    /* Lookup variable mapping question types & their proper factories
    (together with its static-block initialization):
    */
    private static Map<String, QuestionFactory> factoryMap;

    static {
        factoryMap.put("RADIO", new RadioQuestionFactory());
        factoryMap.put("OPEN", new OpenQuestionFactory());
    }

    /* Reads a .ques file containing details of the study & returns a list of questions
    for further processing by the Controller.
    Input: String fileName - path to the .ques file.
    Output: ArrayList<Question> questions - as produced by proper QuestionFactories.
     */
    public List<Question> readQuestionsFromFile(String fileName) {

        //Initialize variables used throughout the method:
        String currentLine;
        List<String> questionAsLines = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        //Get a buffered reader working on the file:
        InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));

        //Read the questions from file until the END markup is encountered:
        try {
            currentLine = reader.readLine();
            while (!(currentLine.equals("END"))) {
                currentLine = reader.readLine();
                if (currentLine.startsWith("BEGIN QUESTION")) {
                    //Read question type, get a proper QuestionFactory and feed it with the question's lines from the file:
                    String[] lineAsTokens = currentLine.split(" ");
                    String questionType = lineAsTokens[2].split("=")[1];
                    QuestionFactory factory = factoryMap.get(questionType);
                    while (!((currentLine = reader.readLine()).equals("END QUESTION"))) {
                        questionAsLines.add(currentLine);
                    }
                    Question newQuestion = factory.createQuestion(questionAsLines);
                    questions.add(newQuestion);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Return the list of question now represented properly as Question objects:
        return questions;
    }
}