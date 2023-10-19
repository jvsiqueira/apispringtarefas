package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Tarefas;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins = "*")
public class TarefasController {
       
    @Autowired
    private TarefasService tarefasService;
    
    @GetMapping("/tarefas")
    public Iterable<Tarefas> buchadaDeBodeDoMercadoPublico(){
        return tarefasService.listar();
    }
    
    @PostMapping("/tarefas")
    public ResponseEntity<?> salvar (@RequestBody Tarefas tarefa){
        return tarefasService.salvar(tarefa,"Salvar");
    }
    
    @PutMapping("/tarefas")
    public ResponseEntity<?> atualizar (@RequestBody Tarefas tarefa){
        return tarefasService.salvar(tarefa,"Atualizar");
    }
    
    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return tarefasService.remover(id);
    }
}
