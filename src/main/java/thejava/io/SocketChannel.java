package thejava.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by chensongkui on 2017/9/21.
 */
public class SocketChannel {
    public static void main(String[] args) throws IOException, InterruptedException {
        java.nio.channels.SocketChannel socketChannel = java.nio.channels.SocketChannel.open(new InetSocketAddress("google.com", 80));
        //socketChannel.connect(new InetSocketAddress("google.com", 80));
        System.out.println(socketChannel.isConnected());
        socketChannel.configureBlocking(false);


        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.put("GET".getBytes());
        socketChannel.write(byteBuffer);
        byteBuffer.clear();

        Thread.sleep(1000);
        while (socketChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array()));
            byteBuffer.clear();
            //break;
        }
        socketChannel.close();



        //buffer channel
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();//转成读模式

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();//转成写模式
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        inChannel.read(bufferArray);



    }
}
