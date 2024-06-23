/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.BlogDAO;
import dao.CommentDAO;
import dao.LikeDAO;
import dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.BlogDTO;
import model.BlogDetailDTO;
import model.Comment;
import model.CommentDTO;

/**
 *
 * @author This PC
 */
public class BlogService {

    private final CommentDAO commentDao;
    private final BlogDAO blogDao;
    private final LikeDAO likeDao;
    private final UserDAO userDao;

    public BlogService() {
        this.commentDao = new CommentDAO();
        this.blogDao = new BlogDAO();
        this.likeDao = new LikeDAO();
        this.userDao = new UserDAO();
    }

    public List<BlogDTO> getAllBlogs(int page) {
        List<Blog> blogs = this.blogDao.getAllBlogsPaging(page);

        return convertBlogsToDtos(blogs);
    }

    public BlogDetailDTO getBlogDetails(int blogId) {
        Blog blog = this.blogDao.findById(blogId);

        return convertBlogToDto(blog);
    }

    public int getNoOfBlogs() {
        return this.blogDao.getNoOfBlogs();
    }

    BlogDetailDTO convertBlogToDto(Blog b) {
        return new BlogDetailDTO(
                b.getBlogId(),
                b.getUserId(),
                b.getTitle(),
                b.getContent(),
                b.getDate(),
                b.getImage(),
                b.getStatus(),
                this.likeDao.getCountByBlog(b.getBlogId()),
                this.commentDao.getCountByBlog(b.getBlogId()),
                getCommentDto(b.getBlogId())
        );
    }

    private List<CommentDTO> getCommentDto(int blogId) {
        List<Comment> cmts = this.commentDao.getAllLoadMore(blogId);
        
        return convertCmtsToDtos(cmts);
    }
    
    List<BlogDTO> convertBlogsToDtos(List<Blog> blogs) {
        List<BlogDTO> blogDtos = new ArrayList<>();
        for (Blog b : blogs) {
            blogDtos.add(new BlogDTO(
                    b.getBlogId(),
                    b.getUserId(),
                    b.getTitle(),
                    b.getContent(),
                    b.getDate(),
                    b.getImage(),
                    b.getStatus(),
                    this.likeDao.getCountByBlog(b.getBlogId()),
                    this.commentDao.getCountByBlog(b.getBlogId())
            ));
        }
        return blogDtos;
    }
    
    List<CommentDTO> convertCmtsToDtos(List<Comment> cmts) {
        List<CommentDTO> cmtDtos = new ArrayList<>();
        for (Comment c : cmts) {
            String avatar = userDao.getAvatarByUserId(c.getUserId()); // Lấy avatar từ UserDAO
            cmtDtos.add(new CommentDTO(
                    c.getCommentId(),
                    c.getUserId(),
                    c.getBlogId(),
                    this.userDao.getFullname(c.getUserId()),
                    c.getContent(),
                    c.getDate(),
                    avatar
            ));
        }
        return cmtDtos;
    }
    
    public List<BlogDTO> getTop3BlogsByLikes() {
    List<Blog> topBlogs = blogDao.getTop3BlogsByLikes(); // Gọi đến BlogDAO để lấy danh sách ba bài viết có lượt like cao nhất

    return convertBlogsToDtos(topBlogs); // Chuyển đổi danh sách các Blog sang BlogDTO
}
    
    public List<BlogDTO> getTop3BlogsByLikesDetailDTO() {
    List<Blog> topBlogs = blogDao.getTop3BlogsByLikes(); // Gọi đến BlogDAO để lấy danh sách ba bài viết có lượt like cao nhất

    return convertBlogsToDtos(topBlogs); // Chuyển đổi danh sách các Blog sang BlogDTO
}
    
    public List<BlogDTO> searchBlogs(String keyword) {
        List<Blog> blogs = this.blogDao.searchBlogs(keyword);
        return convertBlogsToDtos(blogs);
    }


}
