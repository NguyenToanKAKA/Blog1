/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author This PC
 */
public class CommentDTO {
    private int commentId;
    private int userId;
    private int blogId;
    private String uFullName;
    private String content;
    private String date;
    private String avatar; // Thêm trường này để lưu đường dẫn đến ảnh đại diện


    public CommentDTO() {
    }

    public CommentDTO(int commentId, int userId, int blogId, String uFullName, String content, String date) {
        this.commentId = commentId;
        this.userId = userId;
        this.blogId = blogId;
        this.uFullName = uFullName;
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

    public String getuFullName() {
        return uFullName;
    }

    public void setuFullName(String uFullName) {
        this.uFullName = uFullName;
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

    public CommentDTO(int commentId, int userId, int blogId, String uFullName, String content, String date, String avatar) {
        this.commentId = commentId;
        this.userId = userId;
        this.blogId = blogId;
        this.uFullName = uFullName;
        this.content = content;
        this.date = date;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    
}
