package org.wellapi.api;

import java.util.Objects;

public class SendMailService{
    public String sendMail(SendMailDto sendMailDto){
        // 메일을 보낸다.
        if(Objects.isNull(sendMailDto)){
            return "실패";
        }
        String from = sendMailDto.getFrom();
        String to = sendMailDto.getTo();
        String subject = sendMailDto.getSubject();
        String content = sendMailDto.getContent();
        System.out.println("content = " + content);
        return "성공";
    }
}
