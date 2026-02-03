package OOPS.MarkerInterface;

public class Dao extends Entity implements Deletable{

    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.delete(new Dao());
    }
}
