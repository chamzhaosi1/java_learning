package exercise_1;

public class TestScores{
    private float[] scoresArray;

    TestScores(float[] scoresArray){
        this.scoresArray = scoresArray;
    }

    public float average() throws IllegalArgumentException{
        float total = 0;

        for (float d : scoresArray){
            if (d < 1 || d > 100){
                throw new IllegalArgumentException("Value: " + d + " is not acceptable!");
            }else {
                total += d;
            }
            
        }
        return total/scoresArray.length;
    }
    
    public static void main(String[] args) {
        float[] scores = {10.3f,10.5f,1002f};
        TestScores testScores = new TestScores(scores);

        try {
            System.out.println(testScores.average());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}