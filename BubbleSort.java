public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) { //controla o número de passagens necessárias
            boolean swapped = false; // flag booleano: verifica se houve trocas na passagem

            for (int j = 0; j < n - 1 - i; j++) { // -i --> ignora elementos já ordenados no final do array
                if (arr[j] > arr[j + 1]) { //troca de elementos adjacentes --> array fora de ordem
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; 
                }
            }
            if (!swapped) { // se nenhuma troca ocorreu nesta passagem, o array está ordenado
                break;
            }
        }
    }
    @Override
    public String getName(){
        return "BubbleSort";
    }
}