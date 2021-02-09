package org.fundacionjala.app.quizz.console.util;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import org.fundacionjala.app.quizz.Menu;
import org.fundacionjala.app.quizz.model.FormQuizzes;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DataPersistence<T> {

    private  static final Gson gson = new Gson();

    public static String saveData(FormQuizzes formQuizzes) {

        if (formQuizzes.getQuiz() != null && formQuizzes.getQuizAnswers() != null) {
            try {
                saveQuiz(formQuizzes);
            } catch (JsonIOException exception) {
                return "Uf! something went wrong, please check the log";
            }
            return "Saved successfully";
        }else{
            return "The Quizzes are empty nothing to save";
        }
    }


    private static void saveQuiz(FormQuizzes formQuizzes) {
        try (Writer writer = new FileWriter("./myQuiz.json")) {
            gson.toJson(formQuizzes, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static FormQuizzes readData(){
        try (JsonReader reader = new JsonReader(new FileReader("./myQuiz.json"))) {
            return gson.fromJson(reader, FormQuizzes.class);
        } catch (IOException exception) {
            exception.printStackTrace();
            return new FormQuizzes();
        }
    }

}
