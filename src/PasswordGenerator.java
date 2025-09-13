import java.util.Random;

//BACKEND PART AND WILL BE RESPONSIBLE TO GENERATE PASSWORD
public class PasswordGenerator {
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    private final Random random; // allows to generate a random no which will be used to randomly choose the characters

    public PasswordGenerator(){
        random = new Random();
    }
    public String generatePassword(int length, boolean uppercase, boolean lowercase, boolean numbers, boolean symbols){
        StringBuilder passwordBuilder = new StringBuilder();

        //STORES VALID CHARACTERS
        String validCharacters = "";
        if(uppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(lowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(numbers) validCharacters += NUMBERS;
        if(symbols) validCharacters += SPECIAL_SYMBOLS;

        //BUILD PASSWORD
        for(int i=0; i< length; i++){
            // FIRST ILL GENERATE A RANDOM INDEX
            int randomIndex = random.nextInt(validCharacters.length());

            // GET THE CHARACTER BASED ON THE RANDOM INDEX
            char randomChar = validCharacters.charAt(randomIndex);

            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }

}
