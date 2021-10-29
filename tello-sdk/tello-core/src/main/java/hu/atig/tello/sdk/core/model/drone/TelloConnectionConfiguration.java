package hu.atig.tello.sdk.core.model.drone;

public class TelloConnectionConfiguration {

    /*
     * Connection IP address.
     */
	public static final String DRONE_IP_ADDRESS = "192.168.10.1";
//	public static final String DRONE_IP_ADDRESS = "192.168.1.100";
    /*
     * Listen IP address.
     */
//    public static final String DRONE_LISTEN_IP_ADDRESS = "0.0.0.0";
	public static final String DRONE_LISTEN_IP_ADDRESS = "192.168.10.1";
//	 public static final String DRONE_LISTEN_IP_ADDRESS = "192.168.1.100";

    /*
     * Send command and receive response udp port.
     */
    public static final Integer COMMAND_PORT = 8889;
    
    /*
     * Receive state udp port.
     */
    public static final Integer STATE_PORT = 8890;
    
    /*
     * Send command and receive response udp port.
     */
    public static final Integer VIDEO_PORT = 11111;

}
