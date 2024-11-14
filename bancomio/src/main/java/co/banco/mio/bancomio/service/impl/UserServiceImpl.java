package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.User;
import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.mapper.UserMapper;
import co.banco.mio.bancomio.repository.UserRepository;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;
import co.banco.mio.bancomio.service.UserService;
import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.State;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
            throw new Exception(Message.OBJECT_NULL.getMessage());
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createUserRequest.getName() == null
                || createUserRequest.getName().isEmpty()) {
            throw new Exception(String.format(Message.SIZE_DESCRIPTION.getMessage(), 100));
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createUserRequest.getLastName() == null
                || createUserRequest.getLastName().isEmpty()) {
            throw new Exception(String.format(Message.SIZE_DESCRIPTION.getMessage(), 100));
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createUserRequest.getCity() == null
                || createUserRequest.getCity().isEmpty()) {
            throw new Exception(String.format(Message.SIZE_DESCRIPTION.getMessage(), 100));
        }

        User user = UserMapper.createUserRequestToDomain(createUserRequest);

        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.domainToDTO(user);

        return userDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDTO inactivateUser(Integer userID) throws Exception {

        User user = findById(userID);

        if (user.getStatus().equals(State.INACTIVE)) {
            throw new Exception(
                    String.format(
                            Message.USUARIO_EN_ESTADO.getMessage(),
                            user.getUserId(), State.INACTIVE.getValue()
                    )
            );
        }

        user.setStatus(State.INACTIVE.getValue());
        user = userRepository.save(user);
        return UserMapper.domainToDTO(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDTO activateUser(Integer userID) throws Exception {
        User user = findById(userID);

        if (user.getStatus().equals(State.ACTIVE)) {
            throw new Exception(
                    String.format(
                            Message.USUARIO_EN_ESTADO.getMessage(),
                            user.getUserId(), State.ACTIVE.getValue()
                    )
            );
        }

        user.setStatus(State.ACTIVE.getValue());
        user = userRepository.save(user);
        return UserMapper.domainToDTO(user);
    }

    @Override
    @Transactional
    public void eliminarUsuario(Integer userId) throws Exception {

        User user = findById(userId);

        if (user!=null) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalArgumentException("El usuario con ID " + userId + " no existe.");
        }

    }

    @Transactional(readOnly = true)
    protected User findById(Integer id) throws Exception {
        // Consultar la categoría y si no la encuentra, lanza excepcion
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new Exception(
                                String.format(Message.NO_EXISTE_USUARIO_X_ID.getMessage(), id)
                        )
                );
    }
}
