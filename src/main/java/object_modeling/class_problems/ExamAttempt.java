package object_modeling.class_problems;

import java.util.HashMap;
import java.util.Map;

public class ExamAttempt {
    private ExamStudent student;
    private Examination examination;
    private Map<Integer, String> answers;
    private boolean submitted;
    private int score;

    public ExamAttempt(ExamStudent student, Examination examination) {
        this.student = student;
        this.examination = examination;
        this.answers = new HashMap<>();
        this.submitted = false;
        this.score = 0;
    }

    public ExamStudent getStudent() {
        return student;
    }

    public Examination getExamination() {
        return examination;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public String answerQuestion(int questionNumber, String answer) {
        if (submitted) {
            return "Cannot change answers: Attempt has already been submitted.";
        }
        answers.put(questionNumber, answer);
        return "Question " + questionNumber + " answered with '" + answer + "'.";
    }

    public String submit() {
        if (submitted) {
            return "Attempt has already been submitted.";
        }
        this.submitted = true;
        this.score = 0;
        for (ExamQuestion q : examination.getQuestions()) {
            String studentAnswer = answers.get(q.getQuestionNumber());
            if (studentAnswer != null && q.isCorrect(studentAnswer)) {
                this.score++;
            }
        }
        return "Examination '" + examination.getTitle() + "' submitted successfully.";
    }

    public String getResult() {
        return "Result for '" + examination.getTitle() + "' attempt: " + score + "/" + examination.getQuestions().size() + " correct";
    }
}
