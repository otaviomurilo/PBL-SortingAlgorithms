import java.util.Random;

public class QuickSort implements SortingAlgorithm {

    private Random random = new Random(); // gerador de números aleatórios para escolher o pivô

    @Override
    public String getName() {
        return "QuickSort"; 
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; 
        }
        sortSubarray(arr, 0, arr.length - 1); // ordenação recursiva
    }

    private void sortSubarray(int[] arr, int low, int high) { //ordena uma parte específica do array
        if (low < high) { 
            // escolhe um pivô aleatório --> particiona o array
            int pivotIndex = partition(arr, low, high);

            // chamadas recursivas
            sortSubarray(arr, low, pivotIndex - 1);
            sortSubarray(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // Escolhe um índice aleatório e move o elemento para a posição high --> se torna o pivô
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);

        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // coloca o pivô em sua posição final
        return i + 1; // índice do pivô
    }

    private void swap(int[] arr, int i, int j) { //troca de dois elementos no array
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}