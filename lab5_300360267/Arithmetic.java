public class Arithmetic extends AbstractSeries {

    // instance variables
    private int termNumber = 0; 

    public double next() {
        termNumber++;
        return termNumber+(termNumber+1)/2;
    } 
}
