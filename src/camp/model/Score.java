package camp.model;

import java.util.ArrayList;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectId;
    private ArrayList<String> gradeList;// 등급저장
    private ArrayList<Integer> scoreList;// 점수저장
    
    public Score() {
		// TODO Auto-generated constructor stub
	}
    public Score(String seq) {
        this.scoreId = seq;
    }
    
    
    
    public Score(String studentId, String subjectId) {
		this.studentId = studentId;
		this.subjectId = subjectId;
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
