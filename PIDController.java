public class PIDController {

    //Fields:

    //these 3 are constants

    /* *kP: reacts to current error
       *kI: reacts to accumulated error
       *kD: reacts to how fast error is changing 
     */
    private double kP; 
    private double kI;
    private double kD;

    private double previousError = 0; //no previous error yet
    private double integral = 0;  // no accumalted error yet

    //Contstructor
    public PIDController(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    /* *setpoint = target position
        *current = current position
        *dT = time (20 ms)
     */
    //purpose is to check how much the robot should move to reduce distance to target
    public double calculate(double setPoint, double current, double dT) {
        double error = setPoint - current;

        integral += error * dT;

        //meaures how fast error changes
        double derivative = (error - previousError)/dT;

        previousError = error;

        return (kP * error) + (kI * integral) + (kD * derivative);


    }




}