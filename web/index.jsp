<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 20.08.2020
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>ONLImE C@LCYL@T0R</title>
    </head>
    <body>
        <h1>Домашняя страница простейшего онлайн калькулятора</h1><br/>
            Введите 2 числа и арифметическую операцию:

        <form method="get" action="servletCalc">
              <label>First number:
                  <input type="text" name="fnum"></br>
              </label><br/>
              <label>Second number:
                  <input type="text" name="snum"></br>
              </label><br/>
              <label>Operation:
                  <input type="text" name="op"></br>
              </label>

            <button type="submit">Поcчитать</button>
        </form>
    </body>
</html>
