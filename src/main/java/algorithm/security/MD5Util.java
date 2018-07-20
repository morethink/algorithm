package algorithm.security;

/**
 * @author 李文浩
 * @version 2017/3/26.
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Message Digest Algorithm 5(信息摘要算法5)
 */
public class MD5Util {
    /**
     * Constructs the MD5Util object and sets the string whose MD5Util is to be
     * computed.
     *
     * @param inStr
     * the <code>String</code> whose MD5Util is to be computed
     */


    public final static String COMMON_KEY = "zhongzhuoxin#@!321";

    public MD5Util() {

    }

    public final static String str2MD5(String inStr) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = inStr.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            int sum =0;
            for (int i = 0; i < md.length; i++)
                sum+=md[i];
                System.out.println(Integer.toString(16));

            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                System.out.print(str[k - 1] + " ");
                str[k++] = hexDigits[byte0 & 0xf];
                System.out.print(str[k - 1] + " ");

            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    //--MD5Util
    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String toHexString(byte[] b) { // String to byte
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static String AndroidMd5(String s) {
        try {
            // Create MD5Util Hash
            MessageDigest digest = MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {

        String m = MD5Util.str2MD5("a");
//        String m = MD5Util.str2MD5("swwwwwwwwwwdkinner");

        System.out.print(m.length() + "    ");
        System.out.println(m);

        System.out.println(m.length() + "    " + MD5Util.str2MD5("a"));

        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 计算md5函数
        md.update("liwenhao".getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        System.out.println(new BigInteger(1, md.digest()).toString(16));

    }
}