import java.util.Date;

public class Main {
    static public void main (String[] args) {
        System.out.println("Started at " + new Date());
        LeoParser leoParser = new LeoParser("LinguaLeo.htm");
        leoParser.check();
        leoParser.parse();
        EclipseSaver.save("result.ewl", leoParser.getDictionary());
    }
}
