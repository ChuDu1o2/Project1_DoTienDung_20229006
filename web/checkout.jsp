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

        <div class="container mt-5 px-5">

            <div class="mb-4">
                <h2>Confirm order</h2>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <div class="card p-3">
                        <h6 class="text-uppercase">Order details</h6>
                        <div class="inputbox mt-3"> <input type="text" name="name" class="form-control" required="required"> <span>Name</span> </div>
                        <div class="inputbox mt-3"> <input type="tel" name="phone" class="form-control" required="required" placeholder="123-45-678" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"> <span>Enter a phone number:</span> </div>
                        <div class="inputbox mt-3"> <input type="text" name="address" class="form-control" required="required"> <span>Address</span> </div>

                    </div>
                    <div class="mt-4 mb-4 d-flex justify-content-between">
                        <div class="pt-5">
                            <h6 class="mb-0"><a href="home" class="text-body"><i
                                        class="fas fa-long-arrow-alt-left me-2"></i>Back to home page</a></h6>
                        </div>
                        <button class="btn btn-success px-3">Pay $840</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
</html>
