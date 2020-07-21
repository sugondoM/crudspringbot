package com.sugondo.springtest.dao;

public class ResponseWrapper {
    int status;
    String description;
    Object detail;

    public ResponseWrapper() {
    }

    public ResponseWrapper(int status, String description, Object detail) {
        this.status = status;
        this.description = description;
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "status=" + status +
                ", description='" + description + '\'' +
                ", detail=" + detail +
                '}';
    }
}
