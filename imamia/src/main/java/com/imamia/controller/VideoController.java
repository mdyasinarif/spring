package com.imamia.controller;

import com.imamia.entity.News;
import com.imamia.entity.Video;
import com.imamia.repo.NewsRepo;
import com.imamia.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/video/")
public class VideoController {
    @Autowired
    private VideoRepo repo;

    @GetMapping(value = "add")
    public String addVideoView(Video video){
        return "admin/video";

    }

    @PostMapping(value = "add")
    public String addvideo(@Valid Video video, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/video";
        }else{
            if(video != null){
                News video1=this.repo.findByTitle(video.getTitle());
                if(video1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                }else{
                    this.repo.save(video);
                    model.addAttribute("video",new Video());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/video";
    }

    @GetMapping(value = "list")
    public String videoList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/videolist";
    }

    @GetMapping(value = "edit/{id}")
    public String editvideoView(@PathVariable("id") Long id, Model model){
        model.addAttribute("video", this.repo.getOne(id));
        return "admin/videoedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editvideo(@Valid Video video, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/videoedit";
        }else{
            if(video != null){
                News video1=this.repo.findByTitle(video.getTitle());
                if(video1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/newsedit";
                }else{
                    this.repo.save(video);
                    model.addAttribute("video",new Video());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/video/videolist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delvideo(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/video/videolist";

    }
}
