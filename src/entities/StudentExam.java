package entities;

public class StudentExam extends Exam {

    private String name;
    private int enrolment;
    private int correctAnswer;

    public StudentExam(int numberOfQuestions, double overallScore, String name, int enrolment) {
        super(numberOfQuestions, overallScore);
        this.name = name;
        this.enrolment = enrolment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public double score() {
        return (double) correctAnswer * pointsForEachQuestion();
    }


}
