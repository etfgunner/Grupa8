package etf.si.helpers;

public class StringHelper {
	public static boolean isNullOrWhiteSpace(String value) {
	    return value == null || value.trim().isEmpty();
	}
}
