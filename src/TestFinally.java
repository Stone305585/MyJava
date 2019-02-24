/**
 * Created by Stone on 2018/5/23.
 *
 * @author Stone<Stone305585@live.com>
 */
public class TestFinally {

    public static void main(String[] args) {

        System.out.print(testFinally().toString());
    }



    public static StringBuilder testFinally() {
        StringBuilder s = new StringBuilder("9");
        try{
            return s;
        } finally {
            s.append("fasdfadf");
        }
    }

    class  MYYClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }
}
