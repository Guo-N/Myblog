package life.daguo.boot.Dao;

import java.util.List;
import life.daguo.boot.Pojo.comment;
import life.daguo.boot.Pojo.commentExample;
import org.apache.ibatis.annotations.Param;

public interface commentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int countByExample(commentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int deleteByExample(commentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int insert(comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int insertSelective(comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    List<comment> selectByExample(commentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    comment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByExampleSelective(@Param("record") comment record, @Param("example") commentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByExample(@Param("record") comment record, @Param("example") commentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByPrimaryKeySelective(comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Mon May 31 15:02:22 CST 2021
     */
    int updateByPrimaryKey(comment record);
}