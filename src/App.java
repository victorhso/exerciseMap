import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> election = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {

                String[] vector = line.split(",");
                String name = vector[0];
                int votes = Integer.parseInt(vector[1]);

                if (election.containsKey(name)) {
                    int vote = election.get(name);
                    election.put(name, vote + votes);
                } else {
                    election.put(name, votes);
                }

                line = br.readLine();
            }

            System.out.println("Total de Candidatos");

            for (String key : election.keySet()) {
                System.out.println(key + ": " + election.get(key));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
