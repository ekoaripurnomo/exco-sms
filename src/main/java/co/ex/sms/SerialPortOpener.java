package co.ex.sms;

import com.fazecast.jSerialComm.SerialPort;

public class SerialPortOpener {
    public static SerialPort openPort(String portName) {
        SerialPort serialPort = SerialPort.getCommPort(portName);

        if (serialPort.openPort()) {
            System.out.println("Port " + portName + " opened successfully.");
            return serialPort;
        } else {
            System.out.println("Failed to open port " + portName);
            return null;
        }
    }
}