package co.ex.sms;

import com.fazecast.jSerialComm.SerialPort;

public class ATCommand {
    public static String sendATCommand(SerialPort port, String command) {
        System.out.println("Sending: " + command);
        byte[] buffer = (command + "\r").getBytes();
        port.writeBytes(buffer, buffer.length);

        // Read response
        byte[] readBuffer = new byte[1024];
        int numRead = port.readBytes(readBuffer, readBuffer.length);
        if (numRead > 0) {
            String response = new String(readBuffer, 0, numRead);
            System.out.println("Response: " + response);
            return response;
        }
        return "";
    }
}