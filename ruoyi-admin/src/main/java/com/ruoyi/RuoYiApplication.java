package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.ClassUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication
{
    public static void createAsciiPic(final String path) {
        final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
            System.out.println("    JUST    启动成功");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        System.out.println(path);
        SpringApplication.run(RuoYiApplication.class, args);
        createAsciiPic(path+"/static/justAscii.png");
    }
}