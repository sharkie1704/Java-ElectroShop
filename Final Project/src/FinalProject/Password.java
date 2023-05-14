package FinalProject;

public class Password {

    private static final char[] PASSWORD = {'p', 'a', 'n', 'd', 'a'};

    public boolean isEqual(char[] a) {
        char[] b = PASSWORD;
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
