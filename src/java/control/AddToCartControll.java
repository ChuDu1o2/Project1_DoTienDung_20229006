/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Item;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zoro
 */
@WebServlet(name = "AddToCartControll", urlPatterns = {"/addToCart"})
public class AddToCartControll extends HttpServlet {

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

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10);
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);

        List<Item> cart = null;
        if (p != null) {
            if (session.getAttribute("cart") == null) {
                cart = new ArrayList<>();
            } else {
                cart = (List<Item>) session.getAttribute("cart");
            }
            //kiem tra
//                Item item = new Item(p.getName(),p.getImage(),1,p.getPrice());
//                cart.add(item);
            // Kiểm tra Item trùng lặp
            boolean isDuplicate = false;
            for (Item cartItem : cart) {
                if (cartItem.getName().equals(p.getName())) {
                    // Nếu có Item trùng, thực hiện các hành động tùy chọn
                    // Ví dụ: Tăng số lượng sản phẩm
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    isDuplicate = true;
                    break; // Đã tìm thấy Item trùng, thoát khỏi vòng lặp
                }
            }

            if (!isDuplicate) {
                // Nếu không có Item trùng, thêm Item vào cart
                Item item = new Item(p.getName(), p.getImage(), 1, p.getPrice());
                cart.add(item);
            }
            session.setAttribute("cart", cart);
        }

        //tinh tong tien va so luong san pham
        int totalQuantity = 0;
        double totalPrice = 0.0;
        for (Item cartItem : cart) {
            totalQuantity += cartItem.getQuantity();
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        session.setAttribute("totalQuantity", totalQuantity);
        session.setAttribute("totalPrice", totalPrice);

        response.sendRedirect("Cart_2.jsp");
        //request.setAttribute("detail", p);
//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
        // request.getRequestDispatcher("Cart_2.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
