package dafault;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class QuickSort {

	public static void quickSort(File f, long inicio, long fim)
			throws IOException {
		if (inicio < fim) {
			long posicaoPivo = separar(f, inicio, fim);
			quickSort(f, inicio, posicaoPivo - 1);
			quickSort(f, posicaoPivo + 1, fim);
		}
	}

	private static long separar(File file, long inicio, long fim)
			throws IOException {

		RandomAccessFile f = new RandomAccessFile(file, "rw");
		f.seek(inicio * 300);

		Endereco pivo = new Endereco();
		pivo.leEndereco(f);

		long i = inicio + 1, j = fim;

		while (i <= j) {
			f.seek(i * 300L);

			Endereco aux = new Endereco();
			aux.leEndereco(f);

			f.seek(j * 300L);

			Endereco aux2 = new Endereco();
			aux2.leEndereco(f);

			if (Long.valueOf(aux.getCep()) <= Long.valueOf(pivo.getCep())) {
				i++;

			} else if (Long.valueOf(aux2.getCep()) > Long
					.valueOf(pivo.getCep())) {
				j--;
			} else {

				f.seek(i * 300);
				f.write(aux2.toString().getBytes());

				f.seek(j * 300);
				f.write(aux.toString().getBytes());

				i++;
				j--;
			}
		}

		Endereco aux = pivo;

		f.seek(j * 300);
		Endereco e = new Endereco();
		e.leEndereco(f);

		f.seek(j * 300);
		f.write(aux.toString().getBytes());

		f.seek(inicio * 300);
		f.write(e.toString().getBytes());

		f.close();
		return j;
	}

}
