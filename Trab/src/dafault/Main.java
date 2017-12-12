package dafault;

import java.io.File;
import java.io.IOException;

public class Main 
{
	//private static final String CAMINHO_ARQ = "D:\\Projects\\Eclipse-workspace\\teste\\src\\teste\\cep.dat";
	private static final String CAMINHO_ARQ = "C:\\Users\\philippe.lima\\Desktop\\asd\\Trab\\src\\dafault\\cep.dat";
	private static final String CAMINHO_ARQ_MERGESORT = "C:\\Users\\philippe.lima\\Desktop\\asd\\Trab\\src\\dafault\\cep - Copy.dat";
	private static final long TAM_REGISTRO_ARQ = 300;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Comparativo de ordenação de arquivo usando algoritmos de ordenação.");
		System.out.println("Algoritmos usados:");
		System.out.println("-BubbleSort");
		System.out.println("-InsertionSort");
		System.out.println("-MergeSort");
		System.out.println("-QuickSort");
		System.out.println("-SelectionSort");		
		System.out.println("________________________________________________");
		
		try {
			System.out.println("Carregando arquivo...");
			File file = new File(CAMINHO_ARQ);
			
			if(file != null)
				System.out.println("Arquivo lido.");
			
			System.out.println("________________________________________________");
			
			System.out.println("Ordenando-o com BUBBLESORT:");
			long inicio = System.currentTimeMillis();
			BubbleSort.bubbleSort(file, (file.length() - TAM_REGISTRO_ARQ)/TAM_REGISTRO_ARQ);
			System.out.println("Tempo decorrido:" + (System.currentTimeMillis() - inicio) + "ms");

			System.out.println("________________________________________________");
			
			System.out.println("Usando INSERTIONSORT");
			inicio = System.currentTimeMillis();
			InsertionSort.insertionSort(file, (file.length() - TAM_REGISTRO_ARQ)/TAM_REGISTRO_ARQ);
			System.out.println("Tempo decorrido:" + (System.currentTimeMillis() - inicio) + "ms");

			System.out.println("________________________________________________");
			
			System.out.println("MERGESORT");
			inicio = System.currentTimeMillis();
	        MergeSort.mergesort(file, new File (CAMINHO_ARQ_MERGESORT), 0, (file.length() - TAM_REGISTRO_ARQ)/TAM_REGISTRO_ARQ);
			System.out.println("Tempo decorrido:" + (System.currentTimeMillis() - inicio) + "ms");

			System.out.println("________________________________________________");
			
			System.out.println("QUICKSORT");
			inicio = System.currentTimeMillis();
			QuickSort.quickSort(file, 0, (file.length() - TAM_REGISTRO_ARQ)/TAM_REGISTRO_ARQ);
			System.out.println("Tempo decorrido:" + (System.currentTimeMillis() - inicio) + "ms");

			System.out.println("________________________________________________");
			
			System.out.println("SELECTIONSORT");
			inicio = System.currentTimeMillis();
			SelectionSort.selectionSort(file, (file.length() - TAM_REGISTRO_ARQ)/TAM_REGISTRO_ARQ);
			System.out.println("Tempo decorrido:" + (System.currentTimeMillis() - inicio) + "ms");
			
		} catch ( IOException e) {
			//System.out.println("Erro ao ler arquivo.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
	}
}
