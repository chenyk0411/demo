package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class HtmlToPDFUtil {
    private static String PDFToolPath = "C:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe";

    /**
     * 调用命令行转换html成pdf
     * @param srcPath
     * @param destPath
     */
    public static void htmlToPDF(String srcPath,String destPath) throws Exception{
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }

        StringBuilder cmd = new StringBuilder();
        cmd.append(PDFToolPath);
        cmd.append(" ");
        cmd.append("  --header-line");//页眉下面的线
        cmd.append("  --header-center 这里是页眉这里是页眉这里是页眉这里是页眉 ");//页眉中间内容
        //cmd.append("  --margin-top 30mm ");//设置页面上边距 (default 10mm)
        cmd.append(" --header-spacing 10 ");//    (设置页眉和内容的距离,默认0)
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);

        Process proc = Runtime.getRuntime().exec(cmd.toString());

        proc.waitFor();
    }
}
