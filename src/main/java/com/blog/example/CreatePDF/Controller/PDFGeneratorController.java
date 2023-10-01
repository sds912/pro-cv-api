package com.blog.example.CreatePDF.Controller;

import com.blog.example.CreatePDF.dto.Resume;
import com.blog.example.CreatePDF.dto.UploadPictureResponse;
import com.blog.example.service.FileStorageService;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@RequestMapping("/api/v1")
@Controller
public class PDFGeneratorController {
    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping("/pdf")
    public ResponseEntity<InputStreamResource> savePDF(@RequestBody Resume resume) throws IOException, DocumentException {

        resume.getExperiences().forEach(exp ->{
            exp.setStartDate(dateUtil(exp.getStartDate()));
            exp.setEndDate(dateUtil(exp.getEndDate()));
        });

        Context context = new Context();
        // set variables
        context.setVariable("header",resume.getHeader());
        context.setVariable("experiences",resume.getExperiences());
        context.setVariable("educations",resume.getEducations());
        context.setVariable("skills",resume.getSkills());
        context.setVariable("languages",resume.getLanguages());
        context.setVariable("languages",resume.getLanguages());
        context.setVariable("theme",resume.getTheme());
        context.setVariable("step",resume.getStep());


        String htmlContentToRender = templateEngine.process("pdf-template", context);
        String xHtml = xhtmlConvert(htmlContentToRender);

        ITextRenderer renderer = new ITextRenderer();
        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "main", "resources", "templates")
                .toUri()
                .toURL()
                .toString();
        renderer.setDocumentFromString( xHtml, baseUrl);

        renderer.layout();

        OutputStream outputStream = new FileOutputStream("test.pdf");
        InputStream inputStream   = new FileInputStream("test.pdf");
        renderer.createPDF(outputStream);
        outputStream.close();

        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentLength(Files.size(Paths.get("test.pdf")));//optional
        ContentDisposition contentDisposition = ContentDisposition.builder("inline")
                .filename("Filename")
                .build();
        headers.setContentDisposition(contentDisposition); //optional
        headers.setContentType(MediaType.APPLICATION_PDF); //optional
        return new ResponseEntity(inputStreamResource, headers, HttpStatus.OK);

    }

    @PostMapping("/upload")
    public ResponseEntity<UploadPictureResponse> uploadPicture(@RequestPart("uploadFile") MultipartFile file) throws IOException, DocumentException {
        String fileName = fileStorageService.storeFile(file);
        return ResponseEntity.ok().body(new UploadPictureResponse(fileName));
    }


    private String xhtmlConvert(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString("UTF-8");
    }

    private  String dateUtil(String inputDateString){
        LocalDate date = LocalDate.parse(inputDateString);

        // Create a custom date format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM yyyy");

        // Format the date as "MMM yyyy"
        String formattedDate = date.format(outputFormatter);

        // Print the formatted date
        return formattedDate;
    }



}
