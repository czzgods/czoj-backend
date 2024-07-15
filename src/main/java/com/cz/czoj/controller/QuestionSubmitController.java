package com.cz.czoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cz.czoj.annotation.AuthCheck;
import com.cz.czoj.common.BaseResponse;
import com.cz.czoj.common.ErrorCode;
import com.cz.czoj.common.ResultUtils;
import com.cz.czoj.constant.UserConstant;
import com.cz.czoj.exception.BusinessException;
import com.cz.czoj.model.dto.question.QuestionQueryRequest;
import com.cz.czoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.cz.czoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.cz.czoj.model.entity.Question;
import com.cz.czoj.model.entity.QuestionSubmit;
import com.cz.czoj.model.entity.User;
import com.cz.czoj.model.vo.QuestionSubmitVO;
import com.cz.czoj.service.QuestionSubmitService;
import com.cz.czoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        final User loginUser = userService.getLoginUser(request);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 分页获取题目提交列表（除了管理员外，普通用户只能看到非答案，提交代码等公开信息）
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        //从数据库中查询原始的题目提交分页信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        //返回脱敏信息
        User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,loginUser));
    }
}
