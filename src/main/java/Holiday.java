public enum Holiday {
    NO_HOLIDAY("0-0"),
    NY("12-31"),
    MARCH_8("3-8"),
    FEBRUARY_23("2-23");

    private String title;

    Holiday(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
