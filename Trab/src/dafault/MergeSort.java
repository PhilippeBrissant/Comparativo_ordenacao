package dafault;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MergeSort {
	public static void mergesort(File f, File faux,  long inicio, long fim)
			throws IOException {
		if (inicio < fim) {
			long meio = inicio + (fim - inicio) / 2;

			mergesort(f,faux , inicio, meio);
			mergesort(f, faux, meio + 1, fim);
			merge(f, faux, inicio, meio, fim);
		}
	}

	private static void merge(File f, File faux,  long inicio, long meio, long fim)
			throws IOException {

		RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");

		long indiceEsq = inicio;
		long indiceDir = meio + 1;
		long indiceAux = inicio;

		while (indiceEsq <= meio && indiceDir <= fim) {

			randomAccessFile.seek(indiceEsq * 300);
			Endereco endEsq = new Endereco();
			endEsq.leEndereco(randomAccessFile);

			randomAccessFile.seek(indiceDir * 300);
			Endereco endDir = new Endereco();
			endDir.leEndereco(randomAccessFile);

			RandomAccessFile aux = new RandomAccessFile(faux,"rw");
			if (Long.valueOf(endEsq.getCep()) <= Long.valueOf(endDir.getCep())) {
				aux.seek(indiceAux * 300);
				aux.write(endEsq.toString().getBytes());
				indiceEsq++;
			} else {
				aux.seek(indiceAux * 300);
				aux.write(endDir.toString().getBytes());
				indiceDir++;
			}

			indiceAux++;
			aux.close();
		}

		while (indiceEsq <= meio) {
			randomAccessFile.seek(indiceEsq * 300);
			Endereco endEsq = new Endereco();
			endEsq.leEndereco(randomAccessFile);

			RandomAccessFile aux = new RandomAccessFile(faux,"rw");
			aux.seek(indiceAux * 300);
			aux.write(endEsq.toString().getBytes());

			indiceEsq++;
			indiceAux++;

			aux.close();
		}

		while (indiceDir <= fim) {
			randomAccessFile.seek(indiceDir * 300);
			Endereco endDir = new Endereco();
			endDir.leEndereco(randomAccessFile);

			RandomAccessFile aux = new RandomAccessFile(faux,"rw");
			aux.seek(indiceAux * 300);
			aux.write(endDir.toString().getBytes());

			indiceDir++;
			indiceAux++;

			aux.close();
		}

		randomAccessFile.close();
	}
}