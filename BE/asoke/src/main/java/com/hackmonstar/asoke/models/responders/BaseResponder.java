package com.hackmonstar.asoke.models.responders;

import java.util.List;

public class BaseResponder {
    private Status status;
    private Object results;
    private List<Errors> errors;

    public BaseResponder() {
    }

    public BaseResponder(Status status, Object results, List<Errors> errors) {
        this.status = status;
        this.results = results;
        this.errors = errors;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }


}
