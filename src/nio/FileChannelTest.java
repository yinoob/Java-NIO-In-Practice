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

        ByteBuffer buffer = ByteBuffer.allocate(48);

        int byteRead = channel.read(buffer);
        while (byteRead != -1){

            System.out.println("Read" + byteRead);
            buffer.flip();

            while(buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            byteRead = channel.read(buffer);
        }
        file.close();
    }
}
