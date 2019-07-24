package com.imamia.controller;

import com.imamia.entity.News;
import com.imamia.entity.Role;
import com.imamia.entity.User;
import com.imamia.repo.NewsRepo;
import com.imamia.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/news/")
public class NewsController {
    @Autowired
    private NewsRepo repo;
    @Autowired
    private ImageOptimizer imageOptimizer;
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
    @GetMapping(value = "/")
    public String displayNews(News news){
        return "blog";

    }

    @GetMapping(value = "add")
    public String addNewsView(News news){
        return "admin/news";

    }

    @PostMapping("add")
    public String save(@Valid News news, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {

        if (bindingResult.hasErrors()) {
            return "admin/news";
        }



        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);


            // user.setFile(file.getBytes());
            news.setFilepath("/images/" + "new-" + file.getOriginalFilename());

            //////////////////////For Image Upload end/////////////////////
            // user.setPassword(encoder.encode(user.getPassword()));

            this.repo.save(news);
            model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin/news";
    }
    @GetMapping(value = "list")
    public String newsList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/newslist";
    }
  @GetMapping(value = "blog")
    public String displayBlog(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "blog";
    }

    @GetMapping(value = "edit/{id}")
    public String editNewsView(@PathVariable("id") Long id, Model model){
        model.addAttribute("new", this.repo.getOne(id));
        return "admin/newsedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editNews(@Valid News news, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/newsedit";
        }else{
            if(news != null){
                News news1=this.repo.findByTitle(news.getTitle());
                if(news1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/newsedit";
                }else{
                    this.repo.save(news);
                    model.addAttribute("news",new News());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/news/newslist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delNews(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/news/newslist";

    }
}
