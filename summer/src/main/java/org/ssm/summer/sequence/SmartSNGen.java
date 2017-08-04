package org.ssm.summer.sequence;
/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年8月1日 下午4:41:32
 * @since   
 */
public class SmartSNGen {

    private String format;
    private SmartInterpreter interpreter;
    
    /**
     * 
     * @param format 表达式字符串
     */
    public SmartSNGen(String format){
        this.format = format;        
    }
    
    public String genSN(){
        return "";
    }

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

    /**
     * @return the interpreter
     */
    public SmartInterpreter getInterpreter() {
        return interpreter;
    }

    /**
     * @param interpreter the interpreter to set
     */
    public void setInterpreter(SmartInterpreter interpreter) {
        this.interpreter = interpreter;
    }
    
    
    
    
    
    
}
