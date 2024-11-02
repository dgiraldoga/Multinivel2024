package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;

public interface UserService {

    public UserDTO createUser(CreateUserRequest createUserRequest)throws Exception;
}
