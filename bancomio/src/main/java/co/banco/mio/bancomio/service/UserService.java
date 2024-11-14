package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;

public interface UserService {

    public UserDTO createUser(CreateUserRequest createUserRequest)throws Exception;

    public UserDTO inactivateUser(Integer userId) throws Exception;

    public UserDTO activateUser(Integer userId) throws Exception;

    public void eliminarUsuario(Integer userId) throws Exception;
}
