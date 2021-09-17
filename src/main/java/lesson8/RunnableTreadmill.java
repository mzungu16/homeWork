package lesson8;

public interface RunnableTreadmill {

    public default void doWithTreadmill(){
        System.out.println("All of strangers must run");
    }

}
