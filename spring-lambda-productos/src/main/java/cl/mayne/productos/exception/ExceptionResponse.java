package cl.mayne.productos.exception;

import java.util.Date;

import lombok.Builder;

@Builder
public class ExceptionResponse {

	private Date timestamp;
	private String mensaje;
	private String detalles;
	private String httpCodeMessage;
	
	public ExceptionResponse(String mensaje, String detalles, String httpCodeMessage) {
		super();
		this.timestamp = new Date();
		this.mensaje = mensaje;
		this.detalles = detalles;
		this.httpCodeMessage = httpCodeMessage;
	}

	public ExceptionResponse(Date timestamp, String mensaje, String detalles, String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
		this.httpCodeMessage = httpCodeMessage;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

}
