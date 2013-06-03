import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Lexico {

	public Vector<Object> searchString(String linha) {
		String str = "";
		Vector<Object> a = new Vector<>();
		if (linha.contains("\"")) { // tem String na linha?
			for (int i = 0; i < linha.length(); i++) {
				if (linha.charAt(i) == '"') {// estado zero - > estado 1
					for (int j = i + 1; j < linha.length(); j++) {// fica no
																	// estado 3
						if (linha.charAt(j) != '"') {// estado 1 - > estado 3
							str = str + linha.charAt(j);
						} else {
							i = j + 1;
							a.add("<STR, " + str + ">");
							//System.out.println(a);
							// saveFile("<STR, "+str+">");
							str = "";
							break;
						}
					}
				}
			}

		}
		return a;
	}

	public String removeComment(String linha) {
		final StringBuilder mutable = new StringBuilder(linha);
			int count = 0;
			for (int i = 0; i < linha.length(); i++) {
				if (linha.charAt(i) == '/') {
					if (linha.charAt(i + 1) == '/') {
						for (int j = 0; j < i+1; j++) {
							if(linha.charAt(j) == '"'){
								count++;
							}
						}
						if(count%2!=0){
							return linha;
						}
						for (int j = i; j < linha.length(); j++) {
							mutable.setCharAt(j, ' ');
							i = j;
						}
						break;
					}
				}
			}
			return mutable.toString();
		//}
		//return mutable.toString();
	}
	
	//String a = "abla//casa";



}
