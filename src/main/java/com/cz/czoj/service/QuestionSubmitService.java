package com.cz.czoj.service;

import com.cz.czoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.cz.czoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cz.czoj.model.entity.User;

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
}
