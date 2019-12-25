package frc.robot;

/* Imports */

public class DriveBase implements RobotWrapper {

    /**
     * Constant variables
     */

    /**
     * Object declarations
     */
    
    /**
     * Non-constant variables
     */
    public double[][] currentRawControllerAxis;   //Stores current controller axis values.
    public boolean[][] currentRawControllerButtons;   //Stores current controller button values.

    /**
     * A set of enums to describe what style of drive system is being used.
     */
    private enum DriveType{
        TANK, //...
    }

    DriveType Drive;

    public void init(RunMode mode){

    }

    /**
     * Custom init function to set both RunMode and DriveType
     * @param mode
     * @param type
     */
    public void init(RunMode mode, DriveType type){
        Drive = type;   //Initialize Drivetype enum as [type].
        SetDrive();    //Set DriveType to given configuration
    }

    public void update(RunMode mode) {
        
        /**
         * Updates currentController...[][] values
         */
        currentRawControllerAxis = GetRawControllerAxis();
        currentRawControllerButtons = GetRawControllerButtons();

        /**
         * Set motors with correct type.
         */
        SetDrive();
    }

    public void reset() {
        
    }
    
    /**
     * A switch statement to configure drive train.
     * @param type
     */
    private void SetDrive(){
        switch(Drive){
            case TANK:
                /**
                 * Set up Tank Drive mode here.
                 */
                double[][] finalTankAxis = {{0},{0}} /* Calculate input */;
                boolean[][] finalTankButtons = currentRawControllerButtons;
                SetMotors(finalTankAxis, finalTankButtons);

            /**
             * Add other DriveType cases here.
             */
            
            default: 
                System.out.println("No DriveType set");
        }
    }

    /**
     * Returns a multidimensional array of double controller axis.
     */
    private double[][] GetRawControllerAxis(){
       /**
        * Array for storing controller values.
        * Axis array {a,a,a} --> xyz axis format.
        */
       double[] rawAxisL = {0};
       double[] rawAxisR = {0};
       
       //Add new array per new controller.
       
       double[][] rawControllerAxis = {rawAxisL, rawAxisR};    //Packages all axis arrays.

       return(rawControllerAxis);
    }

    /**
     * Returns a multidimensional array of boolean controller buttons.
     */
    private boolean[][] GetRawControllerButtons(){
        
        /**
         * Array for storing button values.
         * Button array {0,1,2,...} --> ascending button number format.
         */
        boolean[] rawButtonL = {false};
        boolean[] rawButtonR = {false};

        //Add new array per new conroller.

        boolean[][] rawControllerButtons = {rawButtonL, rawButtonR};

        return(rawControllerButtons);  //Packages all button arrays.
    }

    /**
     * Take a multidimensional array of raw controller data (increase dimensions with each extra motor).
     */
    private void SetMotors(double[][] axisData, boolean[][] buttonData){
        /**
         * Set motors
         * set drive type
         */
    }
}