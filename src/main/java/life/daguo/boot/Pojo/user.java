package life.daguo.boot.Pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class user {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.avatar
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String avatar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.nickname
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.email
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.type
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.createTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.updateTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Date updatetime;

    public List<blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<blog> blogs) {
        this.blogs = blogs;
    }

    private List<blog> blogs = new ArrayList<>();

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", blogs=" + blogs +
                '}';
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.avatar
     *
     * @return the value of t_user.avatar
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.avatar
     *
     * @param avatar the value for t_user.avatar
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.nickname
     *
     * @return the value of t_user.nickname
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.nickname
     *
     * @param nickname the value for t_user.nickname
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.type
     *
     * @return the value of t_user.type
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.type
     *
     * @param type the value for t_user.type
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.createTime
     *
     * @return the value of t_user.createTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.createTime
     *
     * @param createtime the value for t_user.createTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.updateTime
     *
     * @return the value of t_user.updateTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.updateTime
     *
     * @param updatetime the value for t_user.updateTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}