package dafault;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SelectionSort {

	public static void selectionSort(File f, long tam) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
		for (long indicePivo = 0; indicePivo < tam - 1; indicePivo++) {
			randomAccessFile.seek(indicePivo * 300);
			Endereco menorEnd = new Endereco();
			menorEnd.leEndereco(randomAccessFile);

			long i = indicePivo;
			Endereco aux = new Endereco();
			for (long indiceAux = indicePivo + 1; indiceAux < tam; indiceAux++) {

				randomAccessFile.seek(indiceAux * 300);
				aux.leEndereco(randomAccessFile);

				if (Long.valueOf(aux.getCep()) < Long
						.valueOf(menorEnd.getCep())) {
					randomAccessFile.seek(indiceAux * 300);
					menorEnd.leEndereco(randomAccessFile);
					i = indiceAux;
				}
			}

			if (i != indicePivo) {
				randomAccessFile.seek(indicePivo * 300);
				randomAccessFile.write(menorEnd.toString().getBytes());

				randomAccessFile.seek(i * 300);
				randomAccessFile.write(aux.toString().getBytes());
			}
		}
	}
}
