package com.castlighthealth.device.scale;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castlighthealth.device.rpi.Hx711;
import com.pi4j.io.gpio.RaspiPin;

@SpringBootApplication
public class Scale {

	public static void main(String[] args) {
		// create instance of weighing scale controller
		// its hard coded for now, will need to make it programmable
		System.out.println("Creating instance of the HX711 controller...");
		Hx711 hx711 = new Hx711(RaspiPin.GPIO_21, RaspiPin.GPIO_22);
		try {
			// take 10 measurements and print
			System.out.println("Starting measurements...");
			for (int i = 0; i < 10; i++) {
				long measurement = hx711.measure(3);
				System.out.printf("[%02d] %d\n", i,measurement);
				// wait a bit for next reading
					Thread.sleep(100);			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// shutdown the controller
		System.out.println("Shutting down controller");
		hx711.shutdown();
	}

}
