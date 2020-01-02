
    public class Apple extends Food{
        // Новое внутреннее поле данных ВКУС
        private String taste;


        public Apple (String taste)
        {

// Вызвать конструктор предка, передав ему имя класса
            super("Яблоко");
// Инициализировать размер яблока
            this.taste = taste;
        }
        // Переопределить способ употребления яблока
        public void consume()
        {
            System.out.println(this + "съедено");
        }
        // Селектор для доступа к полю данных РАЗМЕР
        public String getSize()
        {
            return taste;
        }
        // Модификатор для изменения поля данных РАЗМЕР
        public void setSize(String size)
        {

            this.taste = taste;
        }
        // Переопределенная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
        public boolean equals(Object arg0)
        {
            if (super.equals(arg0))
            { // Шаг 1
                if (!(arg0 instanceof Apple)) return false; // Шаг 2
                return taste.equals(((Apple)arg0).taste); // Шаг 3
            } else
                return false;
        }
        // Переопредел?нная версия метода toString(), возвращающая не только
// название продукта, но и его размер
        public String toString()
        {

            return super.toString() + " размера '" + taste.toUpperCase() + "'";
        }
    }