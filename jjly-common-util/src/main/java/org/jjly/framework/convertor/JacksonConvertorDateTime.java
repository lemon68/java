package org.jjly.framework.convertor;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * <p>将时间转换成字符串格式：yyyy-MM-dd HH:mm:ss </p>
 * @Package org.jjly.framework.convertor
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 9:47
 * @version V1.0
 */
public class JacksonConvertorDateTime extends JsonSerializer<Date>{

	@Override
	public void serialize(Date arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		arg1.writeString(DateFormatUtils.format(arg0, "yyyy-MM-dd HH:mm:ss"));
	}

}
