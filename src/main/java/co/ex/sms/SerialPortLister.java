package co.ex.sms;

import com.fazecast.jSerialComm.SerialPort;

public class SerialPortLister {
    public static String[] listAvailablePorts() {
        SerialPort[] ports = SerialPort.getCommPorts();
        String[] portNames = new String[ports.length];
        for (int i = 0; i < ports.length; i++) {
            portNames[i] = ports[i].getSystemPortName();
        }
        return portNames;
    }

    public static void printAvailablePorts() {
        String[] ports = listAvailablePorts();
        System.out.println("Available ports:");
        for (String port : ports) {
            System.out.println(port);
        }
    }
}