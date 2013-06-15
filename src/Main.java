
public class Main {
    static public void main (String[] args) {
        LeoParser leoParser = new LeoParser("LinguaLeo.htm");
        leoParser.check();
        leoParser.parse();
        EclipseSaver.save("result.ewl", leoParser.getDictionary());
    }
}
