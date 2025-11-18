class Box<Type> {
    private Type object;

    // Конструктор по умолчанию
    public Box() {
        this.object = null;
    }

    // Метод для размещения объекта в коробке
    public void put(Type item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя положить null в коробку");
        }
        if (this.object != null) {
            throw new IllegalStateException("Коробка уже содержит объект");
        }
        this.object = item;
    }

    // Метод для извлечения объекта из коробки
    public Type get() {
        if (this.object == null) {
            throw new IllegalStateException("Коробка пуста");
        }
        Type item = this.object;
        this.object = null;
        return item;
    }

    public boolean isFull() {
        return this.object != null;
    }

    @Override
    public String toString() {
        if (object == null) {
            return "Коробка[пусто]";
        } else {
            return "Коробка[" + object + "]";
        }
    }
}