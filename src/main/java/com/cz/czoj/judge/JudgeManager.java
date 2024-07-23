package com.cz.czoj.judge;

import com.cz.czoj.judge.strategy.DefaultJudgeStrategy;
import com.cz.czoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.cz.czoj.judge.strategy.JudgeContext;
import com.cz.czoj.judge.strategy.JudgeStrategy;
import com.cz.czoj.model.dto.questionsubmit.JudgeInfo;
import com.cz.czoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
