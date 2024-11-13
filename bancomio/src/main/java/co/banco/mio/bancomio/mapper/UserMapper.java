package co.banco.mio.bancomio.mapper;


import co.banco.mio.bancomio.domain.User;
import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.dto.request.CreateUserRequest;
import co.banco.mio.bancomio.utils.State;

import java.time.LocalDateTime;
import java.util.List;

public class UserMapper {

    public static UserDTO domainToDTO (User user){
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .lastName(user.getLastName())
                .city(user.getCity())
                .status (user.getStatus())
                .build();
    }

    public static User dTOToDomain (UserDTO userDTO){
        return User.builder()
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .city(userDTO.getCity())
                .status(userDTO.getStatus())
                .userRegDate(LocalDateTime.now())
                .build();
    }

    public static List<UserDTO> domainToDTOList(List<User>users){
        return users.stream().map(UserMapper::domainToDTO).toList();
    }

    public static  List<User> dTOToDomainList (List<UserDTO> usersDTO){
        return  usersDTO.stream().map(UserMapper::dTOToDomain).toList();
    }

    public static User createUserRequestToDomain (CreateUserRequest userRequest){
        return User.builder()
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .city(userRequest.getCity())
                .status(State.ACTIVE.getValue())
                .userRegDate(LocalDateTime.now())
                .build();
    }
}
