package com.hackmonstar.asoke.utilities;

import com.hackmonstar.asoke.models.responders.BaseResponder;
import com.hackmonstar.asoke.models.responders.Errors;
import com.hackmonstar.asoke.models.responders.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class ResponderHelper {
    private BaseResponder baseResponder;

    public ResponderHelper(){}

    public ResponderHelper(BaseResponder baseResponder) {
        if(baseResponder == null){
            this.baseResponder = new BaseResponder();
        } else {
            this.baseResponder = baseResponder;
        }
    }

    public BaseResponder setSuccess(String statusCode, Object object) {
        this.baseResponder.setStatus(new Status(statusCode, Constants.SUCCESS));
        this.baseResponder.setResults(object);
        this.baseResponder.setErrors(null);
        return this.baseResponder;
    }

    public BaseResponder setError(String statusCode, String errorMessage) {
        this.baseResponder.setStatus(new Status(getNumeric(statusCode), Constants.FAILED));
        this.baseResponder.setResults(null);
        this.baseResponder.setErrors(Arrays.asList(new Errors(statusCode, errorMessage)));
        return this.baseResponder;
    }

    private String getNumeric(String value) {
        return (value != null) ? value.substring(1) : null;
    }

    public BaseResponder getResponders() {
        return this.baseResponder;
    }

    public ResponseEntity<BaseResponder> getResponder(Object object) {
        ResponseEntity responseEntity;
        if (object != null) {
            BaseResponder responders = (BaseResponder) object;
            String status = responders.getStatus().getCode();
            //check status equal 200 or other
            if (status != null && (status.equals(String.valueOf(HttpStatus.OK.value())) || status.equals(String.valueOf(HttpStatus.CREATED.value())))) {
                responseEntity = new ResponseEntity(responders, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity(responders, HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity(new BaseResponder(new Status(String.valueOf(HttpStatus.BAD_REQUEST.value()), Constants.FAILED), null, baseResponder.getErrors()), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }
}
