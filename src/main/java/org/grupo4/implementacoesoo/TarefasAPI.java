package org.grupo4.implementacoesoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {
    @Autowired
    private LoginFacade loginFacade;

    @PostMapping
    @ResponseBody
    public ResponseMessage verificarLogin(@RequestBody LoginDTO loginDTO) {
        return loginFacade.verifyAdmin(loginDTO);
    }
//
//    @PutMapping("/{tarefaId}")
//    @ResponseBody
//    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId,
//                               @RequestBody TarefaDTO tarefaDTO) {
//        return loginFacade.atualizar(tarefaDTO, tarefaId);
//    }
//
//    @GetMapping
//    @ResponseBody
//    public List<TarefaDTO> getAll() {
//        return loginFacade.getAll();
//    }
//
//    @DeleteMapping("/{tarefaId}")
//    @ResponseBody
//    public String deletar(@PathVariable("tarefaId") Long tarefaId) {
//        return loginFacade.delete(tarefaId);
//    }
}