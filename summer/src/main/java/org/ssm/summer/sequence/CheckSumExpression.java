package org.ssm.summer.sequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午2:32:10
 * @since   
 */
public class CheckSumExpression implements Expression {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckSumExpression.class);

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.Expression#maxLength()
     */
    @Override
    public int maxLength() {
        return 1;
    }

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.Expression#eval(org.ssm.summer.sequence.GenContext)
     */
    @Override
    public Object eval(GenContext context) {
        Long newId = (Long) context.get("sequence");
        if (newId == null) {
            throw new RuntimeException("sequence can not be null when calculate checksum");
        }
        
        //id<< 2 | table_index
        return newId * 9 % 31 % 10;
    }

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.Expression#executeOrder()
     */
    @Override
    public ExecuteOrder executeOrder() {
        return ExecuteOrder.AfterNormal;
    }
    
    /**
     * 
    * @param args 参数
     */
    public static void main(String[] args) {
        LOGGER.debug("aa", Integer.valueOf(1 << 2 | 0));
        LOGGER.debug("", Integer.valueOf(1 << 2 | 1));
        LOGGER.debug("", Integer.valueOf(1 << 2 | 2));
        LOGGER.debug("", Integer.valueOf(1 << 2 | 3));
    }

}
