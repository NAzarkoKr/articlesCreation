package net.webTry.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Article implements Serializable, Comparable<Article> {

    @Id
    @GeneratedValue
    private  Integer id;
    @Column
    private String title;
    @Column(length = 100000)
    @Lob
    private String content;
    @Column
    private long creationTimestamp;
    public Article(){

    }

    public Article(String title, String content, long creationTimestamp) {
        this.title = title;
        this.content = content;
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public int compareTo(Article that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
