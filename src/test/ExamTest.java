package test;



import entities.Exam;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {

    Exam exam = new Exam(5, 10.0);

    @Test
    void getNumberOfQuestions() {
        int expected = 5;
        int result = exam.getNumberOfQuestions();
        assertEquals(expected, result);
    }

    @Test
    void setNumberOfQuestions() {
        int expected = 6;
        exam.setNumberOfQuestions(expected);
        int result = exam.getNumberOfQuestions();
        assertEquals(expected, result);
    }

    @Test
    void getOverallScore() {
        double expected = 10.0;
        double result = exam.getOverallScore();

        assertEquals(expected, result);
    }

    @Test
    void setOverallScore() {
        double expected = 5.5;
        exam.setOverallScore(5.5);
        double result = exam.getOverallScore();

        assertEquals(expected, result);
    }

    @Test
    void handleAnswer() {
       exam.addAnswer("A");
       exam.addAnswer("B");
       exam.addAnswer("C");

        String[] expectedOutput = {"A", "B", "C"};

        String[] methodOutput = exam.getAnswer().toArray(new String[0]);
        assertArrayEquals(expectedOutput, methodOutput);
    }

    @Test
    void pointsForEachQuestion() {
        double expected = 2.0;
        double result = exam.pointsForEachQuestion();

        assertEquals(expected, result);

    }

    @Test
    void getAnswerKey() {
        exam.addAnswer("A");
        exam.addAnswer("B");
        exam.addAnswer("C");

        String expected01 = "1) A";
        String expected02 = "2) B";
        String expected03 = "3) C";
        List<String> result = exam.getAnswerKey();

        assertEquals(expected01, result.get(0));
        assertEquals(expected02, result.get(1));
        assertEquals(expected03, result.get(2));
    }
}