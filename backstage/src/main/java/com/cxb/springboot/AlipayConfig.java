package com.cxb.springboot;



import java.io.FileWriter;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102100731136";
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFBzPxO8DhfFSqfh6yRe3r76U/qhknzx2Y51vmeA4az5dBM3quq7YErBU8b4v/covjq3R5bWsL1KABEHuVPPhMPNh2KjQzBYjr+FbU4G2t7e8BJTgaqyP/RWuw4as+wbXCKugdEgyMMtY94Rw7Myt4JbT91q0pFWfosTmgkpRvfDLM9I6Ju9RpF57hvXIGTqFl9di6W4MRleRUDX5y/StDdPHCGXj3nPpA9FauFHTl1nGtJIdEMqMQNRGjLsdEUcvfQI/KgQ04Tn0yDu3xhFRwUZlOtpRVgC5N3cBoSfuTiUSyq1IMMHxD1Z6Fd+sXPSR+2tl6REfoBvB0/T6l6To1AgMBAAECggEAUKI7Ar3mmSFt8Px+iY0O6uD/qwdtFhqwTTRaKv71HsnYaAmuaq/BZTYb1sj77YYuc/VmTI+YIJZbCTR6rz/tih3YpLtu83aPa6sNtj9HA8h9aOWXiWqC5+S8Rv6EO8HBJf6zUbpiQjpH7bkj+aJeZuRfpwblhQvKo7NsFygF8X2Vefrheg9/74MywnafWJiPC4QpIjLYEUKe+gfZpy6nFE0d+szGdpH0KAqE2nPgY5djBvfj77NdIyXMhKXNgxBD3iiP/Bxio1vT+/lUwufNJR3Gh63DgeSNns7zkpnXuvQB/EkKwOFOg/mByp+VVNPImqPIr1hwHc3gzMMLdopooQKBgQDwQhzGG5gn3A2fGwZOS/fyLgVuAIE1O0rENZb3VeZAiff7sJ22DKM7XmgRCsuCS7BGHvr246CEfl59PIQEn974rQff64JasS2vqusll+U/Fyq/k0KsuhChzhSrbBXKD4LFJYUS9AqTY99ZYxRUEcnkG1Z0GRsH09C3lu2MEqT/3QKBgQDR7/w9U1Gc7RFOzO9XRuyd8RiQxJmxaqQeWNSzDD/ovVyGgosgPkTKBhOeIxn118ghF0OaXW18+NYYmetZIsj8drNzSLf7jqeNb8zBituCwreyFDdZ2geZ+4I8tIc/rp3Zn1nax5b5Hgp4EF1sqGDOkq8FEllQNRCem8PQh9oqOQKBgQCmkH8YTSsofyOmaXrurzY/XO6Au7LYL7n+21RFNvVBSyV0BZbhDlPgJewp3H0IYObdRj8hCOBQ2rcxRdIUzq0rY/IwqDqgG3Ob9Pe/AVZ6bdpCJJq12u0K8C9eRLm6cxRrDz75y9zFIBlJBCqkugxoqxc9t+YIgC2UCfu3/3kKtQKBgQC/d4tqduHZKFF/t+KVi+bjiW6pIdU2fRcfYk7i2Uo0Pvfy6X5vsrrUMcSUlljn4ZvxqiEK2SixMNU6bK67hcEemDfD7c92iz1+/jcVUUowMNyOemec9/+0zTCTouYzC1OFlhLCOQQVQfO0WuCJ5+sam6cqDfkM8Miuj0uAlVZA6QKBgERmbK5/sss87ihv6nk0RU3c8z/ne1SQUJbWPsDb7sWLMZvQsImy2LjwnIgyU07DqHxyWREfotqpfa/RnlZIKwLXCNoyZmLtI+XJiL0jSydhLfnohpAAxDpgK5n87mrdpoOElOq+imIDLHKiWEzqbe2cJ8rEn34gqYIOxOqruJqr";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxQcz8TvA4XxUqn4eskXt6++lP6oZJ88dmOdb5ngOGs+XQTN6rqu2BKwVPG+L/3KL46t0eW1rC9SgARB7lTz4TDzYdio0MwWI6/hW1OBtre3vASU4Gqsj/0VrsOGrPsG1wiroHRIMjDLWPeEcOzMreCW0/datKRVn6LE5oJKUb3wyzPSOibvUaRee4b1yBk6hZfXYuluDEZXkVA1+cv0rQ3Txwhl495z6QPRWrhR05dZxrSSHRDKjEDURoy7HRFHL30CPyoENOE59Mg7t8YRUcFGZTraUVYAuTd3AaEn7k4lEsqtSDDB8Q9WehXfrFz0kftrZekRH6AbwdP0+pek6NQIDAQAB";
	
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址";
	
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8082/backstage/ali_finish";

	// 签名方式
	public static String sign_type = "RSA2";
	// 字符编码格式
	public static String charset = "utf-8";
	// 支付宝网关 
	public static String gatewayUrl ="https://openapi.alipaydev.com/gateway.do";
	// 支付宝网关
	public static String log_path = "C:\\";
	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ /** * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	// * @param sWord 要写入日志里的文本内容 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}