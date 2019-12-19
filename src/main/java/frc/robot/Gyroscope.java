package frc.robot;

/* Imports */

public class Gyroscope {
    /*
    * Create a new instance of the BNO055 class using euler vectors to read data.
    * This instance of the class will output vector directions in degrees for a range of all real numbers.
    */
    public static BNO055 imu = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);

    /**
     * The angle offset value for the current instance of the gyroscope class.
     * This value is reset to the current imu heading value whenever the reset method is run.
     */
	private double angleOffset;

	/**
	 * Constructs a new Gyroscope object.
	 */
	public Gyroscope()
	{
		reset();
	}

	/**
	 * Returns the heading in relation to the offset.
	 * @return
	 */
	public double getHeading()
	{
		return normalizeHeadingVal(getRawHeading() - angleOffset);
	}

	/**
	 * Resets the angle offset to the current heading.
	 */
	public void reset()
	{
		// Set angleOffset to the raw heading of the gyro.
		angleOffset = getRawHeading();

		// Check if the angle offset is 360 degrees.
        if (angleOffset == 360.0)
        {
			angleOffset = 0;    // If so, set angleOffset to 0. This accounts for a problem  previously seen on the field.
		}
	}

	/**
	 * Gets the normalized heading of the gyroscope without taking the angle offset into account.
	 * @return
	 */
	public double getRawHeading()
	{
		return normalizeHeadingVal(imu.getVector()[0]);
	}
	
	/**
	 * Returns the angle offset.
	 * @return
	 */
	public double getOffset()
	{
		return angleOffset;
	}

	/**
	 * Normalizes a heading value to the range of (-180, 180] degrees.
	 * @return
	 */
	private double normalizeHeadingVal(double heading)
	{
        heading = heading % 360;    // Set the gyroscope heading value to the remainder of its current value divided by 360.
        
        if (heading > 180.0)    // Check if the remainder of the given heading and 360 is greater than 180.
        {
			heading = heading - 360;    // If so, set the heading to a negative value greater than -180.
		}

        else if (heading <= -180.0) // Otherwise, check if the opposite case is true.
        {
			heading = heading + 360.0;  // If so, set the heading to a positive number less than 180.
		}

		return heading; // Return the new, normalized heading.
	}
}