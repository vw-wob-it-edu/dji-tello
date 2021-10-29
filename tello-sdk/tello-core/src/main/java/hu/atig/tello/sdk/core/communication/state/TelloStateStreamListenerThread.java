package hu.atig.tello.sdk.core.communication.state;

import hu.atig.tello.sdk.core.model.drone.TelloConnectionConfiguration;

import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

public class TelloStateStreamListenerThread extends Thread {

  private static final Logger logger = Logger
      .getLogger(TelloStateStreamListenerThread.class.getName());

  private boolean isStreamOn;
  private DatagramSocket ds;
  private byte[] receiveData = new byte[1024];

  /**
   * State stream IP address.
   */
  private InetAddress listenIpAddress;

  /**
   * Drones state stream UDP PORT.
   */
  private Integer udpPort;


  public TelloStateStreamListenerThread() {
    logger.info("Initializing state thread");
    isStreamOn = true;
    try {
      this.listenIpAddress = InetAddress.getByName(TelloConnectionConfiguration.DRONE_LISTEN_IP_ADDRESS);
      this.udpPort = TelloConnectionConfiguration.STATE_PORT;
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    logger.info("Thread (state) has started running....");
    try {
      ds = new DatagramSocket(udpPort);
      ds.bind(new InetSocketAddress(listenIpAddress, udpPort));
    } catch (SocketException e) {
      e.printStackTrace();
      return;
    }

    while (isStreamOn) {
      receiveData = new byte[345600];
      try {
        logger.fine("Waiting for state data...");
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        ds.receive(receivePacket);
        logger.fine("Packet received");

        // TODO: Process received data
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

  public boolean isStreamOn() {
    return isStreamOn;
  }

  public void setStreamOn(boolean streamOn) {
    isStreamOn = false;
  }
  
}
