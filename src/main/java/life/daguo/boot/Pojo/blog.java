package life.daguo.boot.Pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class blog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.title
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.content
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.firstPicture
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String firstpicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.flag
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String flag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.views
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Integer views;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.appreciation
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Boolean appreciation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.shareStatement
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Boolean sharestatement;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.commentabled
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Boolean commentabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.published
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Boolean published;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.recommend
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Boolean recommend;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.createTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.updateTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.type_id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Integer typeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.user_id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.description
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    private String description;


    @Override
    public String toString() {
        return "blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstpicture='" + firstpicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", sharestatement=" + sharestatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                '}';
    }

    public life.daguo.boot.Pojo.type getType() {
        return type;
    }

    public void setType(life.daguo.boot.Pojo.type type) {
        this.type = type;
    }

    public List<tag> getTags() {
        return tags;
    }

    public void setTags(List<tag> tags) {
        this.tags = tags;
    }

    public life.daguo.boot.Pojo.user getUser() {
        return user;
    }

    public void setUser(life.daguo.boot.Pojo.user user) {
        this.user = user;
    }

    public List<comment> getComments() {
        return comments;
    }

    public void setComments(List<comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    private type type;
    private List<tag> tags = new ArrayList<>();

    private user user;
    private List<comment> comments = new ArrayList<>();
    private String tagIds;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.id
     *
     * @return the value of t_blog.id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.id
     *
     * @param id the value for t_blog.id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.title
     *
     * @return the value of t_blog.title
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.title
     *
     * @param title the value for t_blog.title
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.content
     *
     * @return the value of t_blog.content
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.content
     *
     * @param content the value for t_blog.content
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.firstPicture
     *
     * @return the value of t_blog.firstPicture
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getFirstpicture() {
        return firstpicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.firstPicture
     *
     * @param firstpicture the value for t_blog.firstPicture
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setFirstpicture(String firstpicture) {
        this.firstpicture = firstpicture == null ? null : firstpicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.flag
     *
     * @return the value of t_blog.flag
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.flag
     *
     * @param flag the value for t_blog.flag
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.views
     *
     * @return the value of t_blog.views
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Integer getViews() {
        return views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.views
     *
     * @param views the value for t_blog.views
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.appreciation
     *
     * @return the value of t_blog.appreciation
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Boolean getAppreciation() {
        return appreciation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.appreciation
     *
     * @param appreciation the value for t_blog.appreciation
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.shareStatement
     *
     * @return the value of t_blog.shareStatement
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Boolean getSharestatement() {
        return sharestatement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.shareStatement
     *
     * @param sharestatement the value for t_blog.shareStatement
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setSharestatement(Boolean sharestatement) {
        this.sharestatement = sharestatement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.commentabled
     *
     * @return the value of t_blog.commentabled
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Boolean getCommentabled() {
        return commentabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.commentabled
     *
     * @param commentabled the value for t_blog.commentabled
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setCommentabled(Boolean commentabled) {
        this.commentabled = commentabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.published
     *
     * @return the value of t_blog.published
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.published
     *
     * @param published the value for t_blog.published
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.recommend
     *
     * @return the value of t_blog.recommend
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.recommend
     *
     * @param recommend the value for t_blog.recommend
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.createTime
     *
     * @return the value of t_blog.createTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.createTime
     *
     * @param createtime the value for t_blog.createTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.updateTime
     *
     * @return the value of t_blog.updateTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.updateTime
     *
     * @param updatetime the value for t_blog.updateTime
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.type_id
     *
     * @return the value of t_blog.type_id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.type_id
     *
     * @param typeId the value for t_blog.type_id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.user_id
     *
     * @return the value of t_blog.user_id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.user_id
     *
     * @param userId the value for t_blog.user_id
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.description
     *
     * @return the value of t_blog.description
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.description
     *
     * @param description the value for t_blog.description
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}