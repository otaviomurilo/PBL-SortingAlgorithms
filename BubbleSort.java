public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) { //controla o número de passagens pelo array
            for (int j = 0; j < n - 1; j++) { //laço interno que percorre o array e faz as trocas
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; //armazena o valor temporário
                    arr[j] = arr [j + 1]; //menor valor vai para frente
                    arr[j + 1] = temp; //finaliza a troca
                }
            }
        }
    }

    @Override
    public String getName(){
        return "BubbleSort";
    }
}
