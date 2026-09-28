package object_modeling.class_problems;

public abstract class ExamQuestion {
    private int questionNumber;
    private String prompt;
    private String correctAnswer;

    public ExamQuestion(int questionNumber, String prompt, String correctAnswer) {
        this.questionNumber = questionNumber;
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String answer) {
        return correctAnswer != null && correctAnswer.equalsIgnoreCase(answer);
    }
}
