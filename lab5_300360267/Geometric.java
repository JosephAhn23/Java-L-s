public class Geometric extends AbstractSeries {

    // instance variables
    private int termNumber=0;
    private double firstTerm=1;
    private double commonRatio=.5;
    public double next() {
        termNumber++;
        return firstTerm*Math.pow(commonRatio,termNumber-1);
    }
}