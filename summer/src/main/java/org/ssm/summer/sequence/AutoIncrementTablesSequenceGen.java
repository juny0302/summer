package org.ssm.summer.sequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 通过表的自增列生成单号.
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午2:21:01
 * @since   
 */
public class AutoIncrementTablesSequenceGen implements SequenceGen {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoIncrementTablesSequenceGen.class);


    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.ISequenceGen#gen(java.lang.String)
     */
    @Override
    public Long gen(String ownerKey) {
        return 1L;
    }
}
