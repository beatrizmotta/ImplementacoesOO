package org.grupo4.implementacoesoo;

import org.grupo4.implementacoesoo.Domain.Administrador;
import org.grupo4.implementacoesoo.Repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginAdminFacade {
//    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

    private static final Map<Long, LoginDTO> logins = new HashMap<>();

    public ResponseMessage verifyAdmin(LoginDTO loginAdminDTO) {
        String senha = loginAdminDTO.getSenha();
        String id = loginAdminDTO.getId();

        AdministradorRepository adminRepository = new AdministradorRepository();
        Administrador administrador = adminRepository.getInfo(id);

        ResponseMessage response = new ResponseMessage();

        if (administrador.getId().equals(id) && administrador.getSenha().equals(senha)) {
            response.setCode(200);
            response.setMessage("Login bem-sucedido");
        } else {
            response.setCode(400);
            response.setMessage("Não existe usuário com essas credenciais");
        }

        return response;

    }

//    public TarefaDTO criar(TarefaDTO tarefaDTO) {
//        Long proximoId = tarefas.keySet().size() + 1L;
//        String title;
//        String desc;
//        tarefas.put(proximoId, tarefaDTO);
//
//        return tarefaDTO;
//    }
//
//    public TarefaDTO atualizar(TarefaDTO tarefaDTO, Long tarefaId) {
//        tarefas.put(tarefaId, tarefaDTO);
//        return tarefaDTO;
//    }
//
//    public TarefaDTO getById(Long tarefaId) {
//        return tarefas.get(tarefaId);
//    }
//
//    public List<TarefaDTO> getAll() {
//        return new ArrayList<>(tarefas.values());
//    }
//
//    public String delete(Long tarefaId) {
//        tarefas.remove(tarefaId);
//        return "It has been deleted";
//    }

}
