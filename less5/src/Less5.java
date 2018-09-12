import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Less5 {
    public static void main(String[] args) {

        File file = new File("U:\\source.txt");
        Scanner sc;
        Pattern p = Pattern.compile("\\s|\\n");
        String tmpWord = new String();
        String resWord = new String();
        int cnt=0;

        //Read from file
        try {
            sc = new Scanner(file)/*.useDelimiter(p)*/;
            while (sc.hasNext()) {
                tmpWord = sc.next();
                if (++cnt == 3)
                    resWord = tmpWord;
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Write to file
        if (resWord.length() != 0) {
            try (FileWriter writer = new FileWriter("U:\\result.txt", false)) {
                BufferedWriter bWriter = new BufferedWriter(writer);
                bWriter.write(resWord);
                bWriter.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
