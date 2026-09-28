package object_modeling.class_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Examination {
    private String title;
    private List<ExamQuestion> questions;
    private Map<String, ExamAttempt> attempts;

    public Examination(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
        this.attempts = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(ExamQuestion question) {
        this.questions.add(question);
    }

    public List<ExamQuestion> getQuestions() {
        return questions;
    }

    public ExamAttempt startAttempt(ExamStudent student) {
        ExamAttempt existing = attempts.get(student.getName());
        if (existing != null && existing.isSubmitted()) {
            throw new IllegalStateException("Student has already submitted an attempt for " + title);
        }
        ExamAttempt newAttempt = new ExamAttempt(student, this);
        attempts.put(student.getName(), newAttempt);
        return newAttempt;
    }
}
