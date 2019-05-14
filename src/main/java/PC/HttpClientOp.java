package PC;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpClientOp {
    public static String doGet(String httpurl) throws IOException {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Cookie", "remember_token=2|297049059a1da11ace773573556de41feeac92c63803106d3d809b98205c7c23d4ef517129b83969ea3ce3054c9540516d0ddff01d8302f2db9b44b195fe3402; session=.eJxFkE-LwjAUxL9KyVmWGraXgoeV_iFCXrdLNSSLSK2xbdro0lSqEb_7Bl3Yw-Mxh_kNM3e0O_alaaRB4fcdeePr7VGI9mxjK5ycRL5YoMcMffayNNLrz7XXnrzx7JVVJY3xxqY13k9Zyze0fWxnDjhI06BwHC7SqfaAwj8iZ7HPMTScQQc4D0RE37M00bwQPUS1pZZcAccTZTEWeqOzKA-g4BMUqzZjxKc6foci9kUEGhS0lH21YLnlTGiRrnEWkUmwTccZuXFFAkhj5--u3LpMHQdUr3qKnbOgk9Dc50U9F1HTcrXUGVvfKF4H7uZgybNxZYbjbjx38vRfQR00VR8-jWpfKB6INHfYxMWTW1YsG2qbXqTUd9pyRedUJQqm14AXI4fnHAijxy_UwXnS.D7wLQA.tdiAjnXbS4J8cereQAf8V-ZdiQQ; selected-collection=hwords_190510");
            connection.setRequestProperty("Host", "seoinsight.iok.la:5918");
            connection.setRequestProperty("Referer", "https://seoinsight.iok.la:5918/auth/sign-in?next=%2F");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }
        return result;
    }

    public static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Cookie", "session=.eJwtjcEKgkAUAH9leWcJC7wIHopQOrxKiMINkXVdXbdVo7cQKf57RZ2GucxMUNRWkFYE4XUC5n4oIYTych7lKu55GkUwe3C0SpBidmhY2zM3MCGlImJOt8TuolELyOfcA0mPunDDTfUQ_lOZqTo0ax-3jc9NFvAkDbCLO57sXofTRuOoLU_Q__iYGVyiic3--d3Ob3dnNHY.D7wLEQ.b9dfe391V1vH0zICQ5-qaWVdaL0");
            connection.setRequestProperty("Host", "seoinsight.iok.la:5918");
            connection.setRequestProperty("Origin", "https://seoinsight.iok.la:5918");
            connection.setRequestProperty("Referer", "https://seoinsight.iok.la:5918/auth/sign-in?next=%2F");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
            connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        System.out.println(result);
        return result;
    }
}
