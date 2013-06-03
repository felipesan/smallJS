import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Vector;

public class Compilador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lexico();
	}

	private static void Lexico() {
		try {
			File file = new File("C:\\Users\\Giane\\Desktop\\Tokens.txt");
			FileWriter writer = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(writer);

			Lexico L = new Lexico();
			Vector result = new Vector<>();
			BufferedReader lerArq = new BufferedReader(new FileReader(
					"C:\\Users\\Giane\\Desktop\\teste.js"));
			String linha;
			while (lerArq.ready()) {//verifica linha por linha
				linha = lerArq.readLine();
				linha = L.removeComment(linha);
				if (!L.searchString(linha).isEmpty()) {
					result = L.searchString(linha);
					buffer = saveFile(result, buffer);
				}

			}
			buffer.flush();
			lerArq.close();

		} catch (IOException e) {

		}

	}

	public static BufferedWriter saveFile(Vector linhas, BufferedWriter buffer) {

		try {

			for (int i = 0; i < linhas.size(); i++) {
				buffer.write(linhas.get(i).toString());
				buffer.newLine();
			}
			return buffer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;

	}

}
