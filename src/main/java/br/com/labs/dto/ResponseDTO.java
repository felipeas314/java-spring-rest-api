package br.com.labs.dto;

public class ResponseDTO<E> {

	private E data;

	private String status;

	private String message;

	public ResponseDTO() {

	}

	public ResponseDTO(String status,String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseDTO(E data, String status, String message) {
		this.data = data;
		this.status = status;
		this.message = message;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
