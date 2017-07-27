package org.ssm.summer.sequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

/** 
 * 通过表的自增列生成单号.
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午2:21:01
 * @since   
 */
@Component
public class AutoIncrementTablesSequenceGen implements SequenceGen {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoIncrementTablesSequenceGen.class);

    private DruidDataSource dataSource;
    private String sequenceTableFormat;

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.ISequenceGen#gen(java.lang.String)
     */
    @Override
    public Long gen(String ownerKey) {
        return 1L;
    }

    /**
     * @return the dataSource
     */
    public DruidDataSource getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the sequenceTableFormat
     */
    public String getSequenceTableFormat() {
        return sequenceTableFormat;
    }

    /**
     * @param sequenceTableFormat the sequenceTableFormat to set
     */
    public void setSequenceTableFormat(String sequenceTableFormat) {
        this.sequenceTableFormat = sequenceTableFormat;
    }
    
    
}
