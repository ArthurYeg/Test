import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println(textModifier());
    }

    public static String textModifier() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();


        StringBuilder noExtraSpaces = new StringBuilder();
        boolean inSpaces = false;
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                if (!inSpaces) {
                    noExtraSpaces.append(c);
                }
                inSpaces = true;
            } else {
                noExtraSpaces.append(c);
                inSpaces = false;
            }
        }
        StringBuilder swappedText = new StringBuilder();
        for (int i = 0; i < noExtraSpaces.length(); i++) {
            if (noExtraSpaces.charAt(i) == '-' && i > 0 && i < noExtraSpaces.length() - 1) {
                swappedText.setCharAt(swappedText.length() - 1, noExtraSpaces.charAt(i + 1));
                swappedText.append(noExtraSpaces.charAt(i - 1));
                i++;
            } else {
                swappedText.append(noExtraSpaces.charAt(i));
            }
        }
        String replacedText = swappedText.toString().replace('+', '!');
        StringBuilder finalText = new StringBuilder();
        int digitSum = 0;
        for (char c : replacedText.toCharArray()) {
            if (Character.isDigit(c)) {
                digitSum += Character.getNumericValue(c);
            } else {
                finalText.append(c);
            }
        }
        if (digitSum > 0) {
            finalText.append(' ').append(digitSum);
        }
        return finalText.toString();
    }
}
