package com.castlighthealth.device.rpi;

import java.util.HashMap;
import java.util.Map;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class Rpi3b {
	
	// a mapping from RPi 3B pins to pi4j pins
	public static Map<Integer, Pin> RPI_3B_PINS;
	static {
		RPI_3B_PINS = new HashMap<Integer, Pin>();
		RPI_3B_PINS.put(3, RaspiPin.GPIO_07);
		RPI_3B_PINS.put(5, RaspiPin.GPIO_09);
		RPI_3B_PINS.put(7, RaspiPin.GPIO_07);
		RPI_3B_PINS.put(11, RaspiPin.GPIO_00);
		RPI_3B_PINS.put(13, RaspiPin.GPIO_02);
		RPI_3B_PINS.put(15, RaspiPin.GPIO_03);
		RPI_3B_PINS.put(19, RaspiPin.GPIO_12);
		RPI_3B_PINS.put(21, RaspiPin.GPIO_13);
		RPI_3B_PINS.put(23, RaspiPin.GPIO_14);
		RPI_3B_PINS.put(27, RaspiPin.GPIO_30);
		RPI_3B_PINS.put(29, RaspiPin.GPIO_21);
		RPI_3B_PINS.put(31, RaspiPin.GPIO_22);
		RPI_3B_PINS.put(33, RaspiPin.GPIO_23);
		RPI_3B_PINS.put(35, RaspiPin.GPIO_24);
		RPI_3B_PINS.put(37, RaspiPin.GPIO_25);
		RPI_3B_PINS.put(40, RaspiPin.GPIO_29);
		RPI_3B_PINS.put(38, RaspiPin.GPIO_28);
		RPI_3B_PINS.put(36, RaspiPin.GPIO_27);
		RPI_3B_PINS.put(32, RaspiPin.GPIO_26);
		RPI_3B_PINS.put(28, RaspiPin.GPIO_31);
		RPI_3B_PINS.put(26, RaspiPin.GPIO_11);
		RPI_3B_PINS.put(24, RaspiPin.GPIO_10);
		RPI_3B_PINS.put(22, RaspiPin.GPIO_06);
		RPI_3B_PINS.put(18, RaspiPin.GPIO_05);
		RPI_3B_PINS.put(16, RaspiPin.GPIO_04);
		RPI_3B_PINS.put(12, RaspiPin.GPIO_01);
		RPI_3B_PINS.put(10, RaspiPin.GPIO_16);
		RPI_3B_PINS.put(8, RaspiPin.GPIO_15);
	}

	public static Pin mapRpi3bLineToPin(Integer line) {
		return RPI_3B_PINS.get(line);
	}
}
