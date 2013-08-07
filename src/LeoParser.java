import java.io.*;
import java.util.*;

public class LeoParser {
    File htmFile;

    final String lineDictIndicator = "DictionaryWordItemList";
    final String indicatorStart = "item-word-translate";
    final String indicatorEnd = "</div>";

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    private Map<String, String> dictionary;

    public LeoParser(String filename) {
        htmFile = new File(filename);
        dictionary = new LeoDictionary();
    }


    void check() {
        if (htmFile.exists())
            System.out.println("File found.");
        else
            System.out.println("File not found.");
    }

    void parse() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(htmFile)));
            String bigString = "";
            while (br.ready()) {
                String str = br.readLine();
                if (str.contains(lineDictIndicator)) {
                    bigString = str;
                }
            }
            br.close();
            parseBigString(bigString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    void parseBigString(String bigString) {
        if (bigString == null)
            return;
        int lastIndex = 0;
        while (true) {

            int indicatorStartIndex = bigString.indexOf(indicatorStart, lastIndex);
            int indicatorEndIndex = bigString.indexOf(indicatorEnd, indicatorStartIndex);

            if (indicatorStartIndex == -1 || indicatorEndIndex == -1)
                break;

            String substr = bigString.substring(indicatorStartIndex, indicatorEndIndex);

            parseSubString(substr);

            lastIndex = indicatorEndIndex;
        }
        System.out.println("Parsing done.");
    }

    void parseSubString(String subString) {
        int indexWordStart = subString.indexOf(">", subString.indexOf("<b"));
        int indexWordEnd = subString.indexOf("<", indexWordStart);
        String wordEn = subString.substring(indexWordStart+1, indexWordEnd);

        indexWordStart = subString.indexOf(">", subString.indexOf("<span", indexWordEnd));
        indexWordEnd = subString.indexOf("<", indexWordStart);
        String wordRu = subString.substring(indexWordStart+1, indexWordEnd);

        //System.out.println(wordEn + " - " + wordRu);
        dictionary.put(wordEn.trim(), wordRu.trim());
    }
}
