package enumerated.menu;

import java.util.Random;

public class Enums {
	private static Random rand = new Random();

	public static <T extends Enum<T>> T randrom(Class<T> ec) {
		return random(ec.getEnumConstants());
	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}
}