package edu.curso.agenda.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping
    fun lerTodos() : ModelAndView {
        val view = ModelAndView("home")
        view.addObject("message",
            """Este servidor é uma API Rest e deve ser chamado 
                por requisições HTTP
            """.trimMargin())
        return view
    }

}