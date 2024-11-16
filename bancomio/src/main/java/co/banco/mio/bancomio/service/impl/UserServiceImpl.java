package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.User;
import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.mapper.UserMapper;
import co.banco.mio.bancomio.repository.UserRepository;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;
import co.banco.mio.bancomio.service.UserService;
import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.State;
import co.banco.mio.bancomio.utils.UserMessage;
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
            throw new Exception(Message.OBJECT_NULL);
        }

        User user = UserMapper.createUserRequestToDomain(createUserRequest);

        user = userRepository.save(user);

        return UserMapper.domainToDTO(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDTO inactivateUser(Integer userID) throws Exception {

        User user = findById(userID);

        if (user.getStatus().equals(State.INACTIVE)) {
            throw new Exception(
                    String.format(
                            UserMessage.STATUS_USER,
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
                            UserMessage.STATUS_USER,
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
            throw new IllegalArgumentException(UserMessage.NOT_FOUND_USER);
        }

    }

    @Transactional(readOnly = true)
    protected User findById(Integer id) throws Exception {
        // Consultar la categoría y si no la encuentra, lanza excepcion
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new Exception(
                                String.format(UserMessage.NOT_FOUND_USERID, id)
                        )
                );
    }
}
