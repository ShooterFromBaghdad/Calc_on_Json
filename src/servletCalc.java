import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.io.*;






@WebServlet(urlPatterns = "/servletCalc")
public class servletCalc extends HttpServlet {

    Map<String, Integer> map  = new HashMap<String, Integer>();
    {
        map.put("result", 0);
    }


    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuffer sb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.print("ERROR");
        }

        JsonObject json = gson.fromJson(String.valueOf(sb), JsonObject.class);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        int result = 0;
        int theFirst = json.get("fnum").getAsInt();
        int theSecond = json.get("snum").getAsInt();
        char operation = json.get("op").getAsCharacter();

        if (operation == '*') {
            result = theFirst * theSecond;
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '+') {
            result = theFirst + theSecond;
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '-') {
            result = theFirst - theSecond;
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '|') {
            result = (int)(theFirst / theSecond);
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '%') {
            result = (int)(theFirst % theSecond);
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else {
            pw.print(gson.toJson("INVALID OPERATION"));
        }

    }
}
