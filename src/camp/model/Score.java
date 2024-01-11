package camp.model;

import java.util.ArrayList;
import java.util.Map;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectId;
    private ArrayList<String> gradeList;

    public Score(String seq) {
        this.scoreId = seq;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }
    
    

}
