class Storage<Type> {
    private final Type object;

    public Storage(Type object) {
        this.object = object;
    }

    // Метод для получения объекта из хранилища
    public Type get() {
        return this.object;
    }

    // Метод для получения объекта или альтернативного значения
    public Type getOrDefault(Type defaultValue) {
        if (this.object == null) {
            return defaultValue;
        }
        return this.object;
    }

    @Override
    public String toString() {
        if (object == null) {
            return "Хранилище[null]";
        } else {
            return "Хранилище[" + object + "]";
        }
    }
}
