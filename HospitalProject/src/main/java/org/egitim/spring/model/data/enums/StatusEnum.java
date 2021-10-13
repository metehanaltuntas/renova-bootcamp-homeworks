package org.egitim.spring.model.data.enums;

public enum StatusEnum {
    PASSIVE(0),
    ACTIVE(1);

    private int statusCode;

    StatusEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
