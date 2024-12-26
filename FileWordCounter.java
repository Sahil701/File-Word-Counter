package file.word.counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileWordCounter 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        FileWordCounter fw = new FileWordCounter();
        System.out.println("Enter the Path of File: ");
        String fileName = sc.nextLine();
        int wordCount = fw.countWords(fileName);
        System.out.println("Total words in the file: " + wordCount);
    }

    int countWords(String fileName) 
    {
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String words[] = line.split(" ");
                count += words.length;
            }
        } 
        catch (IOException e)  
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}