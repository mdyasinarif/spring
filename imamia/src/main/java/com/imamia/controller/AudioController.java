package com.imamia.controller;

import com.imamia.entity.Audio;
import com.imamia.entity.News;
import com.imamia.entity.Audio;
import com.imamia.repo.AudioRepo;
import com.imamia.repo.AudioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/audio/")
public class AudioController {
    @Autowired
    private AudioRepo repo;

    @GetMapping(value = "add")
    public String addaudioView(Audio audio){
        return "admin/audio";

    }

    @PostMapping(value = "add")
    public String addAudio(@Valid Audio audio, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/audio";
        }else{
            if(audio != null){
                News audio1=this.repo.findByTitle(audio.getTitle());
                if(audio1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                }else{
                    this.repo.save(audio);
                    model.addAttribute("audio",new Audio());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/audio";
    }

    @GetMapping(value = "list")
    public String audioList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/audiolist";
    }

    @GetMapping(value = "edit/{id}")
    public String editaudioView(@PathVariable("id") Long id, Model model){
        model.addAttribute("audio", this.repo.getOne(id));
        return "admin/audioedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editaudio(@Valid Audio audio, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/audioedit";
        }else{
            if(audio != null){
                News audio1=this.repo.findByTitle(audio.getTitle());
                if(audio1 != null ){
                    model.addAttribute("existMsg","Title is already exist");
                    return "admin/newsedit";
                }else{
                    this.repo.save(audio);
                    model.addAttribute("audio",new Audio());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/audio/audiolist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delaudio(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/audio/audiolist";

    }
}
