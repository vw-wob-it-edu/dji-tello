package hu.atig.tello.sdk.core.model.drone;

public interface Drone {

    /**
     * Establishing connection to the Tello Drone.
     */
    void connect();

    /**
     * Disconnecting from the drone. If the drone is not landed yet, it will start an automatic
     * landing.
     */
    void disconnect();


    /**
     * Enter command mode. You can only execute commands after this call.
     */
    void enterCommandMode();

    /**
     * Taking off from the ground.
     */
    void takeOff();

    /**
     * Landing on the ground.
     */
    void land();

    /**
     * Doing a flip in the chosen direction.
     *
     * @param flip Type of the flip.
     */
    void doFlip(Flip flip);

    /**
     * Setting the drone's speed.
     *
     * @param speed Chosen speed.
     */
    void setSpeed(Integer speed);
    
    void up(Integer elevation);
    void down(Integer elevation);

    void forward(Integer distance);
    void backward(Integer distance);
    void right(Integer distance);
    void left(Integer distance);

    void rotateRight(Integer angle);
    void rotateLeft(Integer angle);
    
    void go(Integer x, Integer y, Integer z, Integer speed);
    void curve(Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2, Integer speed);

    void refreshTelloOnBoarData();

    void startVideoStream();
    void stopVideoStream();
    
    void startStateStream();
    void stopStateStream();
    

}
