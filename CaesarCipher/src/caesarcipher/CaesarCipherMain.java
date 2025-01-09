package caesarcipher;
import java.util.Scanner;

class CaesarCipherUtility {
    private Scanner scanner;

    public CaesarCipherUtility() {
        scanner = new Scanner(System.in);
    }

    public void questions() {
        System.out.print("Type 'encode' to encrypt, 'decode' to decrypt: ");
        String encodeOrDecode = scanner.nextLine();

        System.out.print("Enter the text: ");
        String originalText = scanner.nextLine();

        System.out.print("Enter the shift number: ");
        int shiftAmount = scanner.nextInt();
        scanner.nextLine();

        if (encodeOrDecode.equals("decode")) {
            shiftAmount *= -1;
        }

        String result = processText(originalText, shiftAmount);
        System.out.println("Here is the " + encodeOrDecode + "d result: " + result);

        System.out.print("Type 'yes' if you want to go again. Otherwise type 'no': ");
        String restart = scanner.nextLine();

        if (restart.equalsIgnoreCase("yes")) {
            questions();
        } else {
            System.out.println("Goodbye");
        }
    }

    public String processText(String text, int shift) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder outputText = new StringBuilder();
        text = text.toLowerCase();
        for (char letter : text.toCharArray()) {
            if (alphabet.indexOf(letter) != -1) {
                int shiftedPosition = (alphabet.indexOf(letter) + shift) % alphabet.length();
                if (shiftedPosition < 0) {
                    shiftedPosition += alphabet.length();
                }
                outputText.append(alphabet.charAt(shiftedPosition));
            } else {
                outputText.append(letter);
            }
        }

        return outputText.toString();
    }
}

public class CaesarCipherMain {
    public static void main(String[] args) {
        CaesarCipherUtility cipherUtility = new CaesarCipherUtility();
        cipherUtility.questions();
    }
}
