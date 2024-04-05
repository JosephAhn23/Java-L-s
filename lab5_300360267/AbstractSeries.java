public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        // implement the method
        if (k<0){
            throw new IllegalArgumentException("make k>0");
        }
        double[] result = new double[k];
        double sum=0;
        for (int i=0; i<k; i++){
            sum+=next();
            result[i]=sum;
        }
        return result;
    }

}