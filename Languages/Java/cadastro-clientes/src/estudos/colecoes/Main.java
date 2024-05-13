package estudos.colecoes;

public class Main {
    public static void main(String[] args) {

       /* Set<String> linguagensSet = new HashSet<>();
        linguagensSet.add("Java");
        linguagensSet.add("Phyton");
        linguagensSet.add("Java-Script");
        linguagensSet.add("Java");
        linguagensSet.add("C++");


        List<String> linguagensList = new ArrayList<>();
        linguagensList.add("Java");
        linguagensList.add("Python");
        linguagensList.add("java-script");
        linguagensList.add("Go");

        System.out.println(linguagensList);

        linguagensList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(linguagensList);*/


        //System.out.println(linguagensSet);

        String name = "igo";
        String owner = "igo";

        String whoIs = name.equals(owner) ? "Hello boss" : "hello Guest" ;

        System.out.println(whoIs);





    }
}
