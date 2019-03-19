package com.tksis.backendapp.util;

import com.tksis.backendapp.util.Response;

public class Response {
	
	 private Boolean success;
	 private String msg;
	 private Object data;
	 private long numrows;
	 
	 
	 
	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	public Response(Boolean success, String msg, Object data, long total) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.numrows = total;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public long getTotal() {
		return numrows;
	}
	public void setTotal(long total) {
		this.numrows = total;
	}
	
	/**
	* Genera la respuesta junto a los datos consultados
    *
    * @param success guarda true si todo fue correcto, false si se presenta algun inconveniente
    * @param mensaje texto informativo del resultado que se devolvera
    * @param data objeto complejo con información que se retornara
    * @return Response 
    */
	public static Response crear(Boolean success, String msg, Object data) {
        return new Response(success, msg, data, 0);
    }
	 

}