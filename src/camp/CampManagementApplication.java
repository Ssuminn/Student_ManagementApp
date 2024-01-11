package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE));
        ScoreStore = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException, IOException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동... ");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();

        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName); // 수강생 인스턴스 생성 예시 코드
        // 기능 구현
        System.out.println("---필수 과목 등록---");
        System.out.println("필수 과목은 최소 3개 이상 등록되어야 합니다!");
        System.out.println("필수 과목 목록:\n");

        for(Subject subject : subjectStore){
            if(subject.getSubjectType().equals(SUBJECT_TYPE_MANDATORY)){
                System.out.println(subject.getSubjectId() + ". " + subject.getSubjectName());
                System.out.println("등록하시겠습니까? (1 : 등록, 0 : 등록 X)");
                int input = sc.nextInt();
                if(input == 1){
                    student.enrollMandatorySubject(subject);
//                    System.out.println("수강생의 해당 과목 점수를 입력해주세요:");
                    // 점수 등록 메서드 호출

                    System.out.println(subject.getSubjectName() + " 등록 완료\n");
                }
            }
        }
        if (student.getEnrolledMandatorySubjects().size() < 3) {
            System.out.println("오류: 최소 3개의 필수 과목이 등록되어야 합니다. 수강생 등록 실패!\n");
            return;
        }
        System.out.println("---선택 과목 등록---");
        System.out.println("선택 과목은 최소 2개 이상 등록되어야 합니다!");
        System.out.println("선택 과목 목록:");

        for(Subject subject : subjectStore){
            if(subject.getSubjectType().equals(SUBJECT_TYPE_CHOICE)){
                System.out.println(subject.getSubjectId() + ". " + subject.getSubjectName());
                System.out.println("등록하시겠습니까? (1 : 등록, 0 : 등록 X");
                int input = sc.nextInt();
                if(input == 1){
                    student.enrollOptionalSubject(subject);
//                    System.out.println("수강생의 해당 과목 점수를 입력해주세요:");
                    // 점수 등록 메서드 호출

                    System.out.println(subject.getSubjectName() + " 등록 완료");
                }
            }
        }
        if (student.getEnrolledMandatorySubjects().size() < 2) {
            System.out.println("오류: 최소 2개의 선택 과목이 등록되어야 합니다. 수강생 등록 실패!\n");
            return;
        }
        studentStore.add(student);
//        System.out.println(studentStore.get(0).toString());

        System.out.println("수강생 등록 성공!\n");
//        System.out.println("등록된 수강생 정보:");
//        for (Student registeredStudent : studentStore) {
//            System.out.println("학생 ID: " + registeredStudent.getStudentId());
//            System.out.println("학생 이름: " + registeredStudent.getStudentName());
//            System.out.println("등록된 필수 과목:");
//            for (Subject mandatorySubject : registeredStudent.getEnrolledMandatorySubjects()) {
//                System.out.println(" - " + mandatorySubject.getSubjectName());
//                System.out.println("점수 : ");
//                // 특정 과목 점수 조회 메서드 호출
//
//            }
//            System.out.println("등록된 선택 과목:");
//            for (Subject optionalSubject : registeredStudent.getEnrolledOptionalSubjects()) {
//                System.out.println(" - " + optionalSubject.getSubjectName());
//                System.out.println("점수 : ");
//                // 특정 과목 점수 조회 메서드 호출
//            }
//          수강생 정보 조회 기능(디버깅 용)
            System.out.println("----------------------------");
        }



    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        // 기능 구현
        System.out.println("\n수강생 목록 조회 성공!");
    }

    private static void displayScoreView() throws IOException {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static Student getStudentId() throws IOException {
        System.out.println("\n관리할 수강생의 번호를 입력하시오...");
        System.out.print("입력:");
        String studentId = br.readLine();
        Student s = null;
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                s = student;
            }
        }
        if (s == null) {
            System.out.println("해당 학생이 존재하지 않습니다.");
            return getStudentId();
        } else {
            return s;
        }
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() throws IOException {
        Student studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        // 기능 구현
        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() throws IOException {
        Student studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() throws IOException {
        Student studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다...");
        // 기능 구현
        System.out.println("\n등급 조회 성공!");
    }

}

