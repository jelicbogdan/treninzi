/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer.util.ResponseStatus;

/**
 *
 * @author PC
 */
public class Response implements Serializable {

    private Object data;
    private Exception exc;
    private ResponseStatus responseStatus;

    public Response() {
    }

    public Response(Object data, Exception error, ResponseStatus responseStatus) {
        this.data = data;
        this.exc = error;
        this.responseStatus = responseStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Exception getExc() {
        return exc;
    }

    public void setExc(Exception exc) {
        this.exc = exc;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

}
