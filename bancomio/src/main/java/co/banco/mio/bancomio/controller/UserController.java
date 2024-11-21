package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;
import co.banco.mio.bancomio.mapper.UserMapper;
import co.banco.mio.bancomio.repository.UserRepository;
import co.banco.mio.bancomio.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService=userService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<UserDTO> getUsers() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return UserMapper.domainToDTOList(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) throws Exception {
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PutMapping("/inactivate/{id}")
    public ResponseEntity<UserDTO> inactivarUsuario(@PathVariable Integer id) throws Exception{
        UserDTO userDTO = userService.inactivateUser(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<UserDTO> activarUsuario(@PathVariable Integer id) throws Exception{
        UserDTO userDTO = userService.activateUser(id);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id) throws Exception {
        try {
            userService.eliminarUsuario(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario eliminado exitosamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con ID " + id + " no existe.");
        }
    }
}
