package app.event;

/**
 * Created by RJ on 2017-01-04.
 */
public interface QuestionAnsweredEventNotifier {

    void addQuestionAnsweredEventListener(QuestionAnsweredEventListener listener);
    void removeQuestionAnsweredEventListener(QuestionAnsweredEventListener listener);
}
