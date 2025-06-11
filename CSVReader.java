import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private final String filePath;
    private boolean hasHeader; 

    public CSVReader(String filePath, boolean hasHeader) {
        this.filePath = filePath;
        this.hasHeader = hasHeader; //("Value")
    }

    public int[] readIntegers() throws IOException {
        List<Integer> dataList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            boolean isFirstLine = true;
    
            while ((line = br.readLine()) != null) {
                if (this.hasHeader && isFirstLine) {
                    isFirstLine = false;
                    continue; //pula o cabeçalho ("Value")
                }
    
                line = line.trim();
                if (!line.isEmpty()) {
                    dataList.add(Integer.parseInt(line));
                }
            }
        }
        
        return dataList.stream().mapToInt(i -> i).toArray();
    }

    public static boolean fileExists(String filePath) {
        return new java.io.File(filePath).exists(); //retorna o arquivo exisente
    }
}