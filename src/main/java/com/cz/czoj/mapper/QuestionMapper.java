package com.cz.czoj.mapper;

import com.cz.czoj.model.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 李钟意
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2024-07-14 15:15:19
* @Entity com.cz.czoj.model.entity.Question
*/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}




