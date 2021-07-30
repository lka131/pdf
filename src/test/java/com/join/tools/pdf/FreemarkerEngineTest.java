//package com.join.tools.pdf;
//
//import com.itextpdf.text.DocumentException;
//import com.join.tools.pdf.model.Course;
//import com.join.tools.pdf.model.Student;
//import com.join.tools.pdf.utils.CommonUtils;
//import freemarker.template.TemplateException;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author Join 2018-10-25
// */
//
//public class FreemarkerEngineTest {
//
//
//    public static void main(String[] args) throws IOException, TemplateException, DocumentException {
//        String dir = CommonUtils.getRealPath("templates");
//        TemplatePdfEngine engine = new TemplatePdfEngine(dir);
//        List<Course> sourceList = new ArrayList<Course>();
//
//        sourceList.add(new Course("English", (float) 98.9));
//        sourceList.add(new Course("数学", (float) 99));
//        Student student = new Student("张三", 18, new Date(), BigDecimal.valueOf(20.5555), sourceList);
//        File pdfFile = new File("C:\\Users\\likai\\Desktop\\pdf-tools-master\\src\\main\\resources\\test.pdf");
//        //pdfFile.delete();
//        //pdfFile.createNewFile();
//        FileOutputStream fileOutputStream = new FileOutputStream(pdfFile);
//        engine.processPdf("test.ftl", student, fileOutputStream);
//    }
//
//}
