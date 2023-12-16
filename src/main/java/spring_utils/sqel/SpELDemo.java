package spring_utils.sqel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author Xander Wu
 * @date 2023/12/11 14:30
 */
public class SpELDemo {
    public static void main(String[] args) {
        User user = new User("zhangsan", 18);
        String el1 = "#user.name";
        String el2 = "#user.age";


        // 1）构建表达式实例
        SpelExpressionParser expressionParser = new SpelExpressionParser();


        // 2）将 变量名称、变量值 放到上下文
        String variableName = "user";
        Object variableValue = user;
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable(variableName, variableValue);

        // 3）根据上下文信息，解析表达式，获取解析后的值
        Expression expression1 = expressionParser.parseExpression(el1);
        Object value1 = expression1.getValue(evaluationContext);

        Expression expression2 = expressionParser.parseExpression(el2);
        Object value2 = expression2.getValue(evaluationContext);

        System.out.println(value1);
        System.out.println(value2);

    }

}
