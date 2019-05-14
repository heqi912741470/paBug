package PC;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        HttpsURLConnection.setDefaultHostnameVerifier(new Test().new NullHostNameVerifier());
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        try {
            String reult = HttpClientOp.doGet("https://seoinsight.iok.la:5918/bdresults?is=76.164.197&cn=hwords_190510");
            System.out.println(reult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }


        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }


        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
    } };
    public class NullHostNameVerifier implements HostnameVerifier {
        /*
         * (non-Javadoc)
         *
         * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String,
         * javax.net.ssl.SSLSession)
         */
        public boolean verify(String arg0, SSLSession arg1) {
            // TODO Auto-generated method stub
            return true;
        }
    }

}
