package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {

        RandomAccessFile file = new RandomAccessFile("F:\\a.txt","rw");

        FileChannel channel = file.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buffer = ByteBuffer.allocate(48);

        //read into buffer
        int byteRead = channel.read(buffer);

        while (byteRead != -1){

            System.out.println("Read " + byteRead);
            //make buffer ready for read
            buffer.flip();

            while(buffer.hasRemaining()){
                // read 1 byte at a time
                System.out.print((char)buffer.get() +" ");
            }
            //make buffer ready for writing
            buffer.clear();
            byteRead = channel.read(buffer);
        }
        file.close();
    }
}
