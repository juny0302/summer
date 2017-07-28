package org.ssm.summer.sequence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

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
    private final String sql = "insert into `%s`(gmt_create)values(current_timestamp)";

    private JdbcTemplate jdbcTemplate;
    private String sequenceTableFormat;

    /* (non-Javadoc)
     * @see org.ssm.summer.sequence.ISequenceGen#gen(java.lang.String)
     */
    @Override
    public Long gen(String ownerKey) {
        String tableName = String.format(sequenceTableFormat, ownerKey, 1);
        final String insertSql = String.format(sql, tableName);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        

        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection arg0)
                    throws SQLException {
                PreparedStatement ps = arg0.prepareStatement(insertSql, new String[] {"id"});
                return ps;
            }
        }, keyHolder);
        
        Long newId = keyHolder.getKey().longValue();
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("新插入数据的主键是：" + newId);
        }
        
        return newId;
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
