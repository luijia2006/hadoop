package cn.xpleaf.dataClean.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.fs.permission.FsPermission;

public class HdfsClient {
    //上传文件
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        putFileToHDFS();

//        getFileFromHDFS();
        //makirAtHDFS();
        //deleteAtHDFS();
        //readFileAtHDFS();
    }

    /**
     * 上传文件到文件系统
     *
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static void putFileToHDFS() throws IOException, InterruptedException, URISyntaxException {
        //1,获取文件系统配置
        Configuration conf = new Configuration();
        //2,获取连接
        FileSystem fs = FileSystem.get(new URI("hdfs://172.16.1.66:9000"), conf, "root");
        //3,上传文件
        fs.copyFromLocalFile(new Path("e:/hadoop.txt"), new Path("/hello1.txt"));
        //4，关闭资源
        fs.close();
    }

    /**
     * 文件下载
     *
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static void getFileFromHDFS() throws IOException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        //1,获取文件系统
        FileSystem fs = FileSystem.get(new URI("hdfs://172.16.1.66:9000"), conf, "root");
        //2,下载文件
        fs.copyToLocalFile(true, new Path("/hello1.txt"), new Path("e:/hello2.txt"));
        //3，关闭资源
        fs.close();
    }

    /**
     * 创建文件夹
     *
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static void makirAtHDFS() throws IOException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        //1,获取文件系统
        FileSystem fs = FileSystem.get(new URI("hdfs://172.16.1.66:9000"), conf, "root");
        //2,创建文件夹
        FsPermission permission = new FsPermission("677");
        fs.mkdirs(new Path("/user/atguigu/a/b"), permission);
        //3,关闭资源
        fs.close();
    }

    /**
     * 更改文件名称
     *
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static void deleteAtHDFS() throws IOException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        //1,获取文件系统
        FileSystem fs = FileSystem.get(new URI("hdfs://172.16.1.66:9000"), conf, "root");
        //2,执行删除操作
        fs.rename(new Path("/hello.txt"), new Path("/hellodemo.txt"));
        //3,关闭资源
        fs.close();
    }

    public static void readFileAtHDFS() throws IOException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        //1,获取文件系统
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://172.16.1.66:9000"), conf, "root");
        //2,查看文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"), true);
        //3,遍历
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();
            //文件名
            System.out.println(fileStatus.getPath().getName());
            //块大小
            System.out.println(fileStatus.getBlockSize());
            //文件内容长度
            System.out.println(fileStatus.getLen());
            //文件权限
            System.out.println(fileStatus.getPermission());
        }

    }

}
