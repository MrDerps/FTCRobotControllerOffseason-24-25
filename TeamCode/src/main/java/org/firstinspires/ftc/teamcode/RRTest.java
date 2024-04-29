package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.Drive.MecanumDrive;

@Config
@Autonomous(name = "RR Test drive", group = "Autonomous")
public class RRTest extends LinearOpMode{
    Action trajectoryAction1;
    Action trajectoryAction2;
    Action trajectoryAction3;
    Action trajectoryActionCloseOut;
    Action trajectoryActionChosen;
    @Override
    public void runOpMode() {

        // TODO: Check Pose position to ensure it is correct
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, Math.toRadians(90)));

        trajectoryAction1 = drive.actionBuilder(drive.pose)
                // TODO: Change variables to be usd according to Jerry's field
                //.lineToYSplineHeading(33, Math.toRadians(0))
                //.waitSeconds(2)
                .setTangent(Math.toRadians(90))
                .lineToY(48)
                .setTangent(Math.toRadians(0))
                .lineToX(32)
                .strafeTo(new Vector2d(44.5, 30))
                .turn(Math.toRadians(180))
                .lineToX(47.5)
                .waitSeconds(3)
                .build();


        if (isStopRequested()) return;

        trajectoryActionChosen = trajectoryAction1;

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                )
        );
    }

}
