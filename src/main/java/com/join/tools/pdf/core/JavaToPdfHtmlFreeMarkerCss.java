package com.join.tools.pdf.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;
public class JavaToPdfHtmlFreeMarkerCss {



    private static final String DEST = "C:/Users/likai/Desktop/pdf-tools-master/src/main/resources/templateFCss.pdf";
    private static final String FTL = "C:/Users/likai/Desktop/pdf-tools-master/src/main/resources/templates/";
    private static final String HTML = "templateFCss.html";
    private static final String FONT = "C:/Users/likai/Desktop/pdf-tools-master/src/main/resources/fonts/simsun.ttf";
    private static final String FONT_C = "C:/Users/likai/Desktop/pdf-tools-master/src/main/resources/fonts/simsun.ttf";
    private static final String FONT_S = "C:/Users/likai/Desktop/pdf-tools-master/src/main/resources/fonts/simsun.ttc";

    private static final String LOGO_PATH = "C:/Users/likai/Pictures/Camera Roll/1.jpg";

    private static Configuration freemarkerCfg = null;

    static {
        freemarkerCfg =new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //freemarker的模板目录
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new File(FTL));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("name","梦琪D路费");
        File file=new File(LOGO_PATH);
        data.put("fileType","image/jpg");
        data.put("file64Str",fileToBase64Str(file));
        String content =freeMarkerRender(data,HTML);
        //System.out.println(content);
        createPdf(content,DEST);

    }

    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static void createPdf(String content,String dest) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        ITextRenderer render = new ITextRenderer();

        //设置字体
        ITextFontResolver fontResolver = render.getFontResolver();
        fontResolver.addFont(FONT_S, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        fontResolver.addFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        fontResolver.addFont(FONT_C, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        // 解析html生成pdf
        render.setDocumentFromString(content);
        render.layout();
        render.createPDF(new FileOutputStream(dest));
        render.finishPDF();
    }


    /**
     * File to 64bit Str
     *
     * @param file
     * @return
     */
    public static String fileToBase64Str(File file) {
        byte[] data = null;
        InputStream inputStream = null;
        if (file != null) {
            try {
                inputStream = new FileInputStream(file);
                data = new byte[inputStream.available()];
                inputStream.read(data);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Base64.getEncoder().encodeToString(data);

        }
        return null;
    }
}