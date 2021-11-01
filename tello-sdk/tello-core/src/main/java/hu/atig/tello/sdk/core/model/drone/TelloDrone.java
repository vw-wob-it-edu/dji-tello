package hu.atig.tello.sdk.core.model.drone;

import hu.atig.tello.sdk.core.communication.DroneCommandExecutor;
import hu.atig.tello.sdk.core.communication.DroneCommandExecutorImpl;
import hu.atig.tello.sdk.core.model.command.BasicCommand;
import hu.atig.tello.sdk.core.model.command.Command;
import hu.atig.tello.sdk.core.model.command.ComplexCommand;
import hu.atig.tello.sdk.core.model.command.TelloCommandValues;

import java.util.logging.Logger;

/**
 * Represents the Tello onboardData.
 */
public class TelloDrone implements Drone {


    private static final Logger logger = Logger.getLogger(TelloDrone.class.getName());
    private final OnboardData onboardData;
    private final DroneCommandExecutor droneCommandExecutor;
    private TelloDrone drone;

    public TelloDrone() {
        onboardData = new TelloOnboardData();
        droneCommandExecutor = new DroneCommandExecutorImpl();
    }

    @Override
    public void connect() {
        boolean connectionSuccessful = droneCommandExecutor.connect();
        if (connectionSuccessful) {
            onboardData.setTelloConnection(ConnectionState.CONNECTED);
            logger.info("Connected!");
        }
    }

    @Override
    public void disconnect() {
        onboardData.setTelloConnection(ConnectionState.DISCONNECTED);
        droneCommandExecutor.disconnect();
        logger.info("Disconnected!");
    }

    @Override
    public void enterCommandMode() {
        Command command = new BasicCommand(TelloCommandValues.COMMAND_MODE);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Entering command mode successful");
        }
    }


    @Override
    public void takeOff() {
    	droneCommandExecutor.executeCommand(new BasicCommand(TelloCommandValues.TAKE_OFF));
    }

    @Override
    public void land() {
    	droneCommandExecutor.executeCommand(new BasicCommand(TelloCommandValues.LAND));
    }

    @Override
    public void doFlip(Flip flip) {    	
        droneCommandExecutor.executeCommand(new ComplexCommand<Flip>(TelloCommandValues.FLIP, flip));
    }

    @Override
    public void up(Integer elevation) {
        droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.UP, elevation));
    }
    
    @Override
    public void down(Integer elevation) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.DOWN, elevation));
    }
    
    @Override
    public void setSpeed(Integer speed) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.SPEED, speed));
    }

    @Override
    public void forward(Integer distance) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.FORWARD, distance));
    }

    @Override
    public void backward(Integer distance) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.BACKWARD, distance));
    }

    @Override
    public void right(Integer distance) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.RIGHT, distance));
    }

    @Override
    public void left(Integer distance) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.LEFT, distance));
    }

    @Override
    public void rotateRight(Integer angle) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.CW, angle));
    }

    @Override
    public void rotateLeft(Integer angle) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.CCW, angle));
    }
    
    @Override
    public void go(Integer x, Integer y, Integer z, Integer speed) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.GO, x, y, z, speed));
    }
    
    @Override
    public void curve(Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2, Integer speed) {
    	droneCommandExecutor.executeCommand(new ComplexCommand<Integer>(TelloCommandValues.CURVE, x1, y1, z1, x2, y2, z2, speed));
    }

    @Override
    public void refreshTelloOnBoarData() {
        onboardData.setSpeed(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_SPEED)));
        onboardData.setBattery(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_BATTERY)));
        onboardData.setFlyTime(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_FLY_TIME)));
        onboardData.setHeight(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_HEIGHT)));
        onboardData.setTemperature(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_TEMPERATURE)));
        onboardData.setAttitude(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_ATTITUDE_DATA)));
        onboardData.setBarometer(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_BAROMETER)));
        //onboardData.setAcc(telloCommunication
        //    .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_ACCELERATION)));
        onboardData.setTof(
                droneCommandExecutor.executeReadCommand(new BasicCommand(TelloCommandValues.TOF)));
    }

    @Override
    public void startVideoStream() {
        boolean executionSuccessful = droneCommandExecutor
                .executeCommand(new BasicCommand(TelloCommandValues.ENABLE_VIDEO_STREAM));
        if (executionSuccessful) {
            droneCommandExecutor.startVideoStream();
            logger.info("Video stream start command was executed successfully");
        }
    }

    @Override
    public void stopVideoStream() {
        boolean executionSuccessful = droneCommandExecutor
                .executeCommand(new BasicCommand(TelloCommandValues.DISABLE_VIDEO_STREAM));
        if (executionSuccessful) {
            droneCommandExecutor.stopVideoStream();
            logger.info("Video stream end command was executed successfully");
        }
    }
    
    @Override
    public void startStateStream() {
        droneCommandExecutor.startStateStream();
        logger.info("State stream started");
    }

    @Override
    public void stopStateStream() {
        droneCommandExecutor.stopStateStream();
        logger.info("State stream stopped");
    }

    public OnboardData getTelloDroneData() {
        return onboardData;
    }

}
