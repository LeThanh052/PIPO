package com.pipo.backend.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import jakarta.servlet.http.HttpServletResponse;
import com.pipo.backend.domain.response.RestResponse;
import com.pipo.backend.util.annotation.ApiMessage;

@ControllerAdvice
public class FormatRestResponse implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,

            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {

        HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
        int status = servletResponse.getStatus();

        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setStatusCode(status);

        if (body instanceof String) {
            return body;
        }

        if (body instanceof RestResponse) {
            return body;
        }

        if (status >= 400) {
            return body;
        } else {
            restResponse.setData(body);
            ApiMessage message = returnType.getMethodAnnotation(ApiMessage.class);
            restResponse.setMessage(message != null ? message.value() : "CALL API SUCCESS");
        }
        return restResponse;
    }

}
