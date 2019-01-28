package com.auth.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class HashingClass
        implements PasswordEncoder
{
    public String encode(CharSequence paramCharSequence)
    {
        //return Hashing.sha1().hashString(paramCharSequence, Charsets.UTF_8).toString();
        return paramCharSequence.toString();
    }

    public boolean matches(CharSequence paramCharSequence, String paramString)
    {
        //return encode(paramCharSequence).equals(paramString);
        return paramCharSequence.equals(paramString);
    }

}
