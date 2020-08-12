package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher {

    Exam answerKey;
    int numberOfStudents;
    List<StudentExam> studentExamList = new ArrayList<>(numberOfStudents);

    public Teacher(Exam answerKey, int numberOfStudents) {
        this.answerKey = answerKey;
        this.numberOfStudents = numberOfStudents;
    }

    public Exam getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(Exam answerKey) {
        this.answerKey = answerKey;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<StudentExam> getStudentExamList() {
        return studentExamList;
    }

    public void addStudentExams(StudentExam exam) {
        studentExamList.add(exam);
    }

    public void calculateNumberOfCorrectAnswers() {

        for (StudentExam currentStudentExam : studentExamList) {
            printStudentsData(currentStudentExam);
            System.out.println();
            checkCorrectAnswers(currentStudentExam);
            System.out.println();
        }
    }

    public void checkCorrectAnswers(StudentExam currentStudentExam) {
        int result = 0;
        for (int j = 0; j < answerKey.getNumberOfQuestions(); j++) {
            if (answerKey.answer.get(j).equals(currentStudentExam.answer.get(j))){
                result = result + 1;
                currentStudentExam.setCorrectAnswer(result);
                System.out.println((j + 1) + ") " + currentStudentExam.answer.get(j) + " CORRECT");
            } else {
                System.out.println((j + 1) + ") " + currentStudentExam.answer.get(j) + " WRONG");
            }
        }
    }

    public void printStudentsData(StudentExam currentStudent) {
            System.out.println("Name: " + currentStudent.getName());
            System.out.println("Enrolment: " + currentStudent.getEnrolment());

    }

    public void showGrades() {
        for (StudentExam currentStudent : studentExamList) {
            printStudentsData(currentStudent);
            System.out.println("Grade: " + String.format("%.1f", currentStudent.score()));
            System.out.println();
        }
    }

}
