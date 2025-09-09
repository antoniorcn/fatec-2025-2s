package edu.curso.agenda

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping
    fun homePage() : ModelAndView {
        val mensagem = """
            Este sistema é uma API Rest, 
            portanto deve ser acessado por 
            meio de requisições HTTP para a API
        """.trimIndent()
        val modelView = ModelAndView("home")
        modelView.addObject("MESSAGE", mensagem)
        return modelView
    }
}