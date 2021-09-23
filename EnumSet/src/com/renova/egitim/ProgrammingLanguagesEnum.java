package com.renova.egitim;

public enum ProgrammingLanguagesEnum {
    JAVA("JAVA", 1990),
    C("C", 1978),
    PYTHON("PYTHON", 1989),
    PHP("PHP", 1996),
    VISUAL_BASIC("VISUAL BASIC", 1970),
    JAVASCRIPT("JAVASCRIPT", 2000),
    R("R", 1980),
    GO("GO", 1988),
    RUBY("RUBY", 2005),
    GROOVY("GROOVY", 2006),
    PERL("PERL", 2000);

    private final String programmingLanguageName;
    private final int releaseDate;

    ProgrammingLanguagesEnum(String programmingLanguageName, int releaseDate) {
        this.programmingLanguageName = programmingLanguageName;
        this.releaseDate = releaseDate;
    }

    public String getProgrammingLanguage() {
        return programmingLanguageName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }
}
