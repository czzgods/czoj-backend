package com.cz.czoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cz.czoj.common.ErrorCode;
import com.cz.czoj.exception.BusinessException;
import com.cz.czoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.cz.czoj.model.entity.Question;
import com.cz.czoj.model.entity.QuestionSubmit;
import com.cz.czoj.model.entity.User;
import com.cz.czoj.service.QuestionService;
import com.cz.czoj.service.QuestionSubmitService;
import com.cz.czoj.mapper.QuestionSubmitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 李钟意
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-07-14 15:16:08
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;

    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // TODO 校验编程语言是否合法
        Long questionId = questionSubmitAddRequest.getQuestionId();
        Question question = questionService.getById(questionId);
        if(question == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setUserId(loginUser.getId());
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmit.getLanguage());
        // TODO 设置初始状态
        questionSubmit.setStatus(0);
        questionSubmit.setJudgeInfo("{}");
        boolean save = questionSubmitService.save(questionSubmit);
        if(!save){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"数据插入失败");
        }
        return questionSubmit.getId();
    }
}




