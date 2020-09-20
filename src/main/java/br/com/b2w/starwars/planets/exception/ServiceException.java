package br.com.b2w.starwars.planets.exception;

public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private String reason;
	
	private String reasonDetail;
	
	private int code;
	
	public ServiceException(String reason, String reasonDetail, int code) {
		this.reason = reason;
		this.reasonDetail = reasonDetail;
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReasonDetail() {
		return reasonDetail;
	}

	public void setReasonDetail(String reasonDetail) {
		this.reasonDetail = reasonDetail;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
