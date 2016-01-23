import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by air on 23.01.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        InputStream stdin = null;
//        stdin = System.in;
//        FileInputStream stream = new FileInputStream("<filepath>/test");
//        System.setIn(stream);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        prepareTerms(bufferedReader);
    }

    private static void prepareTerms(BufferedReader bufferedReader) throws IOException {
        if(!bufferedReader.ready() ) {
            return;
        }

        String line;
        StringBuilder outLine = new StringBuilder();

        StringTokenizer st;

        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {

            st = new StringTokenizer(line);

            outLine.append(st.nextToken()).append("\t").
                    append(st.nextToken()).append(";").
                    append(st.nextToken()).append(";1");
            System.out.println(outLine.toString());
            outLine.setLength(0);
        }
    }
}
