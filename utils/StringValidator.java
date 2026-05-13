package utils;

import java.util.Optional;

public class StringValidator {

	public static Optional<String> validarString(String s) {
    	if (s != null && !s.isEmpty()) {
    	    return Optional.of(s);
    	}

    	return Optional.empty();
	}

	public static String validarString(String s, String fallback) {
    	if (s != null && !s.isEmpty()) {
    	    return s;
    	}

    	return fallback;
	}
}
