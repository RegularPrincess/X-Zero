package Web.InterfaceWeb;

import java.io.IOException;

/**
 * Created by user on 28.01.2015.
 */
public interface ClientServer {
    public void out (int a) throws IOException;

    public void out (String a) throws IOException;

    public int inInt() throws IOException;

    public String inStr() throws IOException;

    public void close() throws IOException;

}
