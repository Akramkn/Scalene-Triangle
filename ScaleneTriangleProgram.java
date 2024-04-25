import java.util.Scanner;

public class ScaleneTriangleProgram {

    public static boolean isScalene(double side1, double side2, double side3) {
        return side1 != side2 && side1 != side3 && side2 != side3;
    }

    public static double[] calculateAngles(double side1, double side2, double side3) {
        double angle1 = Math.acos((Math.pow(side2, 2) + Math.pow(side3, 2) - Math.pow(side1, 2)) / (2 * side2 * side3));
        double angle2 = Math.acos((Math.pow(side1, 2) + Math.pow(side3, 2) - Math.pow(side2, 2)) / (2 * side1 * side3));
        double angle3 = Math.acos((Math.pow(side1, 2) + Math.pow(side2, 2) - Math.pow(side3, 2)) / (2 * side1 * side2));

        // Convert radians to degrees
        double angle1Deg = Math.toDegrees(angle1);
        double angle2Deg = Math.toDegrees(angle2);
        double angle3Deg = Math.toDegrees(angle3);

        return new double[]{angle1Deg, angle2Deg, angle3Deg};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of side 1: ");
        double side1 = scanner.nextDouble();

        System.out.println("Enter the length of side 2: ");
        double side2 = scanner.nextDouble();

        System.out.println("Enter the length of side 3: ");
        double side3 = scanner.nextDouble();

        scanner.close(); // Close the scanner to avoid resource leaks

        if (isScalene(side1, side2, side3)) {
            System.out.println("The triangle is scalene.");

            double[] angles = calculateAngles(side1, side2, side3);

            System.out.println("Angle 1: " + angles[0] + " degrees");
            System.out.println("Angle 2: " + angles[1] + " degrees");
            System.out.println("Angle 3: " + angles[2] + " degrees");

            // Verify that the angles add up to 180 degrees
            double totalAngle = angles[0] + angles[1] + angles[2];
            System.out.println("Total: " + totalAngle + " degrees");
        } else {
            System.out.println("The triangle is not scalene.");
        }
    }
}
