// StudentGrade.java
public class StudentGrade {
    public boolean isPassing(int score) {
        return score >= 60;
    }
    
    public String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
}