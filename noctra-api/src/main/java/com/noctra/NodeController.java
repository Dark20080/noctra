package com.noctra;

import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.*;

@RestController
public class NodeController {

    @GetMapping("/status")
    public String getStatus() {
        try {
            URL url = new URL("http://localhost:1317/node_info");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();
            return response.toString();

        } catch (Exception e) {
            return "{\"error\": \"Falha ao contactar o nó\"}";
        }
    }
}

