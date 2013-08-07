import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Alexx
 * Date: 19.07.13
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */
public class LeoDictionary extends LinkedHashMap {

    public LeoDictionary() {
        super();
    }

    private int maxKeyLength;
    private int maxValLength;

    @Override
    public Object put (Object key, Object value) {
        String keyString = (String) key;
        String valString = (String) value;

        if (maxKeyLength < keyString.length())
            maxKeyLength = keyString.length();

        if (maxValLength < valString.length())
            maxValLength = valString.length();

        return super.put(key, value);
    }

    public int getMaxKeyLength() {
        return maxKeyLength;
    }

    public void setMaxKeyLength(int maxKeyLength) {
        this.maxKeyLength = maxKeyLength;
    }

    public int getMaxValLength() {
        return maxValLength;
    }

    public void setMaxValLength(int maxValLength) {
        this.maxValLength = maxValLength;
    }
}
