package org.example.emptest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@Slf4j
public class ErrorController {

    @GetMapping("/error")
    public String error() {
        return "/error";
    }

    @GetMapping("/error-400")
    public void error400(HttpServletResponse resp) throws IOException {
        resp.sendError(400, "400 binding 오류");
    }

    @GetMapping("/error-404")
    public void error404(HttpServletResponse resp) throws IOException {
        resp.sendError(404, "404 요청 페이지 오류");
    }

    @GetMapping("/error-4xx")
    public void error4xx(HttpServletResponse resp) throws IOException {
        resp.sendError(499, "클라이언트 요청 오류");
    }

    @GetMapping("/error-500")
    public void error500(HttpServletResponse resp) throws IOException {
        resp.sendError(500, "500 서버 오류");
    }

    @GetMapping("/error-5xx")
    public void error5xx(HttpServletResponse resp) throws IOException {
        resp.sendError(599, "서버 오류");
    }
}
