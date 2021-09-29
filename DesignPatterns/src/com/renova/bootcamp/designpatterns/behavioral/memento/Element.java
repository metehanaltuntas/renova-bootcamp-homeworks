package com.renova.bootcamp.designpatterns.behavioral.memento;

public class Element {
    private ElementInformation elementInformation;

    public Element() {
    }

    public Element(ElementInformation elementInformation) {
        this.elementInformation = elementInformation;
    }

    public ElementInformation getElementInformation() {
        return elementInformation;
    }

    public void setElementInformation(ElementInformation elementInformation) {
        this.elementInformation = elementInformation;
    }

    public Memento createMemento() {
        return new Memento(this.elementInformation);
    }

    public void setMemento(Memento memento) {
        this.elementInformation = memento.getElementInformation();
    }

    @Override
    public String toString() {
        String s = "Eleman Detayları: \n\r";
        s += String.format("Türü: %s %n\r Detay: %s %n\r Konum: %s %n\r",
                elementInformation.getElementType(),
                elementInformation.getDetail(),
                elementInformation.getLocation());
        return s;
    }
}
