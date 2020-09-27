package br.com.b2w.starwars.planets.dto;

public class PlanetResponse {

	private String reason;
	private String reasonDetail;
	private int code;

	public PlanetResponse(String reason, String reasonDetail, int code) {
		super();
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
