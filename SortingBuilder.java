import java.util.Arrays;

public class SortingBuilder {
    public static testResult testAlgorithm(SortingAlgorithm algorithm, int[] data) {
        int[] dataCopy = Arrays.copyOf(data, data.length);
        
        long startTime = System.nanoTime();
        algorithm.sort(dataCopy); //executa a ordenação 
        long endTime = System.nanoTime();
        
        boolean sortedCorrectly = isSorted(dataCopy);
        double durationMs = (endTime - startTime) / 1_000_000.0; //conversão para milissegundos
        
        return new testResult(algorithm.getName(), durationMs, sortedCorrectly);
    }
    
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) { //se x elemento maior que o próximo
                return false;    // array não ordenado
            }
        }
        return true; //array ordenado
    }
    
    public static class testResult {
        public final String algorithmName;
        public final double timeMs;
        public final boolean success;
        
        public testResult(String algorithmName, double timeMs, boolean success) {
            this.algorithmName = algorithmName;
            this.timeMs = timeMs;
            this.success = success;
        }
    }
}