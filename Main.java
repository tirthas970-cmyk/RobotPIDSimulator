public class Main {
    public static void main(String[] args) {

        final double dT = 0.02;
        final double threshold = 0.5;

        //testing it out
        Robot robot = new Robot(0, 10);


        PIDController pidController = new PIDController(0.5, 0.1, 0.4);

        double target = 200;

        for (int i = 0; i <= 1500; i++) {
            double output = pidController.calculate(target, robot.getPosition(), dT);

            robot.update(output, dT);

            System.out.printf("Step: %d | Position: %.2f | Error: %.2f | Output: %.2f%n",
                i,
                robot.getPosition(),
                target - robot.getPosition(),
                output);
            
            if (Math.abs((target - (robot.getPosition()))) < threshold) {
                break;
            }

        }
    }
    
}
