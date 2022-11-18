package ClienteAPI.ClienteAPI;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/cliente/v1"})
public class Controller {
    @Autowired
    Repository repository;

    public Controller() {
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        Cliente clienteSaved = (Cliente)this.repository.save(cliente);
        return clienteSaved;
    }

    @GetMapping({"/{id}"})
    @ResponseBody
    public Optional<Cliente> getClineteById(@PathVariable Long id) {
        Optional<Cliente> clienteReturned = this.repository.findById(id);
        return clienteReturned;
    }

    @DeleteMapping({"/{id}"})
    public String deleteClienteById(@PathVariable Long id) {
        try{
            Optional<Cliente> cliente = Optional.of(repository.getById(id));
            if(cliente.isPresent()){
                repository.deleteById(id);
                return  "Cliente de " + id + "deletado com sucesso!";
            }else{
                throw new Exception("Cliente inexistente!");
            }

        }catch(Exception e){
            e.printStackTrace();
            return "O cliente de " + id + " não existe para ser deletado" +
                    " Por favor, entre em contato com o atendimento 666 666 666 ";
        }

    }

    @GetMapping
    public List<Cliente> listClientes(){
        return repository.findAll();
    }

}

