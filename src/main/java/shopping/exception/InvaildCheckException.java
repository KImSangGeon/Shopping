package shopping.exception;

@SuppressWarnings("serial")
public class InvaildCheckException extends RuntimeException {

	public InvaildCheckException(Throwable cause) {
		super("공백이 있습니다.", cause);
	}

	public InvaildCheckException() {
		super("공백이 있습니다.");
	}

	public InvaildCheckException(String message, Throwable cause) {
		super("공백이 있습니다.", cause);
	}

	public InvaildCheckException(String message) {
		super("공백이 있습니다.");
	}


}
