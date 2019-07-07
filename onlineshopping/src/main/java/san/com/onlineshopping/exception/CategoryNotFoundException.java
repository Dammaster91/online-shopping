package san.com.onlineshopping.exception;

import java.io.Serializable;

public class CategoryNotFoundException extends Exception implements Serializable {

	private String message;

	public CategoryNotFoundException() {
		this("Category is not available");

	}

	public CategoryNotFoundException(String message) {
		this.message = System.currentTimeMillis() + " : " + message;

	}

	public String getMessage() {
		return message;
	}

}
