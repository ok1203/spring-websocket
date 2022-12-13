package com.company.websocket;

import javax.persistence.*;


@Entity
@Table(name = "log")
public class Log {
    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 250, name = "content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

