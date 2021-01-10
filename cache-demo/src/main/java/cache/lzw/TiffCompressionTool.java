package cache.lzw;

import com.sun.media.imageioimpl.plugins.tiff.TIFFImageReaderSpi;
import com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriterSpi;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author JianhuiChen
 * @description Tiff 文件压缩工具
 * @date 2020-10-23
 */
public class TiffCompressionTool {

    /**
     * Tiff 位图文件压缩
     *
     * @param srcPath  源文件地址
     * @param destPath 压缩结果文件存储地址
     * @param quality  压缩率
     * @throws IOException 读写异常
     */
    public static void compress(String srcPath, String destPath, float quality) throws IOException {
        // Read input img
        TIFFImageReaderSpi readerSpi = new TIFFImageReaderSpi();
        ImageReader reader = readerSpi.createReaderInstance();
        ImageInputStream iis = ImageIO.createImageInputStream(new FileInputStream(new File(srcPath)));
        reader.setInput(iis, true);
        BufferedImage srcImage = reader.read(0);

        // Output img
        TIFFImageWriterSpi spi = new TIFFImageWriterSpi();
        ImageWriter writer = spi.createWriterInstance();
        // Set compress params
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionType("LZW");
        param.setCompressionQuality(quality);

        // Write tiff img
        ImageOutputStream ios = ImageIO.createImageOutputStream(new File(destPath));
        writer.setOutput(ios);
        writer.write(null, new IIOImage(srcImage, null, null), param);
    }
}
