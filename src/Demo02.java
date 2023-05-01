import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

class Demo02
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sourcePath;
        String destiationPath;
        int ch;

        System.out.print("Enter Source file path : ");
        sourcePath = sc.next();
        File source = new File(sourcePath);
        if(source.exists() && source.isFile()) {
            System.out.print("Enter Destination path : ");
            destiationPath = sc.next();
            File dest = new File(destiationPath);
            if(dest.exists())
            {
                try(FileInputStream fin = new FileInputStream(sourcePath))
                {
                    try(FileOutputStream fout = new FileOutputStream(destiationPath))
                    {
                        while(!((ch = fin.read())==-1))
                            fout.write(ch);
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Destination path is invalid");
            }
        }
        else {
            System.out.println("Source fila path is invalid or file doesn't exists");
        }
    }
}