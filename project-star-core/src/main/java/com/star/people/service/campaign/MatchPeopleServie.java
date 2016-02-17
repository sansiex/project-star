package com.star.people.service.campaign;

import com.star.people.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.*;

/**
 * Created by zuhai.jiang on 2016/2/8.
 */
@Service
public class MatchPeopleServie {
    private Logger logger = LoggerFactory.getLogger(ArticleService.class);

    public static final int NUMBER_OF_QUESTIONS = 3;

    public int getMatchResultNum(int[] answers){
        checkNotNull(answers, "答案不能为Null");
        checkArgument(answers.length == NUMBER_OF_QUESTIONS, "答案不完整（只有%s个答案，需要%s个）", answers.length, NUMBER_OF_QUESTIONS);

        return 1;
    }

    public String[] getMatchResult(int num){
        checkArgument(num>-1 && num<NUMBER_OF_QUESTIONS, "结果错误%s", num);

        return new String[]{"张爱玲","此处省略200字分析内容。"};
    }
}
