package org.jjly.framework.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 
 * <p>
 * 提供类一些base64编码解码，十六进制编码解码，html特殊字符的转义和反转义，xml的特殊字符的转义和反转义操作
 * </p>
 * 
 * @Package org.yun.framework.encode
 * @author 黄乡南
 * @email hxiangnan@126.com
 * @date 2016-7-28 下午5:06:13
 * @version V1.0
 */
public class EncodeUtils {
	private static final String DEFAULT_URL_ENCODING = "UTF-8";

	/**
	 * 
	 * <p>
	 * 说明：对字节数组转换成十六进制的字符串
	 * </p>
	 * 
	 * @param input 要转成十六进制字符串的字节数组
	 * @return 返回字节数组对应十六进制的字符串
	 * @author 黄乡南
	 */
	public static String hexEncode(byte[] input) {
		return Hex.encodeHexString(input);
	}

	/**
	 * <p> 
	 *	说明：将十六进制的字符串还原成字节数组
	 *	</p>
	 * @param input 十六进制的字符串
	 * @return 返回十六进制的字符串对应的字节数组
	 * @author 黄乡南
	 */
	public static byte[] hexDecode(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw new IllegalStateException("Hex Decoder exception", e);
		}
	}

	/**
	 * 
	 * <p> 
	 *	说明：将数据进行base64编码
	 *	</p>
	 * @param input 要进行编码的字节数组
	 * @return 返回字节数组对应的base64编码的字符串
	 * @author 黄乡南
	 */
	public static String base64Encode(byte[] input) {
		return new String(Base64.encodeBase64(input));
	}

	/**
	 * 
	 * <p> 
	 *	说明：对url进行base64编码
	 *	</p>
	 * @param urlByte 
	 * @return 返回字节数组对应的base64编码字符串
	 * @author 黄乡南
	 */
	public static String base64UrlSafeEncode(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}

	/**
	 * 
	 * 
	 * 
	 * <p> 
	 *	说明：对base64的字符串进行解码
	 *	</p>
	 * @param input base64字符串
	 * @return 返回解码后的字节数组
	 * @author 黄乡南
	 */
	public static byte[] base64Decode(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * 
	 * <p> 
	 *	说明：将url进行url编码
	 *	</p>
	 * @param url 
	 * @return
	 * @author 黄乡南
	 */
	public static String urlEncode(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(
					"Unsupported Encoding Exception", e);
		}
	}

	/**
	 * 
	 * <p> 
	 *	说明：对被编码过的url进行解码
	 *	</p>
	 * @param ecodeUrl 被编码过的url
	 * @return 返回解码后的url
	 * @author 黄乡南
	 */
	public static String urlDecode(String ecodeUrl) {
		try {
			return URLDecoder.decode(ecodeUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(
					"Unsupported Encoding Exception", e);
		}
	}

	/**
	 * 
	 * <p> 
	 *	说明：对html字符串里的特殊字符进行转义处理,如："bread" & "butter" 转义后将输出：&quot;bread&quot; &amp; &quot;butter&quot;. 
	 *	</p>
	 * @param html
	 * @return 返回特殊字符被转义后的字符串
	 * @author 黄乡南
	 */
	public static String htmlEscape(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}

	/**
	 * 
	 * 
	 * 
	 * <p> 
	 *	说明：对html转义字符进行解码,如：&quot;bread&quot; &amp; &quot;butter&quot; 解码后将输出：."bread" & "butter"
	 *	</p>
	 * <p>
	 *  链接：
	 * </p>
	 * @param htmlEscaped
	 * @return 返回转义字符被还原的字符串
	 * @author 黄乡南
	 */
	public static String htmlUnescape(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}

	/**
	 * 
	 * <p> 
	 *	说明：对xml字符串里的特殊字符进行转义处理,如："bread" & "butter" 转义后将输出：&quot;bread&quot; &amp; &quot;butter&quot;. 
	 *	</p>
	 * @param xml
	 * @return 返回特殊字符被转义后的字符串
	 * @author 黄乡南
	 */
	public static String xmlEscape(String xml) {
		return StringEscapeUtils.escapeXml(xml);
	}

	/**
	 * 
	 * <p> 
	 *	说明：对xmlEscaped中的转义字符进行解码,如：&quot;bread&quot; &amp; &quot;butter&quot;. 转义后将输出： "bread" & "butter".
	 *	</p>
	 * @param xmlEscaped
	 * @return 返回转义字符被还原的字符串
	 * @author 黄乡南
	 */
	public static String xmlUnescape(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}
}