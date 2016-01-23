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
        getCountTerms(bufferedReader);
    }

    private static void getCountTerms(BufferedReader bufferedReader) throws IOException {
        if(!bufferedReader.ready() ) {
            return;
        }

        String line;
        String currentTerm = null;
        String term;
        int count = 1;
        StringBuilder outLine = new StringBuilder();

        StringTokenizer st;

        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {

            st = new StringTokenizer(line);
            term = st.nextToken();
            if(currentTerm == null){
                currentTerm = term;
                continue;
            }

            if(currentTerm.compareTo(term) == 0) {
                count++;
                continue;
            }

            outLine.append(currentTerm.replace('#','\t')).append("\t").append(count);
            System.out.println(outLine);

            outLine.setLength(0);
            currentTerm = term;
            count = 1;

        }

        outLine.append(currentTerm.replace('#','\t')).append("\t").append(count);
        System.out.println(outLine);

    }
}


