package app.question;

import java.util.List;

/**
 * Created by RJ on 2017-01-04.
 */
public interface QuestionFactory {

    public Question createQuestion(List<String> lines);
}
