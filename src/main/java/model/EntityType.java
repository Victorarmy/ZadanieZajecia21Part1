package model;

public enum EntityType {

    EXPENSE("Wydatek"),
    INCOME("Przychód");
    private String name;

    EntityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
