package com.company;
import java.util.Random;

public class Main {

    static int selPrimeP=0;
    static int selPrimeQ=0;
    static int N=0;
    static int phinN=0;

    public static void main(String[] args) {

        while(selPrimeP==0) {
            selPrimeP = generateRandomPrime();
        }
        while(selPrimeQ==0) {
            selPrimeQ = generateRandomPrime();
        }
        System.out.println("The primes P and Q are, " + selPrimeP+ " and " +selPrimeQ );

        /* Compute N and phi(N) */
        computeNAndPhiN();
        System.out.println("N and PhiN and Q are, " + N+ " and " +phinN );
	// write your code here

        computeE(phinN);
    }

   static int generateRandomPrime(){
        /* Generates a random number between the low number which
        is inclusive and the high number which is exclusive
         */
       Random r = new Random();
       int low = 2;
       int high = 16;
       int result = r.nextInt(high-low) + low;
       int resultPrime=0;

       for(int j=2;j<result;j++){
           if(result % j == 0){
               System.out.println("The result, " + result+ "is not a prime ");
               resultPrime = 0;
               break;

           }
           else if(j==result-1){
               System.out.println("The result, " + result+ "is a prime ");
               resultPrime = result;
           }
       }

       return resultPrime;
    }

    static void computeNAndPhiN() {
        N = selPrimeP * selPrimeQ;
        phinN = (selPrimeP-1) * (selPrimeQ-1);

    }

    static int computeE(int phinN) {

        int exponentE = 0;
        while (exponentE == 0) {

            exponentE = generateRandomE(phinN);
        }

        return exponentE;
    }

    /* Computes Random Integer exponent e, whereby gcd(e,phiNn = 1)
     */

    static int generateRandomE(int phinN) {
        int e = 0;
        Random r = new Random();
        int low = 2;
        int high = phinN;
        int resultE = r.nextInt(high-low) + low;
        int dividend=0;
        int divisor=0;

        dividend = phinN;
        divisor = resultE;
        int remainder=-1;

        System.out.println("PhiN, " +phinN +  "and Exponent e, "+ resultE + "");

      while(remainder!=1) {
            remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
            if(divisor==0){
                break;
            }
        }

        if(remainder==0){
            System.out.println("GCD between PhiN, " +phinN +  "and Exponent e, "+ resultE + " is not 1" );
            resultE = 0;
        }
        else if(remainder==1){
            System.out.println("GCD between PhiN, " +phinN +  "and Exponent e, "+ resultE + " is 1" );

        }
        return resultE;
    }

}
