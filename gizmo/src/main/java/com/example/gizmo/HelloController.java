package com.example.gizmo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public Button btnOption1;
    @FXML
    public Button btnOption2;
    @FXML
    public Button btnOption4;
    @FXML
    public Button btnSubmit;
    @FXML
    public Button btnOption3;
    @FXML
    public Button btnNext;
    @FXML
    public Text txtScore;
    public TextField questionField;

    private int currentQuestionIndex = 0;
    private int score = 0;
    private String correctAnswer;

    private List<Question> questions = new ArrayList<>();

    public void initialize() {
        loadQuestions();
        displayQuestion();

        txtScore.setText("Score: 0/4");

        btnOption1.setOnAction(e -> checkAnswer(btnOption1.getText()));
        btnOption2.setOnAction(e -> checkAnswer(btnOption2.getText()));
        btnOption3.setOnAction(e -> checkAnswer(btnOption3.getText()));
        btnOption4.setOnAction(e -> checkAnswer(btnOption4.getText()));

        btnNext.setOnAction(e -> nextQuestion());
        btnSubmit.setOnAction(e -> submitQuiz());
    }

    private void loadQuestions() {
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, "4"));
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "Paris"));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, "Mars"));
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question q = questions.get(currentQuestionIndex);
            questionField.setText(q.getQuestion());
            String[] answers = q.getAnswers();
            btnOption1.setText(answers[0]);
            btnOption2.setText(answers[1]);
            btnOption3.setText(answers[2]);
            btnOption4.setText(answers[3]);
            correctAnswer = q.getCorrectAnswer();
        }
    }

    private void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(correctAnswer)) {
            score++;
        }
        txtScore.setText("Score: " + score + "/4");
    }

    private void nextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            displayQuestion();
        } else {
            questionField.setText("Quiz Finished!");
        }
    }

    private void submitQuiz() {
        questionField.setText("Final Score: " + score);
    }



}