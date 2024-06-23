/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author This PC
 */
public class BlogDetailDTO {
    private int blogId;
    private int userId;
    private String title;
    private String content;
    private String date;
    private String image;
    private String status;
    private int nLike;
    private int nCmt;
    private List<CommentDTO> cmt;

    public BlogDetailDTO() {
    }

    public BlogDetailDTO(int blogId, int userId, String title, String content, String date, String image, String status, int nLike, int nCmt, List<CommentDTO> cmt) {
        this.blogId = blogId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
        this.status = status;
        this.nLike = nLike;
        this.nCmt = nCmt;
        this.cmt = cmt;
    }

    

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getnLike() {
        return nLike;
    }

    public void setnLike(int nLike) {
        this.nLike = nLike;
    }

    public int getnCmt() {
        return nCmt;
    }

    public void setnCmt(int nCmt) {
        this.nCmt = nCmt;
    }

    public List<CommentDTO> getCmt() {
        return cmt;
    }

    public void setCmt(List<CommentDTO> cmt) {
        this.cmt = cmt;
    }

    
    
}
