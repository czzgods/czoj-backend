package com.cz.czoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cz.czoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.cz.czoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.cz.czoj.model.entity.QuestionSubmit;
import com.cz.czoj.model.entity.User;
import com.cz.czoj.model.vo.QuestionSubmitVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 李钟意
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-07-14 15:16:08
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */

    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);
    /**
     * 获取查询条件
     *
     * @param questionQuerySubmitRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionQuerySubmitRequest);


    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage,User loginUser);
}
