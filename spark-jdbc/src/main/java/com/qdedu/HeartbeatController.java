/**
 * MainController.java
 * com.qdedu
 * Copyright (c) 2017, 北京聚智未来科技有限公司版权所有.
*/

package com.qdedu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * 心跳控制器
 *
 * @author   ZhuangJunxiang(529272571@qq.com)
 * @Date	 2017年4月10日
 */
@Controller
@RequestMapping("/heartbeat")
@Api(value = "/heartbeat", description = "跳检测控制器",hidden = true)
@org.springframework.context.annotation.Configuration
@EnableApolloConfig(value = "application", order = 1)
public class HeartbeatController {

	@ResponseBody
	@GetMapping("alive")
	@ApiOperation(value = "心跳")
	public Object alive() {
		return "I'm alive!!! Don't worry ^_^";
	}
}
