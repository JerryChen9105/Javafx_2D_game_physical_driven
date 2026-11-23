package javafx.test.workspace.folder.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {

    public void withdraw(double amount, double balance) throws InsufficientFundsException {
        if (amount < 0) throw new IllegalArgumentException("negative amount");
        if (amount > balance) throw new InsufficientFundsException("amount is greater than balance");
    }

    public void checkAge(int age) throws InvalidAgeException {
    }

    public void registerUser(String name, int age) {
        if (name == null) throw new NullPointerException("name is null");
        try {
            checkAge(age);
        } catch (InvalidAgeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("User registered successfully");
        }
    }



    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void processFile() {
        try {
            // 可能抛出 FileNotFoundException 或普通 IOException 的代码
            simulateFileProcess();
            // the general level is order by:
            // FileNotFoundException -> IOException -> Exception(general)
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error");
        } catch (Exception e) {
            System.out.println("A general exception occurred");
        }
    }

    private void simulateFileProcess() throws FileNotFoundException, IOException {
    }

}
