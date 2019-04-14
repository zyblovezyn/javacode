package HeadFist.SimpleFactory;

public class FruitFactory {

    /*public static Fruit getApple(){
        return new Apple();
    }

    public static Fruit getBanana(){
        return new Banana();
    }*/

    public static Fruit getFruit(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*if (type.equalsIgnoreCase("apple")){
            return Apple.class.newInstance();
        }
        else if (type.equalsIgnoreCase("banana")) {
            return Banana.class.newInstance();
        } else {
            System.out.println("找不到相应的类");
        }
        return null;*/

        Class fruit=Class.forName("HeadFist.SimpleFactory."+type);
        return (Fruit) fruit.newInstance();

    }
}
