package controllers.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {

    @Value("${file.upload.path}")
    private String uploadDir;

    public String upload(){
        return "file/upload";
    }

    public String uploadPs(MultipartFile[] files){
        for(MultipartFile file : files) {
            File uploadPath = new File(uploadDir + file.getOriginalFilename());
            try {
                file.transferTo(uploadPath);
            } catch (IOException e) {
            }
        }
        return "file/upload";
    }
}
