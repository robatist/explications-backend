package com.robatist.backend.backend.service.mapper;

import com.robatist.backend.backend.domain.user.User;
import com.robatist.backend.backend.service.model.user.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    /**
     * Method to map a list of Users {@link User} to a list of UsersDTO {@link UserDTO}
     *
     * @param userList the data source
     * @return the one list {@link List} of UsersDTO {@link UserDTO}
     */
    public List<UserDTO> mapUserListToUserDTOList(final List<User> userList) {
        return Objects.nonNull(userList) ?
                userList.stream().map(this::mapUserToUserDTO).collect(Collectors.toList())
                : null;
    }

    /**
     * Method to map an User {@link User} to an UserDTO {@link UserDTO}
     *
     * @param user the data source
     * @return the one UserDTO object {@link UserDTO}
     */
    public UserDTO mapUserToUserDTO(final User user) {
        return Objects.nonNull(user) ?
                new UserDTO.UserDTOBuilder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .age(user.getAge())
                        .nif(user.getNif())
                        .photo(user.getPhoto())
                        .active(user.isActive())
                        .build()
                : null;
    }

    /**
     * Method to map an UserDTO {@link UserDTO} to an User {@link User}
     *
     * @param userDTO the data source
     * @return the one User object {@link User}
     */
    public User mapUserDTOToUser(final UserDTO userDTO) {
        return Objects.nonNull(userDTO) ?
                new User.UserBuilder()
                        .id(userDTO.getId())
                        .firstName(userDTO.getFirstName())
                        .lastName(userDTO.getLastName())
                        .age(userDTO.getAge())
                        .nif(userDTO.getNif())
                        .photo(userDTO.getPhoto())
                        .active(userDTO.isActive())
                        .build()
                : null;
    }
}
