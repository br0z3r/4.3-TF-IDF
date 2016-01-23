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
        getTermFrequency(bufferedReader);
    }

    private static void getTermFrequency(BufferedReader bufferedReader) throws IOException {
        if(!bufferedReader.ready() ) {
            return;
        }

        String line;
        String docId;
        String terms;

        StringTokenizer st;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {

            st = new StringTokenizer(line,":");

            docId = st.nextToken();
            terms = line.substring(docId.length()+1);
//            System.out.println(docId);
//            System.out.println(terms);

            docId = stringBuilder.append("#").
                    append(docId).
                    append("\t1").toString();
            stringBuilder.setLength(0);



            for (String match:terms.split("([^a-zA-Z0-9]+)") ) {
                System.out.println(stringBuilder.append(match).append(docId).toString());
                stringBuilder.setLength(0);
            }

//            st = new StringTokenizer(terms," ,.:\t\\/\r\n");
//            while (st.hasMoreTokens()){
//                System.out.println(stringBuilder.append(st.nextToken()).append(docId).toString());
//                stringBuilder.setLength(0);
//            }
        }
    }
}


