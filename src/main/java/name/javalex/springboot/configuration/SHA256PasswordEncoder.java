package name.javalex.springboot.configuration;

import org.h2.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class SHA256PasswordEncoder implements PasswordEncoder {

    private static final Logger LOG = LoggerFactory.getLogger(SHA256PasswordEncoder.class);


    @Override
    public String encode(CharSequence charSequence) {
        if (charSequence == null) return null;
        try {
            return encodeStringSHA256(charSequence.toString());
        } catch (NoSuchAlgorithmException e) {
            LOG.error("Cryptographic algorithm SHA-256 is requested but is not available in the environment", e);
        }
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return StringUtils.equals(encode(charSequence), s);
    }

    private String encodeStringSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(input.getBytes());

        byte[] byteData = md.digest();

        //convert byte to hex format
        StringBuffer sb = new StringBuffer();
        for (byte aByteData : byteData) {
            sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

}
