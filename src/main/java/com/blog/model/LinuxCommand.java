package com.blog.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "linux_command")
public class LinuxCommand extends BaseEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String command;

    private String link;

    private String cate;

    @Column(name = "is_studied")
    private String isStudied;

    @Column(name = "studied_at")
    private Date studiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command
     */
    public void setCommand(String command) {
        this.command = command == null ? null : command.trim();
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * @return cate
     */
    public String getCate() {
        return cate;
    }

    /**
     * @param cate
     */
    public void setCate(String cate) {
        this.cate = cate == null ? null : cate.trim();
    }

    /**
     * @return is_studied
     */
    public String getIsStudied() {
        return isStudied;
    }

    /**
     * @param isStudied
     */
    public void setIsStudied(String isStudied) {
        this.isStudied = isStudied == null ? null : isStudied.trim();
    }

    /**
     * @return studied_at
     */
    public Date getStudiedAt() {
        return studiedAt;
    }

    /**
     * @param studiedAt
     */
    public void setStudiedAt(Date studiedAt) {
        this.studiedAt = studiedAt;
    }
}