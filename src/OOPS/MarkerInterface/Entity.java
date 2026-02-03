package OOPS.MarkerInterface;

public class Entity implements Deletable{

    public void delete(Object obj) {
        if (obj instanceof Entity) {
            System.out.println("Deleted Entity");
        } else throw new RuntimeException("Not a Entity");
    }

}
