import java.util.Scanner;


public class Caesar 
{
    private int shiftNum;
    private String text;

    public Caesar(String textToShift, int theShiftNum)
    {
        text = textToShift;
        shiftNum = theShiftNum;
    }

    public String iCypherTextCaller()
    {
        String cyphered = "";

        if(shiftNum > 0)
        
        {
            cyphered = iForwardCypher();
        }
        else
        {
            cyphered = iBackwardCypher();
        }

        return cyphered; 
    }

    public String iForwardCypher()
    {
        String forwardCypher = "";

        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"; //should fix the issue of the to much shift over the stuff

        String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"; // same as ^ but with uppercase

        if(shiftNum > 26) // if they put in a massive shiftNum, this condenses it.
        {
            shiftNum %= 26;
        }



        for(int i = 0; i < text.length(); i++)
        {
            String letter = text.substring(i, i + 1); //String transveral making it a String
            char character = text.charAt(i);          //String transversal as a char
            if(Character.isLowerCase(character))      //checks if current character is lowerCase    
            {
                int indexL = lowerCaseAlphabet.indexOf(character);      //finds the index of current character in lower case alphabet
                String charof = "" + lowerCaseAlphabet.charAt(indexL);  // idk honestly

                String shiftedChar = lowerCaseAlphabet.substring(indexL + shiftNum, indexL + shiftNum + 1); // IMPORTANT shifted 
                forwardCypher += shiftedChar;
            }
            if(Character.isUpperCase(character))
            {
                int indexU = upperCaseAlphabet.indexOf(character);      //finds the index of current character in lower case alphabet
                String charofU = "" + upperCaseAlphabet.charAt(indexU);  // idk honestly

                String shiftedCharU = upperCaseAlphabet.substring(indexU + shiftNum, indexU + shiftNum + 1); // IMPORTANT shifted 
                forwardCypher += shiftedCharU;
            }
            
            if((lowerCaseAlphabet.indexOf(letter) == -1) && (upperCaseAlphabet.indexOf(letter) == -1))
            {
                forwardCypher += letter;
            }
        }

        return forwardCypher;
    }

    public String iBackwardCypher()
    {
        String backCypher = "";

        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"; //should fix the issue of the to much shift over the stuff

        String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"; // same as ^ but with uppercase


        while(shiftNum < 0)
        {
            shiftNum += 26;
        }

        for (int i = 0; i < text.length(); i++) 
        {
            String letter = text.substring(i, i + 1); //String transveral making it a String
            char character = text.charAt(i);          //String transversal as a char

            /* 
            if(Character.isLowerCase(character))
            {
                int indexL = lowerCaseAlphabet.indexOf(character) + 26;      //finds the index of current character in lower case alphabet
                String charof = "" + lowerCaseAlphabet.charAt(indexL);  // idk honestly

               //String shiftedCharL = text.substring(indexL - shiftNum,indexL - shiftNum + 1);
                backCypher += shiftedCharL;


            }

            if(Character.isUpperCase(character))
            {
                int indexU = upperCaseAlphabet.indexOf(character) + 26;      //finds the index of current character in lower case alphabet
                String charof = "" + upperCaseAlphabet.charAt(indexU);  // idk honestly

                String shiftedCharU = text.substring(indexU - shiftNum,indexU - shiftNum + 1);
                backCypher += shiftedCharU;
            }
            


            //do more
            if((lowerCaseAlphabet.indexOf(letter) == -1) && (upperCaseAlphabet.indexOf(letter) == -1))
            {
                backCypher += character;
            }
            */

            if(Character.isLowerCase(character))      //checks if current character is lowerCase    
            {
                int indexL = lowerCaseAlphabet.indexOf(character);      //finds the index of current character in lower case alphabet
                String charof = "" + lowerCaseAlphabet.charAt(indexL);  // idk honestly

                String shiftedChar = lowerCaseAlphabet.substring(indexL + shiftNum, indexL + shiftNum + 1); // IMPORTANT shifted 
                backCypher += shiftedChar;
            }
            if(Character.isUpperCase(character))
            {
                int indexU = upperCaseAlphabet.indexOf(character);      //finds the index of current character in lower case alphabet
                String charofU = "" + upperCaseAlphabet.charAt(indexU);  // idk honestly

                String shiftedCharU = upperCaseAlphabet.substring(indexU + shiftNum, indexU + shiftNum + 1); // IMPORTANT shifted 
                backCypher += shiftedCharU;
            }
            
            if((lowerCaseAlphabet.indexOf(letter) == -1) && (upperCaseAlphabet.indexOf(letter) == -1))
            {
                backCypher += letter;
            }

        }

        return backCypher;
    }
    public static void main(String[] args)
    {
        //Taking Inputs
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text u want to cipher:");
        String cypherText = input.nextLine();
        System.out.println("Enter the shift number & if u want it to be backward use a negative number:");
        int shiftNum = input.nextInt();
        
        //object creation
        Caesar cypher1 = new Caesar(cypherText, shiftNum);

        String cypheredString1 = cypher1.iCypherTextCaller();

        System.out.println("Your cypher text is: \"" + cypheredString1 +"\"");

        
    }

}