package life.daguo.boot.Dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import life.daguo.boot.Pojo.blog;
import life.daguo.boot.Pojo.blogExample;
import org.apache.ibatis.annotations.Param;

public interface blogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int countByExample(blogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int deleteByExample(blogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int insert(blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int insertSelective(blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    List<blog> selectByExample(blogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    blog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByExampleSelective(@Param("record") blog record, @Param("example") blogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByExample(@Param("record") blog record, @Param("example") blogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByPrimaryKeySelective(blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByPrimaryKey(blog record);
    List<blog> findTop(PageInfo<blog> page);
    void updateViews(Integer id);
    List<String> findGroupYear();
    List<blog> getBlogByYear(String year);
}