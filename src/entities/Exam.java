package entities;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    private int numberOfQuestions;
    private double overallScore;
    List<String> answer = new ArrayList<>(numberOfQuestions);

    public Exam(int numberOfQuestions, double overallScore) {
        this.numberOfQuestions = numberOfQuestions;
        this.overallScore = overallScore;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void addAnswer(String question) {
        answer.add(question);
    }

    public double pointsForEachQuestion() {
        return (double) overallScore / numberOfQuestions;
    }

    public List<String> getAnswerKey() {
        List<String> formattedAnswerKey = new ArrayList<>();
        for (String currentAnswer : answer){
            formattedAnswerKey.add((answer.indexOf(currentAnswer) + 1) + ") " + currentAnswer);
        }
        return formattedAnswerKey;
    }

}
