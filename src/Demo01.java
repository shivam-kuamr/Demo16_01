import java.io.File;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath;
        filePath = sc.next();
        File f = new File(filePath);
        if(f.exists())
        {
            if(f.isDirectory())
            {
                for (String str :f.list())
                {
                    System.out.println(str);
                }
            }
            else if(f.isFile()){
                System.out.println("file name : "+f.getName());
                System.out.println("file size : "+f.length());
                System.out.println("Parent : "+f.getParent());
                System.out.println("Permission : "+(f.canRead()?"r":"-")+""+(f.canWrite()?"w":"-")+""+(f.canExecute()?"w":"-"));
            }
            else {
                System.out.println("neither file nor directory");
            }
        }
        else {
            System.out.println("Invalid Path");
        }
    }
}
