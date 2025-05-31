package co.ex.sms;

import com.fazecast.jSerialComm.SerialPort;

public class SmsSender implements AutoCloseable {
    private SerialPort port;

    public SmsSender(String portName) throws ModemException {
        this.port = SerialPortOpener.openPort(portName);
        if (this.port == null) {
            throw new ModemException("Failed to open port: " + portName);
        }

        // Configure port parameters
        port.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0);
    }

    public void sendSms(String phoneNumber, String message) throws ModemException, InterruptedException {
        try {
            // Test modem connection
            ATCommand.sendATCommand(port, "AT");
            Thread.sleep(1000);

            // Set SMS text mode
            ATCommand.sendATCommand(port, "AT+CMGF=1");
            Thread.sleep(1000);

            // Send SMS
            String command = "AT+CMGS=\"" + phoneNumber + "\"";
            ATCommand.sendATCommand(port, command);
            Thread.sleep(1000);

            // Send message content (terminated with Ctrl+Z)
            ATCommand.sendATCommand(port, message + "\u001A");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw e;
        } catch (Exception e) {
            throw new ModemException("Failed to send SMS", e);
        }
    }

    @Override
    public void close() {  // Added close() method
        if (port != null && port.isOpen()) {
            port.closePort();
        }
    }
}