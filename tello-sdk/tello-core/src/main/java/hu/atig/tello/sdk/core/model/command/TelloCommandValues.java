package hu.atig.tello.sdk.core.model.command;

/**
 * Commands for the DJI Tello drone. Source: https://github.com/grofattila/dji-tello/blob/experimental/Tello_SDK.pdf
 */
public class TelloCommandValues {

  /**
   * Enter command mode.
   */
  public static final String COMMAND_MODE = "command";

  /**
   * Auto takeoff.
   */
  public static final String TAKE_OFF = "takeoff";

  /**
   * Auto landing.
   */
  public static final String LAND = "land";

  /**
   * Enable video stream.
   */
  public static final String ENABLE_VIDEO_STREAM = "streamon";

  /**
   * Disable video stream.
   */
  public static final String DISABLE_VIDEO_STREAM = "streamoff";

  /**
   * Stops motors immidiately.
   */
  public static final String EMERGENCY = "emergency";


  /**
   * Fly upward xx (xx = 20 - 500 cm).
   */
  public static final String UP = "up";

  /**
   * Fly downward xx (xx = 20 - 500 cm).
   */
  public static final String DOWN = "down";

  /**
   * Fly left xx (xx = 20 - 500 cm).
   */
  public static final String LEFT = "left";

  /**
   * Fly right xx (xx = 20 - 500 cm).
   */
  public static final String RIGHT = "right";

  /**
   * Fly forward xx (xx = 20 - 500 cm).
   */
  public static final String FORWARD = "forward";

  /**
   * Fly backward xx (xx = 20 - 500 cm).
   */
  public static final String BACKWARD = "back";

  /**
   * Rotate clockwise xÂ° (x = 1-3600Â°).
   */
  public static final String CW = "cw";

  /**
   * Rotate counter-clockwise xÂ° (x = 1-3600Â°).
   */
  public static final String CCW = "ccw";

  /**
   * Flip x (l = left, r = right, f = forward, b = back, bl = back/left, rb = back/right), fl =
   * front/left, fr = front/right ).
   */
  public static final String FLIP = "flip";


  /**
   * Fly to â€œxâ€� â€œyâ€� â€œzâ€� at â€œspeedâ€� (cm/s). go x y z speed â€œxâ€� = -500-500 â€œyâ€� = -500-500 â€œzâ€� =
   * -500-500 â€œspeedâ€� = 10-100 Note: â€œxâ€�, â€œyâ€�, and â€œzâ€� values canâ€™t be set between -20 â€“ 20
   * simultaneously.
   */
  public static final String GO = "go";

  /**
   * Fly at a curve according to the two given coordinates at â€œspeedâ€� (cm/s). If the arc radius is
   * not within a range of 0.5-10 meters, it will respond with an error. â€œx1â€�, â€œx2â€� = -500-500 â€œy1â€�,
   * â€œy2â€� = -500-500 â€œz1â€�, â€œz2â€� = -500-500 â€œspeedâ€� = 10-60 Note: â€œxâ€�, â€œyâ€�, and â€œzâ€� values canâ€™t be
   * set between -20 â€“ 20 simultaneously.
   */
  public static final String CURVE = "curve";

  /**
   * Hovers in the air. Works any time.
   */
  public static final String STOP = "stop";

  /**
   * Set current speed as xx (xx = 1-100 cm/s ).
   */
  public static final String SPEED = "speed";

  // Read commands //

  /**
   * Obtain current speed (cm/s).
   */
  public static final String CURRENT_SPEED = "speed?";

  /**
   * Obtain current battery percentage.
   */
  public static final String CURRENT_BATTERY = "battery?";

  /**
   * Obtain current flight time.
   */
  public static final String CURRENT_FLY_TIME = "time?";

  /**
   * Obtain current droen height (cm, x: 0-3000).
   */
  public static final String CURRENT_HEIGHT = "height?";

  /**
   * Obtain current temperature of the drone (CÂ°, x: 0-90).
   */
  public static final String CURRENT_TEMPERATURE = "temp?";

  /**
   * Obtain IMU attitude data (pitch, roll, yaw).
   */
  public static final String CURRENT_ATTITUDE_DATA = "attitude?";

  /**
   * Obtain current barometer value (m).
   */
  public static final String CURRENT_BAROMETER = "baro?";

  /**
   * Obtain IMU angular acceleration data (0.001g, x y z).
   */
  public static final String CURRENT_ACCELERATION = "acceleration?";

  /**
   * Obtain distance value from TOFï¼ˆcm, x: 30-1000ï¼‰.
   */
  public static final String TOF = "tof?";

}
