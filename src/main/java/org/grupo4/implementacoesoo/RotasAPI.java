package org.grupo4.implementacoesoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class RotasAPI {
    @Autowired
    private LoginAdminFacade loginAdminFacade;

    @PostMapping
    @ResponseBody
    public ResponseMessage verificarLogin(@RequestBody LoginDTO loginAdminDTO) {
        return loginAdminFacade.verifyAdmin(loginAdminDTO);
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