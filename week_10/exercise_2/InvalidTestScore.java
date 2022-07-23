package exercise_2;

public class InvalidTestScore extends IllegalArgumentException{
    InvalidTestScore(String message){
        super(message);
    }

    public static void main(String[] args) {
        float[] scores = {-10.5f,10.5f,1002f};
        TestScores testScores = new TestScores(scores);

        try {
            System.out.println(testScores.average());
        } catch (InvalidTestScore ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}

class TestScores{
    private float[] scoresArray;

    TestScores(float[] scoresArray){
        this.scoresArray = scoresArray;
    }

    public float average() throws InvalidTestScore{
        float total = 0;

        for (float d : scoresArray){
            if (d < 1 || d > 100){
                throw new InvalidTestScore("Value: " + d + " is not acceptable!");
            }else {
                total += d;
            }
        }
        return total/scoresArray.length;
    }
}