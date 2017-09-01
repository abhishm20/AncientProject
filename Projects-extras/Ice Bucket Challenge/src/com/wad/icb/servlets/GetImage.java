package com.wad.icb.servlets;



import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;






@WebServlet("/GetImage.icb")
public class GetImage extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImage() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
     int id = Integer.parseInt(request.getParameter("id"));
      ServletOutputStream outputStream;
      
      InputStream inputStream = GetImage.class.getResourceAsStream("person/"+id+".jpg");
      
      try
      {
      byte[] bytes = IOUtils.toByteArray(inputStream);

      response.setContentType("image/jpeg");
       outputStream = response.getOutputStream();
      outputStream.write(bytes);
      outputStream.close();
     } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
     }
    
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
   }

}