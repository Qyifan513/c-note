import java.io.File;
import java.net.URL;

public class FileUrlExample {
    public static void main(String[] args) {
        File file = new File("C:/Users/yfyfyf/Desktop/综合设备箱监控终端导入模板.xlsx");
        URL fileUrl = null;
        try {
            System.out.println(file.toURI().toURL());
            fileUrl = file.toURI().toURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("File URL: " + fileUrl.toString());
    }
}
