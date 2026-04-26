public class Robot {

    //fields:

    private double position; //current location of the robot
    private double velocity;
    private double maxVelocity; 

    public Robot(double initialPosition, double maxVelocity) {
        this.position = initialPosition;
        this.maxVelocity = maxVelocity;
    }

    /* updates robot positon based on desired movement (controlOutput)
       dT is 20 ms; represents the time 
    */
    public void update(double controlOutput, double dT) {

        if (controlOutput > maxVelocity) {
            controlOutput = maxVelocity;
        }
        else if (controlOutput < -maxVelocity) {
            controlOutput = -maxVelocity;
        }

        velocity = controlOutput;

        this.position += velocity * dT;

    }

    public double getPosition() {
        return position;
        
    }

}