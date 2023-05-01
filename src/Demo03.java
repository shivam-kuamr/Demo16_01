import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static final String Movies_FILE = "Movies";

    public static void main(String[] args) {
        write();
        read();
    }

    public static void write() {
        List<Movies> list = new ArrayList<>();
        list.add(new Movies(1, "Harry Potter", 8.8));
        list.add(new Movies(2, "Residental Evil", 8.5));
        list.add(new Movies(3, "Tenent", 7.8));
        list.add(new Movies(4, "Passenger", 8.0));

        try (FileOutputStream fout = new FileOutputStream(Movies_FILE)) {
            try (DataOutputStream dout = new DataOutputStream(fout)) {
                    for(Movies m:list)
                    {
                        dout.writeInt(m.getId());
                        dout.writeUTF(m.getName());
                        dout.writeDouble(m.getRating());
                    }
                System.out.println("Data saved");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read()
    {
        try(FileInputStream fin = new FileInputStream(Movies_FILE))
        {
            try(DataInputStream din = new DataInputStream(fin))
            {
                while(true)
                {
                   int id = din.readInt();
                   String name = din.readUTF();
                   double rating = din.readDouble();

                   Movies m = new Movies(id,name,rating);
                    System.out.println(m);
                }
            }
        }
        catch (EOFException error)
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
