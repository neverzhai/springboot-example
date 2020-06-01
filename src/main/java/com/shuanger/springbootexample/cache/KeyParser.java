package com.shuanger.springbootexample.cache;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;



public final class KeyParser {

    public static String parseExpressionKey(String keyExpression, Object[] args) {
        if (!keyExpression.contains(Constants.POUND_SIGN) &&
                !keyExpression.contains(Constants.SINGLE_QUOTATION_MARK)) {
            return keyExpression;
        }

        StandardEvaluationContext context = new StandardEvaluationContext();

        context.setVariable("args", args);

        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression(keyExpression);

        return expression.getValue(context, String.class);
    }
}
