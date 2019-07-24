package com.imamia.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.Date;

@Entity
public class Ebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter News Titel")
    @Column(unique = true)
    private String title;

    private String decription;
    private String byuser;

    private Date postdate  = new Date();
    private String filepath;

    private File book;



    public Ebook() {
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

    public String getByuser() {
        return byuser;
    }

    public void setByuser(String byuser) {
        this.byuser = byuser;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
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

    public File getBook() {
        return book;
    }

    public void setBook(File book) {
        this.book = book;
    }
}
