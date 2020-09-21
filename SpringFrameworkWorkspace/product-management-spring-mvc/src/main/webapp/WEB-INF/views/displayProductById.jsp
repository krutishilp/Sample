<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
            <caption><h3>Result:</h3></caption>
            <thead>
                <tr class="tr tr-success">
                    <td>Product Id</td>
                    <td>Product Name</td>
                    <td>Product Cost</td>
                </tr>   
            </thead>
            <tbody>
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productCost}</td>
                    </tr>
            </tbody>
        </table>
</body>
</html>