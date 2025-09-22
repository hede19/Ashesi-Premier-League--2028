import java.util.*;
public class PlayerSelection {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);   // allow as to accept input from user

        // user inputs
        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter age: ");
        int age = input.nextInt();

        System.out.print("Enter jersey number: ");
        int jerseyNumber = input.nextInt();

        System.out.print("Enter height (in meters): ");
        double height = input.nextDouble();

        System.out.print("Enter weight (in pounds): ");
        double weight = input.nextDouble();

        // conversion from pound and meter to kilogram and centimeter respectively
        final double POUNDS_TO_KG = 0.45359237;  // 1 pound = 0.45359237Kg
        final int METER_TO_CM = 100;             // 1 meter = 100Cm

        // formula for conversion
        double weightKg = weight * POUNDS_TO_KG;
        double heightCm = height * METER_TO_CM;

        // rounding figures using casting
        int roundWeightKg = (int) (weightKg + 0.5);
        int roundHeightCm = (int) (heightCm + 0.5);

        // category grouping in terms of age
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }

        // position assign using jerseyNumbers( SWITCH APPROACH)
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Position not known";
        }
        // attackers identity by jersey number (logical operators OR=|| )
        boolean isAttacker = (jerseyNumber == 7 || jerseyNumber == 9 ||
                jerseyNumber == 10 || jerseyNumber == 11);

        // eligibility checking using age and weight (logical operator AND= &&)
        boolean isEligible = (age >= 18 && age <= 35 && weightKg < 90);

        // lineup decision (Nested If)
        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (weightKg < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench";
            }

            // final decision ( Ternary operators)
            String finalDecision = isEligible ? "Play" : "Rest";

            // print statements for everything\
            System.out.println("\n ---Player Report---");
            System.out.println("Player: " + name);
            System.out.println("Age: " + age + " (" + category + ")");
            System.out.println("Height: " + roundHeightCm + " cm");
            System.out.println("Weight: " + roundWeightKg + " kg");
            System.out.println("Jersey: " + jerseyNumber);
            System.out.println("Position: " + position);
            System.out.println("Attacker jersey: " + (isAttacker ? "Yes" : "No"));
            System.out.println("Eligibility: " + (isEligible ? "Eligible" : "Not Eligible"));
            System.out.println("Lineup Decision: " + lineupDecision);
            System.out.println("Final Decision: " + finalDecision);

            // --- FALL-THROUGH SWITCH DEMO ---
            System.out.println("\n--- Fall-Through Demo ---");
            switch (jerseyNumber) {
                case 2:
                    System.out.println("Defender");
                case 6:
                    System.out.println("Midfielder");
                case 7:
                    System.out.println("Winger");
                default:
                    System.out.println("Player position not known");
            }
            input.close();
        }
    }
}
