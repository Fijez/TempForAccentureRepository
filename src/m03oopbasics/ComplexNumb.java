package m03oopbasics;

public class ComplexNumb {

    double r;
    double i;

    @Override
    public String toString() {
        if (r != 0 && i != 0) {
            return r +" "+ i + "i";
        }
        else if(r == 0 && i == 0) {
            return String.valueOf(0);
        }
        else if (i == 0) {
            return Double.toString(r);
        }
        else {
            return i + "i";
        }
    }

    public static ComplexNumb sum(ComplexNumb cm1, ComplexNumb cm2) {
        double term1 = cm1.r + cm2.r;
       double term2 = cm1.i + cm2.i;
        return new ComplexNumb(term1, term2);
    }
    public static ComplexNumb subtr(ComplexNumb cm1, ComplexNumb cm2) {
        double term1 = cm1.r - cm2.r;
        double term2 = cm1.i - cm2.i;
        return new ComplexNumb(term1, term2);
    }
    public static ComplexNumb div(ComplexNumb cm1, ComplexNumb cm2) {
        double denom = Math.pow(cm2.r,2) + Math.pow(cm2.i, 2);
        if(denom == 0) {
            System.out.println("denominator = 0");
            return null;
        }
        double term1 = cm1.r*cm2.r + cm1.i*cm2.i;
        double term2 = cm1.i*cm2.r + cm1.r*cm2.i;
        return new ComplexNumb(term1/denom,term2/denom);
    }
    public static ComplexNumb mult(ComplexNumb cm1, ComplexNumb cm2) {
        double term1 = cm1.r*cm2.r - cm1.i*cm2.i;
        double term2 = cm1.r*cm2.i + cm2.r*cm1.i;
        return new ComplexNumb(term1, term2);
    }


    public double getR() {
        return r;
    }

    public double getI() {
        return i;
    }

    public ComplexNumb() {
        r = 0;
        i = 0;
    }

    public ComplexNumb(double r, double i) {
        this.r = r;
        this.i = i;
    }
}
