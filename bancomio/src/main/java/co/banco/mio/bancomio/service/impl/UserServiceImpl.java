package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.User;
import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.mapper.UserMapper;
import co.banco.mio.bancomio.repository.UserRepository;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;
import co.banco.mio.bancomio.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDTO createUser(CreateUserRequest createUserRequest) throws Exception {

        // Validar que el objeto no sea nulo
        if (createUserRequest == null) {
            throw new Exception("El objeto usuario ha llegado null");
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createUserRequest.getName() == null
                || createUserRequest.getName().isEmpty()) {
            throw new Exception("El nombre delusuario es obligatorio");
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createUserRequest.getLastName() == null
                || createUserRequest.getLastName().isEmpty()) {
            throw new Exception("El apellido delusuario es obligatorio");
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createUserRequest.getCity() == null
                || createUserRequest.getCity().isEmpty()) {
            throw new Exception("la ciudadd del usuario es obligatorio");
        }

        User user = UserMapper.createUserRequestToDomain(createUserRequest);

        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.domainToDTO(user);

        return userDTO;
    }
}