package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class WelcomeController {

    private Double valor = 13918340.42;

    private String valorString = "200.356";

    private String vazio = "";
    private String data = "2023-05-29T10:00:00";

    private Integer check = 1;

    private String xformatoMoeda = "BRA";
    private List<String> tasks = Arrays.asList("2023-05-29T10:00:00", "2023-05-29T10:00:00", "2023-05-29T10:00:00", "2023-05-29T10:00:00");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", valor);
        model.addAttribute("data", data);
        model.addAttribute("xformatoMoeda", xformatoMoeda);
        model.addAttribute("tasks", tasks);
        model.addAttribute("valorString", valorString);
        model.addAttribute("vazio", vazio);
        model.addAttribute("check", check);

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model,
            @RequestParam(name = "param", required = false, defaultValue = "") String param) {

        model.addAttribute("message", valor);
        model.addAttribute("data", data);
        model.addAttribute("xformatoMoeda", xformatoMoeda);
        model.addAttribute("tasks", tasks);
        model.addAttribute("valorString", valorString);
        model.addAttribute("vazio", vazio);
        model.addAttribute("check", check);
        model.addAttribute("message", name);
        model.addAttribute("entrada", param);

        return "welcome"; //view
    }

    @RequestMapping(value = "/processForm", method= RequestMethod.POST)
    public String processForm(@ModelAttribute(value="foo") Foo foo) {
        System.out.println("Aoba");
        return null;
    }

}
