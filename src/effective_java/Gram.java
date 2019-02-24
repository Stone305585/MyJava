package effective_java;

/**
 * Created by Stone on 2017/7/28.
 *
 * @author Stone<Stone305585@live.com>
 */
public class Gram {

    private final char first;
    private final char second;

    public Gram(char first, char second) {
        this.first = first;
        this.second = second;

    }


    /**
     * Note: 参数类型必须是Object，不然不能override
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }



    public String overrideTest(String s) {
        return "";
    }

    public boolean overrideTest(boolean n) {
        return false;
    }
}
