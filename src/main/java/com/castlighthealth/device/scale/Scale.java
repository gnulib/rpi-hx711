package com.castlighthealth.device.scale;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castlighthealth.device.rpi.Hx711;

@SpringBootApplication
public class Scale {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Error: need data pin and control pin numbers!");
			return;
		}
		Integer data, control;
		data = Integer.decode(args[0]);
		control = Integer.decode(args[1]);
		if (Hx711.RPI_3B_PINS.get(data) == null) {
			System.out.printf("Error: invalid data pin '%d'\n", data);
			data = null;
		}
		if (Hx711.RPI_3B_PINS.get(control) == null) {
			System.out.printf("Error: invalid control pin '%d'\n", control);
			control = null;
		}
		if (data == null || control == null) {
			return;
		}
		// create instance of weighing scale controller
		System.out.println("Creating instance of the HX711 controller...");
		Hx711 hx711 = new Hx711(Hx711.RPI_3B_PINS.get(data), Hx711.RPI_3B_PINS.get(control));
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
			e.printStackTrace();
		}
		// shutdown the controller
		System.out.println("Shutting down controller");
		hx711.shutdown();
	}

}
