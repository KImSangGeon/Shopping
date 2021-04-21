package shopping.exception;

public class NullPointerException extends RuntimeException {


	public NullPointerException(String message, Throwable cause) {
		super("주문내역이 없습니다.", cause);
	}

	public NullPointerException(String message) {
		super("주문내역이 없습니다.");
	}

}
