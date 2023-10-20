import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ClassFinder {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Uso: fc <nome da classe> <dir> [-p]");
            return;
        }

        String className = args[0];
        String dirPath = args[1];
        boolean isParallel = args.length > 2 && args[2].equals("-p");

        long startTime = System.nanoTime();

        List<File> classFiles = findClassFiles(new File(dirPath));
        Stream<File> stream = isParallel ? classFiles.parallelStream() : classFiles.stream();
        boolean found = stream.anyMatch(file -> containsClass(file, className));

        long endTime = System.nanoTime();
        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(found ? "Classe encontrada!" : "Classe não encontrada.");
        if (found) {
            System.out.println("Encontrada em: ");
            classFiles.stream().filter(file -> containsClass(file, className)).forEach(file -> System.out.println(file.getAbsolutePath()));
        }
        System.out.println("Tempo gasto: " + elapsedTime + " ms");
        System.out.println("Quantidade de arquivos .class consultados: " + classFiles.size());
    }

    private static List<File> findClassFiles(File dir) throws IOException {
        List<File> classFiles = new ArrayList<>();
        if (dir.isDirectory()) {
            Files.walk(dir.toPath())
                    .filter(path -> path.toString().endsWith(".class") || path.toString().endsWith(".jar") || path.toString().endsWith(".war"))
                    .map(java.nio.file.Path::toFile)
                    .forEach(classFiles::add);
        }
        return classFiles;
    }

    private static boolean containsClass(File file, String className) {
        try {
            if (file.getName().endsWith(".class")) {
                String fileName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                return fileName.contains(className);
            } else if (file.getName().endsWith(".jar") || file.getName().endsWith(".war")) {
                // Verifica se a classe está presente no arquivo .jar ou .war
                // Aqui você pode utilizar alguma biblioteca como java.util.zip para iterar pelos arquivos dentro do .jar ou .war e buscar pela classe
                // Como a implementação detalhada não foi especificada, deixo em aberto para que você possa completar essa parte conforme sua necessidade.
                throw new UnsupportedOperationException("Implementação para busca em arquivos .jar ou .war não fornecida.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
