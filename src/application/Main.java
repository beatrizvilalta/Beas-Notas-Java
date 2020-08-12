package application;

import entities.Exam;
import entities.StudentExam;
import entities.Teacher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello teacher!");
        System.out.println("First step: tell me about the exam.");
        System.out.println();
        System.out.print("Enter the number of questions: ");
        int numberOfQuestions = sc.nextInt();
        System.out.print("Enter the overall score: ");
        double overallScore = sc.nextDouble();
        clearBuffer(sc);

        Exam exam = new Exam(numberOfQuestions, overallScore);
        System.out.println();
        System.out.printf("Points for each question: %.1f%n", exam.pointsForEachQuestion());
        System.out.println();

        System.out.println("Enter the answer for each question: ");

        for (int i = 0; i < numberOfQuestions; i++){
            System.out.print((i+1) + ") ");
            String answer = sc.nextLine();
            exam.addAnswer(answer);
        }
        System.out.println();
        System.out.println("Second step: register your students exam.");
        System.out.println();
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        clearBuffer(sc);

        Teacher teacher = new Teacher(exam, numberOfStudents);

        System.out.println("Enter the students data: ");
        for (int i = 0; i < numberOfStudents; i ++) {
            System.out.print("Enter the name of student number #" + (i+1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter the student enrolment: ");
            int enrolment = sc.nextInt();
            clearBuffer(sc);
            StudentExam studentExam = new StudentExam(numberOfQuestions, overallScore, name, enrolment);
            teacher.addStudentExams(studentExam);

            System.out.println("Students answers: ");

            for (int j = 0; j < numberOfQuestions; j++){
                System.out.print((j+1) + ") ");
                String studentAnswer = sc.nextLine();
                studentExam.addAnswer(studentAnswer);
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("Check the answer key: ");
        //GABARITO
        exam.printAnswerKey();
        System.out.println();

        //Resposta dos alunos
        System.out.println("Check the students answer: ");
        teacher.calculateNumberOfCorrectAnswers();

        // mostrar notas








    }

    private static void clearBuffer(Scanner sc) {
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
    }
}
