<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@page import="entity.Item"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>

            <section class="h-100 h-custom" style="background-color: #d2c9ff;">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12">
                            <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                                <div class="card-body p-0">
                                    <div class="row g-0">
                                        <div class="col-lg-8">
                                            <div class="p-5">
                                                <div class="d-flex justify-content-between align-items-center mb-5">
                                                    <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>

                                                </div>
                                                <hr class="my-4">
                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                        Image
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                                        Name
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                        Quantity
                                                    </div>
                                                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                        Price
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                    </div>
                                                </div>
                                                <hr class="my-4">

                                                <!--Danh sach san pham trong gio hang-->
                                            <%
                                                List<Item> cart = (List<Item>) session.getAttribute("cart");
                                                for (Item p : cart) {
                                            %>
                                            <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img
                                                        src="<%= p.getImage()%>"
                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">

                                                    <h6 class="text-black mb-0"><%= p.getName()%></h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>

                                                    <input id="form1" min="0" name="quantity" value="<%= p.getQuantity()%>" type="number"
                                                           class="form-control form-control-sm" />

                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0"><%= p.getPrice()%>.000 VNĐ</h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                </div>
                                            </div>
                                            <hr class="my-4">
                                            <%
                                                }
                                            %>


                                            <!--ket thuc danh sach-->
                                            <div class="pt-5">
                                                <h6 class="mb-0"><a href="home" class="text-body"><i
                                                            class="fas fa-long-arrow-alt-left me-2"></i>Continue to buy</a></h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                            <hr class="my-4">
                                            <%
                                                int totalQuantity = (int) session.getAttribute("totalQuantity");
                                                double totalPrice = (double) session.getAttribute("totalPrice");
                                            %>
                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase">Total items</h5>
                                                <h5><%= totalQuantity%></h5>

                                            </div>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Total price</h5>
                                                <h5><%= totalPrice%>.000 VNĐ</h5>
                                            </div>

                                            <!--                                            <h5 class="text-uppercase mb-3">Shipping</h5>
                                            
                                                                                        <div class="mb-4 pb-2">
                                                                                            <select class="select">
                                                                                                <option value="1">Standard-Delivery- €5.00</option>
                                                                                                <option value="2">Two</option>
                                                                                                <option value="3">Three</option>
                                                                                                <option value="4">Four</option>
                                                                                            </select>
                                                                                        </div>-->

                                            <!--                                            <h5 class="text-uppercase mb-3">Give code</h5>
                                            
                                                                                        <div class="mb-5">
                                                                                            <div class="form-outline">
                                                                                                <input type="text" id="form3Examplea2" class="form-control form-control-lg" />
                                                                                                <label class="form-label" for="form3Examplea2">Enter your code</label>
                                                                                            </div>
                                                                                        </div>-->

                                            <!--phan nut checkout-->

                                            <!--                                            <button type="button" class="btn btn-dark btn-block btn-lg"
                                                                                                data-mdb-ripple-color="dark">Checkout</button>-->


                                            <div class="text-right">
                                                <button class="btn btn-primary" onclick="checkout()">Checkout</button>
                                            </div>
                                        </div>

                                        <!-- Checkout Modal -->
                                        <div class="modal fade" id="checkoutModal" tabindex="-1" role="dialog" aria-labelledby="checkoutModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="checkoutModalLabel">Enter Customer Information</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form>
                                                            <div class="form-group">
                                                                <label for="name">Name</label>
                                                                <input type="text" class="form-control" id="name" placeholder="Enter your name">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="phone">Phone</label>
                                                                <input type="text" class="form-control" id="phone" placeholder="Enter your phone number">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="address">Address</label>
                                                                <textarea class="form-control" id="address" rows="3" placeholder="Enter your address"></textarea>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="button" class="btn btn-primary" onclick="submitForm()">Submit</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
                                        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

                                        <script>
                                                            function checkout() {
                                                                $('#checkoutModal').modal('show');
                                                            }

                                                            function submitForm() {
                                                                // Validate phone number
                                                                let phone = document.getElementById("phone").value;
                                                                let phoneRegex = /^[0-9]{10}$/;
                                                                if (!phoneRegex.test(phone)) {
                                                                    alert("Please enter a valid phone number.");
                                                                    return;
                                                                }
                                                                // Form is valid, proceed with submission
                                                                document.getElementById("checkoutForm").submit();
                                                            }
                                        </script>
                                        </body>
                                        </html>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
</html>
