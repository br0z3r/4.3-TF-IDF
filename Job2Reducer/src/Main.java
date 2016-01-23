import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by air on 23.01.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        InputStream stdin = null;
//        stdin = System.in;
//        FileInputStream stream = new FileInputStream("<filepath>/Test");
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
        String docId;
        String countTerm;

        int count = 1;


        StringBuilder outLine = new StringBuilder();

        HashSet<String>docSet = new HashSet<>();

        StringTokenizer st;

        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {

            st = new StringTokenizer(line,"\t;");
            term = st.nextToken();
            docId = st.nextToken();
            countTerm = st.nextToken();


            if(currentTerm == null){
                currentTerm = term;
                docSet.add((new StringBuilder(term)).append('#').
                        append(docId).append('\t').append(countTerm).toString());
                continue;
            }

            if(currentTerm.compareTo(term) != 0) {

                for (String partOut:docSet ) {
                    outLine.append(partOut).append('\t').append(count);
                    System.out.println(outLine.toString());
                    outLine.setLength(0);
                }

                currentTerm = term;

                docSet.clear();
                docSet.add((new StringBuilder(term)).append('#').
                        append(docId).append('\t').append(countTerm).toString());

                count = 1;
                continue;
            }

            docSet.add((new StringBuilder(term)).append('#').
                    append(docId).append('\t').append(countTerm).toString());

            outLine.setLength(0);
            currentTerm = term;
            count++;

        }

        for (String partOut:docSet ) {
            outLine.append(partOut).append('\t').append(count);
            System.out.println(outLine.toString());
            outLine.setLength(0);
        }

        docSet.clear();

    }
}


