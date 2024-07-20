package com.julioluis.messages.functions;

import com.julioluis.messages.dto.AccountMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private final static Logger logger = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccountMsgDto,AccountMsgDto> email() {
        return accountMsgDto -> {
            logger.info("Sending email with detail "+ accountMsgDto.toString());
            return accountMsgDto;
        };
    }

    @Bean
    public Function<AccountMsgDto,String> sms() {
        return accountMsgDto -> {
            logger.info("Sending sms with detail "+ accountMsgDto.toString());
            return accountMsgDto.accountNumber();
        };
    }
}
