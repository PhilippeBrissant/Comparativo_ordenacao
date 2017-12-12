package dafault;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertionSort {
	public static void insertionSort(File f, long tam) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
		for (int indicePivo = 1; indicePivo < tam; indicePivo++) {
			randomAccessFile.seek(indicePivo * 300);
			Endereco pivo = new Endereco();
			pivo.leEndereco(randomAccessFile);

			for (int indiceAux = indicePivo - 1; indiceAux >= 0; indiceAux--) {
				randomAccessFile.seek(indiceAux * 300);
				Endereco aux = new Endereco();
				aux.leEndereco(randomAccessFile);

				if (Long.valueOf(pivo.getCep()) > Long.valueOf(aux.getCep())) {
					randomAccessFile.seek(indicePivo * 300);
					randomAccessFile.write(aux.toString().getBytes());

					randomAccessFile.seek(indiceAux * 300);
					randomAccessFile.write(pivo.toString().getBytes());
				}
			}
		}
	}
}
