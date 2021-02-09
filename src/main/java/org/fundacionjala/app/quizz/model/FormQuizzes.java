package org.fundacionjala.app.quizz.model;

public class FormQuizzes {
    private Quiz quiz;
    private QuizAnswers quizAnswers;

    public FormQuizzes(Quiz quiz, QuizAnswers quizAnswers) {
        this.quiz = quiz;
        this.quizAnswers = quizAnswers;
    }

    public FormQuizzes() {
        quiz = null;
        quizAnswers = null;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public QuizAnswers getQuizAnswers() {
        return quizAnswers;
    }
}
