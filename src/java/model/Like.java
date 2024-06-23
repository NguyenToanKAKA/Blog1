/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author This PC
 */
public class Like {
    private int likeId;
    private int userId;
    private int blogId;

    public Like() {
    }

    public Like(int userId, int blogId) {
        this.userId = userId;
        this.blogId = blogId;
    }

    public Like(int likeId, int userId, int blogId) {
        this.likeId = likeId;
        this.userId = userId;
        this.blogId = blogId;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
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
    
}
