package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public class Drive extends CommandBase {
    public Drive(){
        addRequirements(Robot.m_swerveDrive);

    }
    @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_swerveDrive.drive(Constants.driverController.getRawAxis(1), Constants.driverController.getRawAxis(0),Constants.driverController.getRawAxis(4));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
        Robot.m_swerveDrive.stopALl();
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
