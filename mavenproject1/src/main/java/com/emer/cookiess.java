/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "cookiess", urlPatterns = {"/cookiess"})
public class cookiess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int contador =0;
      Cookie[] cukis=request.getCookies();
      if(cukis!=null){
          for(Cookie c:cukis){
              if(c.getName().equals("vistas")){
                  contador = Integer.parseInt(c.getValue());
              }
          }     
      }
 contador++;
         Cookie c = new Cookie ("vistas",Integer.toString(contador));
         c.setMaxAge(3600);
         response.addCookie(c);
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         //out.print("visita numero: "+cookiess);
         if(contador ==1){
             out.print("BIENVENIDO A NUESTRO SITIO WEB");
         }else{
              out.print("GRACIAS POR VISITARNOS NUEVAMENTE");  
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
