import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.channels.*;


public class FindInt {
    private Path file;

    FindInt(Path file){
        this.file = file;
    }


    public int seek() throws IOException{
        int num = -1;

        try (SeekableByteChannel fc = Files.newByteChannel(file)){
            ByteBuffer buf = ByteBuffer.allocate(8);

            //Get the offset into the file.
            fc.read(buf);
            long offset = buf.getLong(0);

            fc.position(offset);
            buf.rewind();

            fc.read(buf);
            num = buf.getInt(0);
        } catch (IOException x) {
            System.err.println(x);
        }
        return num;
    }
}
