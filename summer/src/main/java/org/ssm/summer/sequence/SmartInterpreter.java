package org.ssm.summer.sequence;

import java.util.Iterator;

/** 
 * 单号生成器的表达式解释器
 * @author  June
 * @version v1.0
 * @date 2017年8月1日 下午4:42:00
 * @since   
 */
public class SmartInterpreter implements Iterator<Expression> {
    private String format = "";


    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    @Override
    public Expression next() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }
    
     
            
    
}
