package Collection_New.Map_New;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap<String,Image> imageCache =
                new WeakHashMap<>();

        imageCache.put(new String("image1"),new Image("image1"));
        imageCache.put(new String("image2"),new Image("image2"));
        System.out.println(imageCache);
        System.gc();
        simulateApplicationRunning();
        System.out.println("Cache after running : "+imageCache);
    }
    private static void simulateApplicationRunning() {
        try {
            System.out.println("Simulate application running...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

record Image(String name){
    @Override
    public String toString() {
        return name;
    }
}
