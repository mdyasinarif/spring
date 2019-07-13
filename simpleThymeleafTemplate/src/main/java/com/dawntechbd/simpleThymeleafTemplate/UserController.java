package com.dawntechbd.simpleThymeleafTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";


    @Autowired
    private ImageOptimizer imageOptimizer;

    @GetMapping(value = "list")
    public String getList(Model model) {
        List<User> list = this.userRepository.findAll();
        model.addAttribute("list", list);
        return "users/list";
    }

    //view the page
    @GetMapping(value = "add")
    public String addView(Model model) {
        model.addAttribute("user", new User());
        return "users/add";
    }

    //save the user
    @PostMapping(value = "add")
    public String add(Model model, @Valid User user) {
        if (user == null) {
            model.addAttribute("errorMsg", "Something Wrong!");
        } else {
            this.userRepository.save(user);
            model.addAttribute("successMsg", "User Save Successfully");

        }
        return "users/add";
    }


    @GetMapping(value = "edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        model.addAttribute("user", this.userRepository.getOne(id));
        return "users/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(Model model, @Valid User user, @PathVariable Long id) {
        user.setId(id);
        if (user == null) {
            model.addAttribute("errorMsg", "Something Wrong!");
        } else {
            this.userRepository.save(user);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id) {
        this.userRepository.deleteById(id);
        return "redirect:/user/list";
    }


    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws IOException {
        ModelAndView mv = new ModelAndView();

        mv.addObject("list", userRepository.findAll());
        mv.setViewName("index");
        return mv;
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");

            return "redirect:index";
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            User user = new User();

            user.setPhoto(file.getBytes());
            userRepository.save(user);
            System.out.println("=============== save success ============");
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 200, 250);
            //            // Get the file and save it somewhere

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:index";

    }
}

