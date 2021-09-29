package com.renova.bootcamp.designpatterns.behavioral.memento;

public class ElementInformation {
    private ElementTypes elementType;
    private String detail;
    private Location location;

    public ElementInformation() {
    }

    public ElementInformation(ElementTypes elementType, String detail, Location location) {
        this.elementType = elementType;
        this.detail = detail;
        this.location = location;
    }

    public ElementTypes getElementType() {
        return elementType;
    }

    public void setElementType(ElementTypes elementType) {
        this.elementType = elementType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
