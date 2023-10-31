package Backtracking;

public class abbrevations {
    public static void main(String[] args) {
        String str = "pep";
        printAbbrevations(str, "", 0, 0);    
    } 
    public static void printAbbrevations(String str, String asf, int count, int pos){
        if(pos == str.length()){
            if(count == 0){
                System.out.println(asf);
            }else{
                System.out.println(asf + count);
            }
            return;
        }
        if(count > 0){
            printAbbrevations(str, asf + count + str.charAt(pos), 0, pos+1);
        }else{
            printAbbrevations(str, asf + str.charAt(pos), 0, pos+1);
        }
        printAbbrevations(str, asf, count+1, pos+1);
        return;
    }
}
