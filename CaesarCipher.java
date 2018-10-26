import java.util.Arrays;

class CaesarCipher{
    public static void main(String[] args) {

        if(validate(args[0])){
            String [] splitted = args[0].split(":");

            int key = Integer.valueOf(splitted[0]);
            String input = splitted[1];

            System.out.println(shiftFunction(key, input));

        }
    }
    /*
     * @param input is validated to obey the following conditions:
     * Can start with a negative or not
     * The integer given must be at least 1, and a maximum of a billion 
     * The string must be delimited by one semi-colon
     * The string can allow special characters
     * The string must be at least 1 in length - to a maximum of 200
     */
    public static boolean validate(String input){

        if(input.matches("-?[0-9]{1,1000000000}:[a-zA-Z0-9\\\\!\"#$%&()*+,./;<=>?@\\[\\]^_{|}~-]{1,200}")) return true;
        else return false;
    }

    
    public static String shiftFunction(int shiftKey, String input){

        int key = shiftKey;

        StringBuilder output = new StringBuilder();
        Character [] lowerArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Character [] upperArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Integer [] numberArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i = 0; i < input.length(); i++){

            if(Character.isDigit(input.charAt(i))){
                output.append(numberArray[(key + Arrays.asList(numberArray).indexOf(Character.getNumericValue(input.charAt(i)))) % 10]);
            }
            else if(Character.isUpperCase(input.charAt(i))){
                    output.append(upperArray[(key + Arrays.asList(upperArray).indexOf(input.charAt(i))) % 26]);  
            }
            else if(Character.isLowerCase(input.charAt(i))){
                output.append(lowerArray[(key + Arrays.asList(lowerArray).indexOf(input.charAt(i))) % 26]);  
            }
            else{
                output.append(input.charAt(i));    
            }

        }

    return output.toString();

    }
}