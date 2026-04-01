import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            checkStrength(password);
        }
    }

    public static void checkStrength(String password) {
        int length = password.length();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        int score = 0;

        if (length >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        System.out.println("\nPassword Analysis:");
        
        if (score <= 2) {
            System.out.println("Strength: WEAK ❌");
        } else if (score == 3 || score == 4) {
            System.out.println("Strength: MEDIUM ⚠️");
        } else {
            System.out.println("Strength: STRONG ✅");
        }

        // Feedback
        if (length < 8)
            System.out.println("- Use at least 8 characters");
        if (!hasUpper)
            System.out.println("- Add uppercase letters");
        if (!hasLower)
            System.out.println("- Add lowercase letters");
        if (!hasDigit)
            System.out.println("- Include numbers");
        if (!hasSpecial)
            System.out.println("- Add special characters (!@#$%^&*)");
    }
}