import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileProperties extends Properties implements FileIO {

    private static final long serialVersionUID = 1L;

    public void readFromFile(String filename) throws IOException {
        load(new FileInputStream(filename));
    };
    public void writeToFile(String filename) throws IOException {
        store(new FileOutputStream(filename), "written by FileProperties");
    };
    public void setValue(String key, String value) {
        setProperty(key, value);
    };
    public String getValue(String key) {
        return getProperty(key);
    };

}