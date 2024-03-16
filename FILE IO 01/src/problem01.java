import java.io.*;

public class problem01 {

    public static void main(String[] args) {
        try {
            File newFile = createNewFile("test.txt");

            writeFile(newFile, "Hello, world!");

            String content = readFile(newFile);
            System.out.println("File content: " + content);


            String filePath = getFilePath(newFile);
            System.out.println("File path: " + filePath);

            deleteFile(newFile);

            createDirectory("java");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static File createNewFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println("File created: " + filename);
        } else {
            System.out.println("File already exists.");
        }
        return file;
    }


    private static void writeFile(File file, String data) throws IOException {
        data ="hello wolrd!";
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
            System.out.println("Complete: " + data);
        }
    }


    private static String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }


    private static String getFilePath(File file) {
        return file.getAbsolutePath();
    }


    private static void deleteFile(File file) {
        if (file.delete()) {
           System.out.println("File deleted successfully.");
       } else {
            System.out.println("Failed to delete the file.");
        }
    }

    private static void createDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directoryName);
        } else {
            System.out.println("Failed to create directory.");
        }
    }
}
