package kakaoExam;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class Parsing {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        final Set<String> gifNames = new HashSet<>();
        final String filename = scan.nextLine();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            final PrintWriter writer = new PrintWriter(new FileWriter("/Users/Downloads/hosts_access_log_00_x.txt"));

            stream.map(logMapper())
                    .filter(Log::isOkStatus)
                    .map(Log::getFileName)
                    .filter(f -> f.toLowerCase().endsWith(".gif"))
                    .filter(f -> !gifNames.contains(f))
                    .peek(gifNames::add)
                    .forEach(writer::println);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Function<String, Log> logMapper() {
        return line -> {
            final String[] split = line.split(" ");
            return new Log(split[6], split[8]);
        };
    }

    static class Log {

        private final String path;
        private final String status;

        Log(String path, String status) {
            this.path = path;
            this.status = status;
        }

        boolean isOkStatus() {
            return "200".equals(status);
        }

        String getFileName() {
            return path.substring(path.lastIndexOf('/') + 1, path.length());
        }
    }
}
