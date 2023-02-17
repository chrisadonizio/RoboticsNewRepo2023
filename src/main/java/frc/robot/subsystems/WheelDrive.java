package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class WheelDrive extends SubsystemBase{
private Talon angleMotor;
private PWMSparkMax speedMotor;
private final double MAX_VOLTS = 4.95;

private PIDController pidController2;
public WheelDrive (int speedMotor, int angleMotor) {
    this.angleMotor = new Talon (angleMotor);
    this.speedMotor = new PWMSparkMax (speedMotor);
    // pidController2 = new PIDController (1, 0, 0, angleMotor.getEncoder(), this.angleMotor);
    // pidController2.setOutputRange (-1, 1);
    // pidController2.setContinuous ();
    // pidController2.enable ();
}
public void drive (double speed, double angle) {
    speedMotor.set (speed);

    // double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
    // if (setpoint < 0) {
    //     setpoint = MAX_VOLTS + setpoint;
    // }
    // if (setpoint > MAX_VOLTS) {
    //     setpoint = setpoint - MAX_VOLTS;
    // }

    // pidController2.setSetpoint (setpoint);
}
}