import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Untitled {
    public static void main(String[] args) {
        File file= new File("C:/Users/yfyfyf/Desktop/综合设备箱监控终端导入模板.xlsx");
        URL url=file.toURL();
        System.out.println(url);
    }
}
