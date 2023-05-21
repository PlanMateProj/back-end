package com.planmate.server.converter;

import com.planmate.server.enums.SocialLoginType;
import lombok.Generated;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
@Generated
public class SocialLoginTypeConverter implements Converter<String, SocialLoginType> {
    @Override
    public SocialLoginType convert(String s) {
        return SocialLoginType.valueOf(s.toUpperCase());
    }
}