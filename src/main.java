import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		StringBuilder new_srt = new StringBuilder();
		StringBuilder final_srt = new StringBuilder();
		
		Scanner in = new Scanner(System.in);
        System.out.println("Input a text:");
        String str = in.nextLine();
        System.out.println("Input a key:");
        String str_key = in.nextLine();
        
        ArrayList<Integer> arraySrt = new ArrayList<>();
        ArrayList<Integer> arraySrtKey = new ArrayList<>();
        ArrayList<Integer> arrayNew = new ArrayList<>();
        
        for (char i : str.toCharArray())
        	arraySrt.add((int) i);
        
        for(int k=0; k<str.length(); k++)
	        for (char i : str_key.toCharArray()) {
	        	if(arraySrt.size()>arraySrtKey.size())
	        		arraySrtKey.add((int) i); }
        
        for(int i=0; i<str.length(); i++)
        	if(arraySrt.get(i) + arraySrtKey.get(i) % 27 == 0)
        		new_srt.append(' ');
        	else if(arraySrt.get(i) == ' ')
	    		new_srt.append((char) (arraySrtKey.get(i) + 0) );
	    	else if(arraySrtKey.get(i) == ' ')
	    		new_srt.append((char) (arraySrt.get(i) + 0) );
        	else if((char) (((arraySrt.get(i) + arraySrtKey.get(i)) - 192) % 27 + 96) == '`')
	    		new_srt.append(' ');
        	else if(arraySrt.get(i) == ' ' || arraySrtKey.get(i) == ' ')
	    		new_srt.append(' ');
        	else
        		new_srt.append((char) (((arraySrt.get(i) + arraySrtKey.get(i)) - 192) % 27 + 96));
        String bufSrt = new_srt.toString();
        System.out.println(bufSrt);
        
        for (char i : bufSrt.toCharArray())
        	if(i == ' ')
        		arrayNew.add((int) '`');
        	else
        		arrayNew.add((int) i);
        
        for(int i=0; i<bufSrt.length(); i++)
        	if((char) (((arrayNew.get(i) - arraySrtKey.get(i)) + 27) % 27 + 96) == '`')
        		final_srt.append(' ');
        	else
        		final_srt.append((char) (((arrayNew.get(i) - arraySrtKey.get(i)) + 27) % 27 + 96));
        final_srt.toString();
        System.out.println(final_srt);
	}
}