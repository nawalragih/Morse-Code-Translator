import java.util.Scanner;

public class MorseCode {

    public static void printMenu() {
        System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.");
        System.out.println("Please, select one of the below options:");
        System.out.println("*** Enter 't' for encoding text");
        System.out.println("*** Enter 'm' for decoding morse code");
        System.out.println("*** Enter 'e' to exit the program.");
    }

    public static String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase();

        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "   "};

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if (current == letters[j]) {
                    morseCode.append(code[j]).append(" ");
                    break;
                }
            }
        }
        return morseCode.toString().trim();
    }


    public static String decodeMorse(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split("   ");

        // Iterate over each word
        for (String word : words) {
            String[] letters = word.trim().split(" ");
            for (String letter : letters) {
                char ch = decodeLetter(letter);
                text.append(ch);
            }
            text.append(" ");
        }

        return text.toString().trim();
    }

    public static char decodeLetter(String morseLetter) {
        switch (morseLetter) {
            case ".-":
                return 'A';
            case "-...":
                return 'B';
            case "-.-.":
                return 'C';
            case "-..":
                return 'D';
            case ".":
                return 'E';
            case "..-.":
                return 'F';
            case "--.":
                return 'G';
            case "....":
                return 'H';
            case "..":
                return 'I';
            case ".---":
                return 'J';
            case "-.-":
                return 'K';
            case ".-..":
                return 'L';
            case "--":
                return 'M';
            case "-.":
                return 'N';
            case "---":
                return 'O';
            case ".--.":
                return 'P';
            case "--.-":
                return 'Q';
            case ".-.":
                return 'R';
            case "...":
                return 'S';
            case "-":
                return 'T';
            case "..-":
                return 'U';
            case "...-":
                return 'V';
            case ".--":
                return 'W';
            case "-..-":
                return 'X';
            case "-.--":
                return 'Y';
            case "--..":
                return 'Z';
            case ".----":
                return '1';
            case "..---":
                return '2';
            case "...--":
                return '3';
            case "....-":
                return '4';
            case ".....":
                return '5';
            case "-....":
                return '6';
            case "--...":
                return '7';
            case "---..":
                return '8';
            case "----.":
                return '9';
            case "-----":
                return '0';
            default:
                return ' '; 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String options;

        do {
            printMenu();
            options = scanner.nextLine();

            switch (options.toLowerCase()) {
                case "t":
                    System.out.println("Please enter a phrase:");
                    String text = scanner.nextLine();
                    System.out.println("MorseCode:");
                    System.out.println(textToMorse(text));
                    break;
                case "m":
                    System.out.println("Please enter a Morse code:");
                    String morse = scanner.nextLine();
                    System.out.println("Normal Text:");
                    System.out.println(decodeMorse(morse));
                    break;
                case "e":
                    System.out.println("End of program!");
                    break;
                default:
                    System.out.println("***invalid option***");
                    System.out.println("Please enter a valid option:");
            }
        } while (!options.equalsIgnoreCase("e"));

        scanner.close();
    }
}
