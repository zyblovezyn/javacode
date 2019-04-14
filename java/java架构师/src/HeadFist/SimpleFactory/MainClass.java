package HeadFist.SimpleFactory;

public class MainClass {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//
//        Apple apple=new Apple();
//
//        Banana banana=new Banana();
//
//        apple.get();
//        banana.get();


        //使用了多态
/*        Fruit apple=new Apple();
        Fruit banana=new Banana();

        apple.get();
        banana.get();*/


        /*Fruit apple =FruitFactory.getApple();
        Fruit banana=FruitFactory.getBanana();
        apple.get();
        banana.get();*/
        //this.getClass().getPackage().getName();
        Fruit apple = FruitFactory.getFruit("Apple");
        Fruit banana = FruitFactory.getFruit("Banana");
        apple.get();
        banana.get();
    }

}
