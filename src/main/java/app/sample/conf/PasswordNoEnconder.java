package app.sample.conf;

import org.springframework.security.crypto.password.PasswordEncoder;

/** 平文でのパスワード認証 */
public class PasswordNoEnconder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}