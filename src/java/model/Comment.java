/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author This PC
 */
public class Comment {
    private int commentId;
    private int userId;
    private int blogId;
    private String content;
    private String date;

    public Comment() {
    }

    public Comment(int userId, int blogId, String content, String date) {
        this.userId = userId;
        this.blogId = blogId;
        this.content = content;
        this.date = date;
    }

    public Comment(int commentId, int userId, int blogId, String content, String date) {
        this.commentId = commentId;
        this.userId = userId;
        this.blogId = blogId;
        this.content = content;
        this.date = date;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
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
    
}
