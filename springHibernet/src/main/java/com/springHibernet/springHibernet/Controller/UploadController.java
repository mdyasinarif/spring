package com.springHibernet.springHibernet.Controller;

import com.springHibernet.springHibernet.entity.User;
import com.springHibernet.springHibernet.repo.UserRepo;
import com.springHibernet.springHibernet.util.ImageOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    private static String UPLOADE_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private UserRepo repo;

    @Autowired
    private ImageOptimizer imageOptimizer;

    @ResponseBody
    @RequestMapping(value = "/uplode", method = RequestMethod.GET)
    public ModelAndView userView() throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", repo.findAll());
        mv.setViewName("userView");
        return mv;
    }

    @PostMapping("/uplode")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to Upload");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADE_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            User user = new User();
            user.setUserName("new-" + file.getOriginalFilename());
            user.setFileSize(file.getSize());
            user.setFile(file.getBytes());
            user.setFilePath("images/" + "new-" + file.getOriginalFilename());
            user.setFileExtension(file.getContentType());
            repo.save(user);
            System.out.println("=============== save success ============");
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            imageOptimizer.optimizeImage(UPLOADE_FOLDER, file, 0.8f, 200, 250);
            //            // Get the file and save it somewhere

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "result";
    }

}
