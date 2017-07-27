package org.ssm.summer.sequence;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午4:09:51
 * @since   
 */
@Component
public class BitwiseLoadBalanceSequenceGen {

    /**
     * 将timeout判断的阈值设置为一个很大的值， 避免timeout应用error的情况发生
     */
    private Integer timeoutThresholdInMilliseconds;
    /**
     * 超时多少次后会移出可用列表 
     */
    private Integer timeoutEventCountThreshold;
    
    /**
     * 计算超时异常的时间周期， 以秒为单位
     */
    private Integer timeoutTimeThresholdInSeconds;
    
    /**
     * 移到不可用队列多长时间后会被重新放入可用队列
     */
    private Integer onErrorRescueThresholdInSeconds;

    private Integer leftShiftCount;
    

    private Map<String, SequenceGen> availablePartitionIndices;
    
    public BitwiseLoadBalanceSequenceGen(Integer arg0, Map<String, SequenceGen> arg1) {
        this.leftShiftCount = arg0;
        this.availablePartitionIndices = arg1;
    }
    
    public long gen(String ownerKey) {
        return 1L;
    }


    /**
     * @return the timeoutThresholdInMilliseconds
     */
    public Integer getTimeoutThresholdInMilliseconds() {
        return timeoutThresholdInMilliseconds;
    }


    /**
     * @param timeoutThresholdInMilliseconds the timeoutThresholdInMilliseconds to set
     */
    public void setTimeoutThresholdInMilliseconds(Integer timeoutThresholdInMilliseconds) {
        this.timeoutThresholdInMilliseconds = timeoutThresholdInMilliseconds;
    }


    /**
     * @return the timeoutEventCountThreshold
     */
    public Integer getTimeoutEventCountThreshold() {
        return timeoutEventCountThreshold;
    }


    /**
     * @param timeoutEventCountThreshold the timeoutEventCountThreshold to set
     */
    public void setTimeoutEventCountThreshold(Integer timeoutEventCountThreshold) {
        this.timeoutEventCountThreshold = timeoutEventCountThreshold;
    }


    /**
     * @return the timeoutTimeThresholdInSeconds
     */
    public Integer getTimeoutTimeThresholdInSeconds() {
        return timeoutTimeThresholdInSeconds;
    }


    /**
     * @param timeoutTimeThresholdInSeconds the timeoutTimeThresholdInSeconds to set
     */
    public void setTimeoutTimeThresholdInSeconds(Integer timeoutTimeThresholdInSeconds) {
        this.timeoutTimeThresholdInSeconds = timeoutTimeThresholdInSeconds;
    }


    /**
     * @return the onErrorRescueThresholdInSeconds
     */
    public Integer getOnErrorRescueThresholdInSeconds() {
        return onErrorRescueThresholdInSeconds;
    }


    /**
     * @param onErrorRescueThresholdInSeconds the onErrorRescueThresholdInSeconds to set
     */
    public void setOnErrorRescueThresholdInSeconds(Integer onErrorRescueThresholdInSeconds) {
        this.onErrorRescueThresholdInSeconds = onErrorRescueThresholdInSeconds;
    }
    
    
}
