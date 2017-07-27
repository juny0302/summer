package org.ssm.summer.sequence;
/** 
 * SmartSNGen表达式接口
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午2:30:40
 * @since   
 */
public interface Expression {
    /**
     * 计算表达式的值
     * @param context 表达式计算上下文， 表达式可以根据需要将计算中间值存储到上下文中， 以便在表达式之间共享数据
     * @return 表达式计算值
     */
    Object eval(GenContext context);

    /**
     * 计算优先级， 优先级越高越先执行， 如果表达式需要依赖其他表达式的值， 则要在依赖表达式计算之后执行
     * @return 执行顺序
     */
    ExecuteOrder executeOrder();

    /**
     * 该表达式的最大字符串长度值
     *
     * @return 最大长度值
     */
    int maxLength();
}
