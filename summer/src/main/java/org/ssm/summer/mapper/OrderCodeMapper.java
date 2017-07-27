package org.ssm.summer.mapper;

import org.ssm.summer.entity.OrderCode;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/** 
 * 
 * @author  June
 * @version v1.0
 * @date 2017年7月27日 下午5:34:12
 * @since   
 */
public interface OrderCodeMapper extends BaseMapper<OrderCode> {
    
    Long insertOrderCode(OrderCode orderCode);
}
