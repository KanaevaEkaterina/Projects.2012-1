package uniquelist;

public class RepeatingElement extends Exception {

    public RepeatingElement() {
    }

    public RepeatingElement(String str) {
        System.out.println("This element is already in the list");
    }
}
