package camp.model;

import java.util.ArrayList;
import java.util.Map;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectId;

    private  String subjectName;
    private ArrayList<String> gradeList;
    private ArrayList<Integer> scoreList;

    public Score(String studentId, String subjectId, String subjectName) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.gradeList = new ArrayList<String>();
        this.scoreList = new ArrayList<Integer>();
    }
    public String getScoreId() {
        return scoreId;
    }



    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }



    public String getStudentId() {
        return studentId;
    }



    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }



    public String getSubjectId() {
        return subjectId;
    }



    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectId = subjectName;
    }


    public ArrayList<String> getGradeList() {
        return gradeList;
    }



    public void setGradeList(ArrayList<String> gradeList) {
        this.gradeList = gradeList;
    }



    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }



    public void setScoreList(ArrayList<Integer> scoreList) {
        this.scoreList = scoreList;
    }
}