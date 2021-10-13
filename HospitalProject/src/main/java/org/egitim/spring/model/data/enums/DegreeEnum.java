package org.egitim.spring.model.data.enums;

public enum DegreeEnum {
    PRACTITIONER("Practitioner"),
    EXPERT("Expert"),
    OPERATOR("Operator"),
    ASSISTANT_PROFESSOR("Assistant Professor"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    PROFESSOR("Professor"),
    ORDINARY("Ordinary");

    private final String degree;

    DegreeEnum(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }
}
