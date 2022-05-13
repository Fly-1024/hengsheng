package com.sinosoft.demo.common;

import com.sinosoft.demo.server.MSTTSSpeech;

import java.io.File;
import java.io.IOException;

public class WavToMp3 {

    /**
     * 将指定目录中的.wav文件转为.mp3文件
     */
    public static void main(String[] args) {

        // 路径
        String path = "D:\\resources\\voice\\";
        File f = new File(path);
        // 路径不存在
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        MSTTSSpeech speech = new MSTTSSpeech();

        File result[] = f.listFiles();
        // 循环遍历
        for (int i = 0; i < result.length; i++) {
            File fs = result[i];
            if (fs.isFile()) {
                if (fs.getName().endsWith(".wav")) {
                    String wavPath = path + fs.getName();
                    String mp3Path = path + fs.getName().replaceAll(".wav", ".mp3");
                    try {
                        speech.wavToMp3(wavPath, mp3Path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
