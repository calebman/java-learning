import cache.lzw.TiffCompressionTool;
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
 * @description
 * @date 2020-10-23
 */
public class CompressTestes {


    public static void main(String[] args) throws IOException {
        TiffCompressionTool.compress(
                "/Users/chee/Desktop/workimg/img3.tif",
                "/Users/chee/Desktop/workimg/img3-result.tif",
                0.01f
        );
    }
}
