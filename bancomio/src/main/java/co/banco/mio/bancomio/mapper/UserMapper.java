package co.banco.mio.bancomio.mapper;


import co.banco.mio.bancomio.domain.User;
import co.banco.mio.bancomio.dto.UserDTO;

import java.util.List;

public class UserMapper {

    public static UserDTO domainToDTO (User user){
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .lastName(user.getLastName())
                .city(user.getCity())
                .status(user.getStatus())
                .userRegDate(user.getUserRegDate())
                .build();
    }

    public static User dTOToDomain (UserDTO userDTO){
        return User.builder()
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .city(userDTO.getCity())
                .status(userDTO.getStatus())
                .userRegDate(userDTO.getUserRegDate())
                .build();
    }

    public static List<UserDTO> domainToDTOList(List<User>users){
        return users.stream().map(UserMapper::domainToDTO).toList();
    }

    public static  List<User> dTOToDomainList (List<UserDTO> usersDTO){
        return  usersDTO.stream().map(UserMapper::dTOToDomain).toList();
    }
}
