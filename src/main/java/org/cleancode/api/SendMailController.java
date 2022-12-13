package org.cleancode.api;

import java.util.HashMap;
import java.util.Map;

public class SendMailController implements Compute{
    private final SendMailService sendMailService = new SendMailService();
    private String sendMail(Request request){
        return sendMailService.sendMail(new SendMailDto(request.getParam("sendMailDto")));
    }

    @Override
    public void computeData(Request request, Response response) {
        String url = request.getRequestUrl();
        String result = "실패";
        switch (url){
            case "sendMail":
                result = sendMail(request);
                break;
            default:
                response.add("error", "잘못된 URL입니다.");
        }
        response.add("result", result);
    }

    public Response request(String url, Map<String, Object> params){
        Request request = new Request(url, params);
        Response response = new Response(new HashMap<>());
        computeData(request, response);
        return response;
    }
}
