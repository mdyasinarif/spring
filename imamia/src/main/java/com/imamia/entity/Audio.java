package com.imamia.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter News Titel")
    @Column(unique = true)
    private String title;

    private String decription;

    private String filepath;

    private String audiolink;



    public Audio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getAudiolink() {
        return audiolink;
    }

    public void setAudiolink(String audiolink) {
        this.audiolink = audiolink;
    }
}
