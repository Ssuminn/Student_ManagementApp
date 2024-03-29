package camp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private String studentState;
    private List<Subject> enrolledMandatorySubjects; // 수강생 등록시, 수강생이 신청한 필수 과목을 담음
    private List<Subject> enrolledOptionalSubjects; // 이건 선택 옵션
    private HashMap<String,Score> scores;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentState = "";
        this.enrolledMandatorySubjects = new ArrayList<>();
        this.enrolledOptionalSubjects = new ArrayList<>();
        this.scores = new HashMap<>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getEnrolledMandatorySubjects() {
        return enrolledMandatorySubjects;
    }

    public List<Subject> getEnrolledOptionalSubjects() {
        return enrolledOptionalSubjects;
    }

    public HashMap<String,Score> getScores() {
        return scores;
    }

    public void enrollMandatorySubject(Subject subject) { // 입력받은 수강생의 필수 과목 저장
        enrolledMandatorySubjects.add(subject);
    }

    public void enrollOptionalSubject(Subject subject) { // 입력받은 수강생의 선택 과목 저장
        enrolledOptionalSubjects.add(subject);
    }

    public void addScore(String key,Score score) { // 입력받은 수강생의 과목 점수 저장
        scores.put(key,score);
    }

    public void setStudentState(String studentState){
        this.studentState = studentState;
    }

    public String getStudentState(){
        return studentState;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}