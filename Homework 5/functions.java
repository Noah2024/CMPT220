/*
for this one, if you remember, I asked you to come up with a 'reason' for a function and implement it. 
Now you get to do it! yay!!!!!
please go a little more complex than just simple math/simple printing for the function
feel free to google some inspiration though :)
*/



public class functions {
    public static class  EncryptionTools {
        public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
        public EncryptionTools(){
            System.out.println("|EncryptionTools initalized");
        }
        public String encode(String msg, int key){
            String encodedStr = "";
            for (int i = 0; i < msg.length(); i+=1){
                int index = alphabet.indexOf(msg.charAt(i));
                String toLoop = alphabet.substring(index) + alphabet.substring(0,index);
                int netChange = key%26;
                char newLet = toLoop.charAt(netChange);
                encodedStr += newLet;
            }
            return(encodedStr);
        }
        public String decode(String msg, int key){
            String decodedStr = "";
            for (int i = 0; i < msg.length(); i+=1){
                int index = alphabet.indexOf(msg.charAt(i));
                String toLoop = alphabet.substring(index) + alphabet.substring(0,index);
                int reverseNum = 26 - key%26;
                char newLet = toLoop.charAt(reverseNum);
                decodedStr += newLet;
            }
            return(decodedStr);
        }
    }
    public static void main(String[] args) {
        System.out.println("|Main class initalized|");
        EncryptionTools ET = new EncryptionTools();
        //ET does not handle special characters, strings only 
        String hiddenMsg = ET.encode("test", 5);
        String unhiddenMsg = ET.decode(hiddenMsg, 5);

        System.out.print(unhiddenMsg);
    }
    
   
}
