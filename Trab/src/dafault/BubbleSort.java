package dafault;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BubbleSort {

	public static void bubbleSort(File f, long tam) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
		boolean troca = true;
		while (troca) {
			troca = false;
			for (int i = 0; i < tam; i++) {
				randomAccessFile.seek(i * 300);
				Endereco end1 = new Endereco();
				end1.leEndereco(randomAccessFile);

				randomAccessFile.seek((i + 1) * 300);
				Endereco end2 = new Endereco();
				end2.leEndereco(randomAccessFile);

				if (Long.valueOf(end1.getCep()) > Long.valueOf(end2.getCep())) {
					Endereco aux = end1;

					randomAccessFile.seek(i * 300);
					randomAccessFile.write(end2.toString().getBytes());

					randomAccessFile.seek((i + 1) * 300);
					randomAccessFile.write(end1.toString().getBytes());
					troca = true;
				}
			}
		}
	}

}
