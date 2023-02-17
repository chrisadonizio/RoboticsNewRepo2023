
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveDrive extends SubsystemBase {
  public final double L = 10;
  public final double W = 10;
  private WheelDrive backRight;
  private WheelDrive backLeft;
  private WheelDrive frontRight;
  private WheelDrive frontLeft;

public SwerveDrive (WheelDrive backRight, WheelDrive backLeft, WheelDrive frontRight, WheelDrive frontLeft) {
    this.backRight = backRight;
    this.backLeft = backLeft;
    this.frontRight = frontRight;
    this.frontLeft = frontLeft;
}
  public void drive (double x1, double y1, double x2) {
    double r = Math.sqrt ((L * L) + (W * W));
    y1 *= -1;

    double a = x1 - x2 * (L / r);
    double b = x1 + x2 * (L / r);
    double c = y1 - x2 * (W / r);
    double d = y1 + x2 * (W / r);

    double backRightSpeed = Math.sqrt ((a * a) + (d * d));
    double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
    double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
    double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));

    double backRightAngle = Math.atan2 (a, d) / Math.PI;
    double backLeftAngle = Math.atan2 (a, c) / Math.PI;
    double frontRightAngle = Math.atan2 (b, d) / Math.PI;
    double frontLeftAngle = Math.atan2 (b, c) / Math.PI;
    
    backRight.drive (backRightSpeed, backRightAngle);
    backLeft.drive (backLeftSpeed, backLeftAngle);
    frontRight.drive (frontRightSpeed, frontRightAngle);
    frontLeft.drive (frontLeftSpeed, frontLeftAngle);
}
  /** Creates a new ExampleSubsystem. */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void stopALl(){
    backRight.drive (0, 0);
    backLeft.drive (0, 0);
    frontRight.drive (0, 0);
    frontLeft.drive (0, 0);
  }

  }

