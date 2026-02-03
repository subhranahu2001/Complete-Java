package Collection_New.GarbageCollection;

import java.lang.ref.WeakReference;

public class GC  {

    public static void main(String[] args) {

        WeakReference<Phone> phoneWeakReference =
                new WeakReference<>(new Phone("apple","16 pro max"));

        System.out.println(phoneWeakReference.get());
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(phoneWeakReference.get());
    }

}


class Phone {
    private String brand;
    private String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}