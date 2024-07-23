package com.cz.czoj.judge;

import com.cz.czoj.model.entity.QuestionSubmit;
import com.cz.czoj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
