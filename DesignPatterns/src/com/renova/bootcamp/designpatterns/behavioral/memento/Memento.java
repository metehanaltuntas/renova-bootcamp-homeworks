package com.renova.bootcamp.designpatterns.behavioral.memento;

public class Memento {
    // state
    private ElementInformation elementInformation;

    public Memento(ElementInformation elementInformation) {
        this.elementInformation = elementInformation;
    }

    public ElementInformation getElementInformation() {
        return elementInformation;
    }

    public void setElementInformation(ElementInformation elementInformation) {
        this.elementInformation = elementInformation;
    }
}
