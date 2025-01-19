package com.korit.servlet_study.servlet.Hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.entity.BookTemp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/api/book")
public class BookRestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BookTemp bt = BookTemp.builder()
                .bookId("1")
                .bookName("책이름뭘로하지")
                .author("노진구작가")
                .publisher("출판사")
                .category("카테고리")
                .imgUrl("대충url")
                .build();

        String jsonBt = objectMapper.writeValueAsString(bt);

        System.out.println(jsonBt);

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        resp.setContentType("application/json");

        resp.getWriter().println(jsonBt);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
