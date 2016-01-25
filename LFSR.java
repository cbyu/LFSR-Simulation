public class LFSR {

    public static void main(String[] args) {

            // initial fill
            boolean[] a = {
                    false, true, false, false,
                    false, true, false, true,
            };

            System.out.println("This is initial seed A: 01000101\n");

            boolean[] b = {
                    true, true, true, false,
                    false, false, false, true,
            };

            System.out.println("This is initial seed B: 11100001\n");

            boolean[] c = {
                    true, true, true, true,
                    false, false ,false, false,
            };

            System.out.println("This is initial seed C: 11110000\n");


            int N = a.length;                     // length of register
            int TAP = 4;                          // tap position

           //storage for our seeds
            String aArray = "";
            String bArray = "";
            String cArray = "";

            //Size of array we're using
            int TforA = Integer.parseInt("8");
            int TforB = Integer.parseInt("8");
            int TforC = Integer.parseInt("8");

        // Simulate operation of shift for seed A
        for (int t = 0; t < TforA; t++) {

            // Simulate one shift-register step.
            boolean next = (a[N-1] ^ a[TAP]);  // Compute next bit.

            for (int i = N-1; i > 0; i--)
                a[i] = a[i-1];                  // Shift one position.

            a[0] = next;                       // Put next bit on right end.

            if (next){
                System.out.print("1");
                aArray = aArray.concat("1");
            }
            else{
                System.out.print("0");
                aArray = aArray.concat("0");
            }
        }
        System.out.println(" This is the end result of seed A");;
        System.out.println();
        //End shift for seed A

        //Simulate operation of shift for seed B
        for (int t = 0; t < TforB; t++) {

            // Simulate one shift-register step.
            boolean next = (b[N-1] ^ b[TAP]);  // Compute next bit.

            for (int i = N-1; i > 0; i--)
                b[i] = b[i-1];                  // Shift one position.

            b[0] = next;                       // Put next bit on right end.

            if (next){
                System.out.print("1");
                bArray = bArray.concat("1");
            }
            else{
                System.out.print("0");
                bArray = bArray.concat("0");
            }
        }
        System.out.println(" This is the end result of seed B");
        System.out.println();
        //End shift for seed B

        //Simulate operation for seed C
        for (int t = 0; t < TforC; t++)
        {

            // Simulate one shift-register step.
            boolean next = (c[N-1] ^ c[TAP]);  // Compute next bit.

            for (int i = N-1; i > 0; i--)
                c[i] = c[i-1];                  // Shift one position.

            c[0] = next;                       // Put next bit on right end.
            if (next){
                System.out.print("1");
                cArray = cArray.concat("1");
            }
            else{
                System.out.print("0");
                cArray = cArray.concat("0");
            }

        }
        System.out.println(" This is the end result of seed C");
        System.out.println();
        //End shift for seed C

        //storage for integer value of final seeds
        int aFinal = Integer.parseInt(aArray);
        int bFinal = Integer.parseInt(bArray);
        int cFinal = Integer.parseInt(cArray);

        System.out.println("this is final number for the final seeds: " + aFinal + " " + bArray + " " + cArray);

        //perform bitwise XOR for all three seeds
        int finalLFSR = aFinal ^ bFinal ^ cFinal;

       //convert the operated number into binary
        String concatFinal = Integer.toBinaryString(finalLFSR);

        //take the first 8 digits of the binary string as our final seed
        System.out.println(concatFinal.substring(0,8));

    }//End main
}//End class

