public class InsertionSort implements SortingAlgorithm {

    @Override
    public String getName() {
        return "InsertionSort";
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return; // Arrays vazios ou com 1 elemento já estão ordenados
        }

        for (int i = 1; i < arr.length; i++) {
            int chave = arr[i]; // Elemento a ser inserido na posição correta
            int j = i - 1;     // Índice do último elemento da parte ordenada

            // Move elementos maiores que a chave para a direita
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j]; // Desloca elemento para direita
                j--;
            }
            arr[j + 1] = chave; // Insere a chave na posição correta
        }
    }
}