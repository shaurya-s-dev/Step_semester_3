package object_modeling.class_problems;

import java.util.List;

public class MultipleChoiceQuestion extends ExamQuestion {
    private List<String> options;

    public MultipleChoiceQuestion(int questionNumber, String prompt, List<String> options, String correctAnswer) {
        super(questionNumber, prompt, correctAnswer);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }
}
