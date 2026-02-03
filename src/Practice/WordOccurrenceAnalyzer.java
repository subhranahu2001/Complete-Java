package Practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class WordOccurrenceAnalyzer {

    private static final String FOLDER_PATH = "C:\\Users\\91637\\OneDrive\\Desktop\\Data";

    public List<String> findNthOccurrences(int rank, boolean highest) throws IOException {
        Map<String,Long> wordMap = new HashMap<>();
        // Get all the files from folder
        List<Path> files = Files.walk(Paths.get(FOLDER_PATH))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // Read each and every file and directly update or store the frequency
        for (Path file : files) {
            executor.execute(() -> {
                try {
                    Files.lines(file)
                            .flatMap(line -> Arrays.stream(line.split("\\W+")))
                            .filter(word -> !word.isEmpty())
                            .forEach(word -> {
                                wordMap.merge(word, 1L, Long::sum);
                                System.out.println(Thread.currentThread().getName());
                            });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        System.out.println(wordMap);
        // Handel ranking by grouping words by their frequency
        Map<Long, List<String>> frequencyToWords = wordMap.entrySet().stream()
                .collect(Collectors
                        .groupingBy(Map.Entry::getValue,
                                Collectors.mapping(Map.Entry::getKey,
                                        Collectors.toList())));
        System.out.println(frequencyToWords);

        // Sort the frequency based on user search(desc/asc)

        List<Long> sortedFrequencies = new ArrayList<>(frequencyToWords.keySet());
        sortedFrequencies.sort(highest ? Comparator.reverseOrder() : Comparator.naturalOrder());
        System.out.println(sortedFrequencies);

        // Validation Rank
        if (rank <= 0 || rank > sortedFrequencies.size()) {
            throw new IllegalArgumentException("Invalid rank / Rank is out of range !");

        }
        long targetRank = sortedFrequencies.get(rank - 1);

        return frequencyToWords.getOrDefault(targetRank, Collections.emptyList());
    }

    public static void main(String[] args) throws IOException {
        WordOccurrenceAnalyzer analyzer = new WordOccurrenceAnalyzer();
        List<String> nthOccurrences1 = analyzer.findNthOccurrences(1, true);
        List<String> nthOccurrences2 = analyzer.findNthOccurrences(1, false);
        System.out.println(nthOccurrences1);
        System.out.println(nthOccurrences2);
    }
}
