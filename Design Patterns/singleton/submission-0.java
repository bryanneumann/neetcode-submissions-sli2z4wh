static class Singleton {

    private final static Singleton INSTANCE = new Singleton();

    private String value;
    private Singleton() {
        value = "";
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
