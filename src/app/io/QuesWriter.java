package app.io;

import app.event.QuestionAnsweredEvent;
import app.question.Answer;
import app.question.Question;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WR on 2017-01-09.
 */
public class QuesWriter {

    public QuesWriter(String studyID, String subjectID, List<Question> answered) {
        Map<String, Question> answeredQuestions = new HashMap<>();
        for (Question question : answered) {
            answeredQuestions.put(question.getID(), question);
        }
        this.answeredQuestions = answeredQuestions;
        this.studyID = studyID;
        this.subjectID = subjectID;
    }

    private Map<String, Question> answeredQuestions;
    private final String studyID;
    private final String subjectID;

    public void createCSV() {

        Path path = Paths.get("output_"+studyID+".csv");
        File file = new File(path.toString());

        //if file doesn't exist, we want to add header:
        if (!file.isFile()) {
            try (FileWriter fw = new FileWriter("output_"+studyID+".csv", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter writer = new PrintWriter(bw)) {
                writer.println("subjectID");
                String header = "subjectID";
                for (String key : answeredQuestions.keySet()) {
                    writer.println(key);
                    // a list of question ids line by line is easier for reading in the next step,
                    // and reading is necessary to add the questions in the same order to the csv
                    // (unless the order will be guaranteed by the agregator)
                    header += "," + key;
                }
                writer.println(header);
                writer.close();
            } catch (Exception e) {}
        }

        //appending answers:
        try (FileWriter fw = new FileWriter("output_"+studyID+".csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter writer = new PrintWriter(bw)) {
            List<String> ids = new ArrayList<>();
            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String line = reader.readLine();
            while (!line.contains(",")) {
                ids.add(line.trim());
                line = reader.readLine();
            }
            writer.print(subjectID);
            for(String id : ids) {
                writer.print(","+answeredQuestions.get(id).getAnswer().toString());
            }
            writer.print("\n");
            writer.close();

        } catch (Exception e){}

    }



}
