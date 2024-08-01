import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Desafios {

    static class Va1{
        public static String getStr(){

            return "abcdefghijklmnop";
        }
        public String ini(String s, int cpr){
            return s.substring(0,cpr);
        }
        public String fin(String s, int cpr){
            return ini(s,cpr)+s.substring(s.length()-cpr,s.length());
        }

    }

    static class Va2 extends Va1{
        public static String getStr(){
            return "0123456789ABCDEF";
        }
        public String ini(String s, int cpr){
            return s.substring(s.length()-cpr,s.length());
        }
    }

    public static void main(String[] args) {
        Optional<String> opt = Optional.of("teste");
    }
}
