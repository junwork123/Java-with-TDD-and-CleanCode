package org.wellapi.api;

public class SendMailDto {
    private final String from;
    private final String to;
    private final String subject;
    private final String content;

    public SendMailDto(Object dto) {
        if(!(dto instanceof SendMailDto)) {
            throw new IllegalArgumentException("SendMailDto 타입이 아닙니다.");
        }
        SendMailDto param = (SendMailDto) dto;
        this.from = param.getFrom();
        this.to = param.getTo();
        this.subject = param.getSubject();
        this.content = param.getContent();
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public String getSubject() {
        return subject;
    }
    public String getContent() {
        return content;
    }
}