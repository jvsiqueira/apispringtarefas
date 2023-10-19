package br.com.haan.ct.services;

import br.com.haan.ct.entities.Tarefas;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository tarefasRepository;

     // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;
    
    public Iterable<Tarefas> listar() {
        return tarefasRepository.findAll();
    }

   

    public ResponseEntity<?> salvar(Tarefas tarefa, String acao) {
        if (tarefa.getTitulo().equals("")) {
            respostaModelo.setMensagem("Preencher o Titulo da Tarefa!!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (tarefa.getDescricao().equals("")) {
            respostaModelo.setMensagem("Preencher a Descricao da Tarefa!!\"");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<Tarefas>(tarefasRepository.save(tarefa), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Tarefas>(tarefasRepository.save(tarefa), HttpStatus.OK);
            }
        }
    }
    
    public ResponseEntity<RespostaModelo> remover (Long id){
        tarefasRepository.deleteById(id);
        respostaModelo.setMensagem("A tarefa foi removida com sucesso.");
         return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
