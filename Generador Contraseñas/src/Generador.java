import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Generador {
	public static void main(String[] args) {

		String contraseña = "";
		int num_random = 0;
		int eleccion_random = 0;
		int count = 0;

		Stack<Integer> opc = new Stack<Integer>();
		List<Integer> num = new ArrayList<>();

		List<String> alfabetoMin = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
		List<String> alfabetoMay = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		List<String> numeros = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
		List<String> simbolos = new ArrayList<>(Arrays.asList("_", "-", "$", "%", "*", "#", "!", "@", "^", "&"));
		List<String> contraseñas = new ArrayList<>();

		for (int i = 0; i < 12; i++) {
			if (count == 4 || count == 8) {
				while (!opc.empty()) {
					opc.pop();
				}
			}
			eleccion_random = (int) Math.floor(Math.random() * 4 + 1);
			while (opc.contains(eleccion_random)) {
				eleccion_random = (int) Math.floor(Math.random() * 4 + 1);

			}
			count++;
			opc.push(eleccion_random);
			num.add(eleccion_random);

		}
		for (int i = 0; i <1; i++) {
			for (int j = 0; j < 12; j++) {
				Collections.shuffle(simbolos);
				Collections.shuffle(alfabetoMin);
				Collections.shuffle(alfabetoMay);
				Collections.shuffle(numeros);
				num_random = (int) (Math.random() * 9 + 1);

				if (num.get(j) == 1) {
					contraseña += alfabetoMin.get(num_random);
				} else if (num.get(j) == 2) {
					contraseña += alfabetoMay.get(num_random);
				} else if (num.get(j) == 3) {
					contraseña += simbolos.get(num_random);
				} else if (num.get(j) == 4) {
					contraseña += numeros.get(num_random);
				}
			}
			contraseñas.add(contraseña);
			contraseña = "";
		}
		for (String pwd : contraseñas) {
			System.out.println(pwd);
		}
	}
}