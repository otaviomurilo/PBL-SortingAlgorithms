public class QuickSort implements SortingAlgorithm {

    @Override
    public String getName() {
        return "QuickSort";
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSortRecursivo(arr, 0, arr.length - 1);
    }

    /**
     * O método recursivo principal. Ele ordena a porção do array entre os índices 'low' e 'high'.
     */
    private void quickSortRecursivo(int[] arr, int low, int high) {
        // Condição de parada da recursão: quando a seção tem 1 ou 0 elementos.
        if (low < high) {
            // Particiona o array e obtém o índice final do pivô.
            int pivotIndex = partition(arr, low, high);

            // Chama recursivamente para as duas metades (sem incluir o pivô).
            quickSortRecursivo(arr, low, pivotIndex - 1);  // Sub-array à esquerda do pivô
            quickSortRecursivo(arr, pivotIndex + 1, high); // Sub-array à direita do pivô
        }
    }

    private int partition(int[] arr, int low, int high) {
        // Escolhemos o último elemento como pivô (uma estratégia comum).
        int pivot = arr[high];
        int i = (low - 1); // "Ponteiro" para a posição do último elemento menor que o pivô.

        // Percorre o sub-array para comparar cada elemento com o pivô.
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Move o elemento menor para a parte esquerda.
            }
        }

        // Coloca o pivô em sua posição final correta (logo após o último elemento menor).
        swap(arr, i + 1, high);
        return i + 1; // Retorna o índice do pivô.
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}