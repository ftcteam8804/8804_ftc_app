package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class Hardware8804Robot
{
    /* Public OpMode members. */
    public DcMotor  leftDriveMotor          = null;
    public DcMotor  rightDriveMotor         = null;
    public DcMotor  ballPickerMotor         = null;
    public DcMotor  ballTosserMotor         = null;
    public DcMotor  leftRackPinionMotor     = null;
    public DcMotor  rightRackPinionMotor    = null;
    public DcMotor  leftClawMotor           = null;
    public DcMotor  rightClawMotor          = null;
    //public DcMotor  armMotor    = null;
    //public Servo    leftClaw    = null;
    //public Servo    rightClaw   = null;

    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware8804Robot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDriveMotor          = hwMap.dcMotor.get("left_drive");
        rightDriveMotor         = hwMap.dcMotor.get("right_drive");
        ballPickerMotor         = hwMap.dcMotor.get("ball_picker");
        ballTosserMotor         = hwMap.dcMotor.get("ball_tosser");
        leftRackPinionMotor     = hwMap.dcMotor.get("left_rp");
        rightRackPinionMotor    = hwMap.dcMotor.get("right_rp");
        leftClawMotor           = hwMap.dcMotor.get("left_claw");
        rightClawMotor          = hwMap.dcMotor.get("right_claw");
        //armMotor    = hwMap.dcMotor.get("left_arm");
        leftDriveMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightDriveMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        ballPickerMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        ballTosserMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        leftRackPinionMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        rightRackPinionMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        leftClawMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        rightClawMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        leftDriveMotor.setPower(0);
        rightDriveMotor.setPower(0);
        ballPickerMotor.setPower(0);
        ballTosserMotor.setPower(0);
        leftRackPinionMotor.setPower(0);
        rightRackPinionMotor.setPower(0);
        leftClawMotor.setPower(0);
        rightClawMotor.setPower(0);
        //armMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ballPickerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ballTosserMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftRackPinionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRackPinionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftClawMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightClawMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
        //leftClaw = hwMap.servo.get("left_hand");
        //rightClaw = hwMap.servo.get("right_hand");
        //leftClaw.setPosition(MID_SERVO);
        //rightClaw.setPosition(MID_SERVO);
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

