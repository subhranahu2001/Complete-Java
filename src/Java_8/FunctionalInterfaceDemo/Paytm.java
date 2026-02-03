package Java_8.FunctionalInterfaceDemo;

public class Paytm implements UPIPayment{

    @Override
    public String doPayment(String source, String dest) {
        String datePattern = UPIPayment.datePattern("yyyy/MM/dd");
        return "";
    }

    @Override
    public double getScratchCard() {
        return UPIPayment.super.getScratchCard();
    }
}
