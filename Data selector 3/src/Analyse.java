/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jackg
 */
public class Analyse {

    double correlation; // declaring variable double 
    double sumOfXY = 0; // declaring variable double as 0
    double sumOfX2 = 0; // declaring variable double as 0
    double sumOfY2 = 0; // declaring variable double as 0
    double sumOfX = 0; // declaring variable double as 0
    double sumOfY = 0; // declaring variable double as 0
    int numOfSamples = 0; // declaring variable double as 0

    public double Correlation(double correlation, double sumOfXY, double sumOfX2, double sumOfY2, double sumOfX, double sumOfY, int numOfSamples) { // Correlation method with double parameters
        this.correlation = correlation; // assigning variable to first parameter 
        this.sumOfXY = sumOfXY; // assigning variable to first parameter 
        this.sumOfX2 = sumOfX2; // assigning variable to second parameter 
        this.sumOfY2 = sumOfY2; // assigning variable to third parameter 
        this.sumOfX = sumOfX; // assigning variable to fourth parameter 
        this.sumOfY = sumOfY; // assigning variable to fifth parameter 
        this.numOfSamples = numOfSamples; // assigning sixth to first parameter 

        //task 2
        correlation = numOfSamples * sumOfXY; // doing first task of math sum for correlation. numbers of rows times the sum of XY

        //task 3
        double secondSum = sumOfX * sumOfY; // creating double variable and doing third task. sum of X times sum of Y

        //task 4
        correlation = correlation - secondSum; // Task 2 minus task 3 

        //task 5
        secondSum = numOfSamples * sumOfX2; //task 5. number of rows times sum of X squared

        //task 6
        double thirdSum = sumOfX * sumOfX; // task 6. creating another double variable. Sum of x times sum of x. (Squaring it)

        //task 7
        secondSum = secondSum - thirdSum; // task 7. Task 5 minus task 6. 

        //task 8
        thirdSum = numOfSamples * sumOfY2; // task 8. number of rows times sum of Y squared.

        //task 9
        double fourthSum = sumOfY * sumOfY; // Task 9. Creating another double variable. Sum of Y times sum of Y (squaring)

        //task 10
        thirdSum = thirdSum - fourthSum; // Task 10. Minus task 8 by task 9.

        //task 11
        secondSum = secondSum * thirdSum; // Task 11. Times task 7 by task 10
        // task 12 
        secondSum = Math.sqrt(secondSum); // task 12. Square root task 11

        //task 13
        correlation = correlation / secondSum; // task 13. Task 4 divide by task 12. 
        return correlation; // return the total value (correlation)
    }
}
