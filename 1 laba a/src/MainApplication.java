public class MainApplication {
    // обьекты передаваемые в завтрак
    // тип обьекта определяется классом к которому принадлежит обьект
    public static void main(String[] args) throws Exception
    {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];// максимальное количество элементов включаемые в завтрак(20 ссылок на объекты класса Food)

        // Анализ аргументов командной строки и создание для них
// экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        for (String arg: args)
        {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese"))// У сыра – 1 параметр, который находится в parts[0]
            {
                breakfast[itemsSoFar] = new Cheese();
            } else
            if (parts[0].equals("Apple"))// У яблока – 1 параметр, который находится в parts[0]
            {
                    breakfast[itemsSoFar] = new Apple(parts[1]);
            } else
            if (parts[0].equals("Lemonade")) // У лимонада – 1 параметр, который находится в parts[0]
            {
                breakfast[itemsSoFar] = new Lemonade(parts[1]);
            }
            itemsSoFar++;
        }
        for (Food item: breakfast)
            if (item!=null)
                item.consume();
            else
                break;
        System.out.println("Всего хорошего!");
    }
}