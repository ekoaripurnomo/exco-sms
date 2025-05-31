# Java Library Send SMS using Modem Wavecom M1306B

## Using:

#### touch sms.java
```
import co.ex.sms.SmsSender;
import co.ex.sms.SerialPortLister;

public class sms {
public static void main(String[] args) {
// List available ports
SerialPortLister.printAvailablePorts();

        try (SmsSender sender = new SmsSender("/dev/ttyUSB0")) {
            sender.sendSms("+628880xxxxxxx", "Hello from Java SMS Library!");
            System.out.println("SMS sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
## Build :

#### javac -cp sms-modem-lib-1.0.0.jar sms.java
#### java -cp .:sms-modem-lib-1.0.0.jar sms
### or
#### java -cp .:sms-modem-lib-1.0.0.jar sms.java

## logs:
```
Available ports:
ttyUSB0
Port /dev/ttyUSB0 opened successfully.
Sending: AT
��sponse:
Sending: AT+CMGF=1
Response: AT
OK

Sending: AT+CMGS="+628880xxxxxxx"
Response: AT+CMGF=1
OK

Sending: Hello from Java SMS Library!�
Response: AT+CMGS="+628880xxxxxxx"
>
SMS sent successfully!
```

### Creator: ekoaripurnomo@gmail.com
