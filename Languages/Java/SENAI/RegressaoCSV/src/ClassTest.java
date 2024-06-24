public class ClassTest {
    public static void main(String[] args) {
        String name = "igo";
        String newName = "";

        newName = name.replaceAll(".","$0$0$0");

        System.out.println(newName);

    }
}
