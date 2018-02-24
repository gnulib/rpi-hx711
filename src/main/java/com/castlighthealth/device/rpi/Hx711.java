package com.castlighthealth.device.rpi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public class Hx711 {
	
	GpioController gpio;
	GpioPinDigitalOutput clock;
	GpioPinDigitalInput data;
	
	// create an instance of Hx711 controller
	public Hx711(Pin dout, Pin sck) {
		gpio = GpioFactory.getInstance();
		// initialize the clock output pin and send control command to power up
		clock = gpio.provisionDigitalOutputPin(sck, "SCK", PinState.LOW);
		// initialize the data input pin to read the measurements
		data = gpio.provisionDigitalInputPin(dout, "DT");
	}

	public void shutdown() {
		// send clock signal to shutdown
		clock.low();
		clock.high();
		// stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();
	}
	
	// poll until specified timeout for device to get ready
	public boolean isReady(int timeout) {
		// as per HX711 spec, when device is ready, the input line will get low/0
		for (;data.isHigh() && timeout > 0; timeout--) {
			try {
				Thread.sleep(timeout * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return data.isHigh();
	}
	
	// read a measurement from device
	public long measure(int timeout) {
		// wait for device to get ready
		if (!isReady(timeout)) {
			return 0;
		}
		
		long measurement = 0;
		
		// device is a 24bit AD converter, and each bit is read by sending a pulse to the clock,
		// so read the 24 bits one at a time
		for (int i = 0; i < 24; i++) {
			// set clock high
			clock.high();
			// shift left and read new input bit 
			measurement = (measurement << 1) | (data.isHigh() ? 1:0);
			// set clock low
			clock.low();
		}
		return 0;
	}
}
