// aidlInterface.aidl
package SepratePackage;

// Declare any non-default types here with import statements

interface aidlInterface {
//    int CalculateData(int firstValue, int secondValue, int operationToPerform);
 int add(in int x, in int y);
   int subtract(in int x, in int y);
   int multiply(in int x, in int y);
    int division(in int x, in int y);
      int modulus(in int x, in int y);
      int power(in int x, in int y);

}