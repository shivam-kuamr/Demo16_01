import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo04 {
    public static final String MOVIES_PATH = "MoviesDetails";
    public static void main(String[] args) {
        write();
        read();
    }

    public static void read()
    {
        List<Movies> obj;
        try(FileInputStream fin = new FileInputStream(MOVIES_PATH))
        {
            try(ObjectInputStream oin = new ObjectInputStream(fin)) {
                obj = (List<Movies>) oin.readObject();
                obj.forEach(m -> System.out.println(m));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void write()
    {
        List<Movies> list = new ArrayList<>();
        list.add(new Movies(1,"Harry Potter",8.8));
        list.add(new Movies(2, "Residental Evil", 8.5));
        list.add(new Movies(3, "Tenent", 7.8));
        list.add(new Movies(4, "Passenger", 8.0));

        try(FileOutputStream fout = new FileOutputStream(MOVIES_PATH))
        {
            try(ObjectOutputStream oout = new ObjectOutputStream(fout))
            {
                oout.writeObject(list);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
