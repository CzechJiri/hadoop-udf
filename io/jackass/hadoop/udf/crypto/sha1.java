package io.jackass.hadoop.hive.udf.crypto;
 
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
 
import java.security.*;
import org.apache.commons.codec.binary.Base64;
 
public final class sha1 extends UDF {
 
    public Text evaluate(final Text s) {
        if (s == null) {
                return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(s.toString().getBytes());
            byte[] hash = md.digest();
              Base64 encoder = new Base64();
 
        return new Text(encoder.encodeToString(hash));
        } catch (NoSuchAlgorithmException nsae) {
            throw new IllegalArgumentException("SHA1 is not setup");
        }
    }
}
