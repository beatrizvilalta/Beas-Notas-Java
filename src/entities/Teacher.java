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

        int result = 0;
        for (StudentExam currentStudentExam : studentExamList) {
            for (String currentStudentAnswer : currentStudentExam.getAnswer()){
                for (String currentAnswer : answerKey.getAnswer()) {
                    if (currentAnswer.equals(currentStudentAnswer)) {
                        result = result + 1;
                        currentStudentExam.setCorrectAnswer(result);
                    }
                }
            }

        }
    }

    public void printStudentsAnswer() {
        for (StudentExam currentStudent : studentExamList) {
            System.out.println("Name: " + currentStudent.getName());
            System.out.println("Enrolment: " + currentStudent.getEnrolment());
            currentStudent.printAnswerKey();
            System.out.println();
        }
    }
}
