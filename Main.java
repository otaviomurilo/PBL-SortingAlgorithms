import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String dataFolder = "data/";
        String[] fileNames = {
            "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
            "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
            "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };

        SortingAlgorithm[] algorithms = {
            new BubbleSort(),
            new InsertionSort(),
            new QuickSort()
        };

        for (String fileName : fileNames) {
            String fullPath = dataFolder + fileName;
            
            if (!CSVReader.fileExists(fullPath)) {
                System.err.println("Arquivo não encontrado: " + fullPath);
                continue;
            }

            try {
                CSVReader reader = new CSVReader(fullPath, true);
                int[] data = reader.readIntegers();
                
                System.out.printf("\n=== %s (%d elementos) ===\n", fileName, data.length);
                
                for (SortingAlgorithm algorithm : algorithms) {
                    SortingBuilder.testResult result = SortingBuilder.testAlgorithm(algorithm, data);
                    
                    if (!result.success) {
                        System.err.printf("   %-12s: ERRO (não ordenou corretamente)\n", result.algorithmName);
                    } else {
                        System.out.printf("   %-12s: %8.3f ms\n", result.algorithmName, result.timeMs);
                    }
                }
                
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo " + fileName + ": " + e.getMessage());
            }
        }
    }
}