package com.robatist.backend.service.mapper;

import com.robatist.backend.domain.Explication;
import com.robatist.backend.domain.Session;
import com.robatist.backend.domain.StudyArea;
import com.robatist.backend.domain.user.User;
import com.robatist.backend.service.model.ExplicationDTO;
import com.robatist.backend.service.model.SessionDTO;
import com.robatist.backend.service.model.StudyAreaDTO;
import com.robatist.backend.service.model.user.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SessionMapper {

    /**
     * Method to map a list of Sessions {@link Session} to a list of SessionsDTO {@link SessionDTO}
     *
     * @param sessionList the data source
     * @return the one list {@link List} of SessionsDTO {@link SessionDTO}
     */
    public List<SessionDTO> mapSessionListToSessionDTOList(final List<Session> sessionList) {
        return Objects.nonNull(sessionList) ?
                sessionList.stream().map(this::mapSessionToSessionDTO).collect(Collectors.toList())
                : null;
    }

    /**
     * Method to map a Session {@link Session} to a SessionDTO {@link SessionDTO}
     *
     * @param session the data source
     * @return the one SessionDTO object {@link SessionDTO}
     */
    public SessionDTO mapSessionToSessionDTO(final Session session) {
        return Objects.nonNull(session) ?
                new SessionDTO.SessionDTOBuilder()
                        .id(session.getId())
                        .designation(session.getDesignation())
                        .sessionDate(session.getSessionDate())
                        .student(mapUserToUserDTO(session.getStudent()))
                        .explication(mapExplicationToExplicationDTO(session.getExplication()))
                        .build()
                : null;
    }

    /**
     * Method to map a SessionDTO {@link SessionDTO} to a Session {@link Session}
     *
     * @param sessionDTO the data source
     * @return the one Session object {@link Session}
     */
    public Session mapSessionDTOToSession(final SessionDTO sessionDTO) {
        return Objects.nonNull(sessionDTO) ?
                new Session.SessionBuilder()
                        .id(sessionDTO.getId())
                        .designation(sessionDTO.getDesignation())
                        .sessionDate(sessionDTO.getSessionDate())
                        .student(mapUserDTOToUser(sessionDTO.getStudent()))
                        .explication(mapExplicationDTOToExplication(sessionDTO.getExplication()))
                        .build()
                : null;
    }

    /**
     * Method to map an Explication {@link Explication} to an ExplicationDTO {@link ExplicationDTO}
     *
     * @param explication the data source
     * @return the one ExplicationDTO object {@link ExplicationDTO}
     */
    public ExplicationDTO mapExplicationToExplicationDTO(final Explication explication) {
        return Objects.nonNull(explication) ?
                new ExplicationDTO.ExplicationDTOBuilder()
                        .id(explication.getId())
                        .designation(explication.getDesignation())
                        .description(explication.getDescription())
                        .studyArea(mapStudyAreaToStudyAreaDTO(explication.getStudyArea()))
                        .isRemote(explication.isRemote())
                        .teacher(mapUserToUserDTO(explication.getTeacher()))
                        .active(explication.isActive())
                        .build()
                : null;
    }

    /**
     * Method to map a ExplicationDTO {@link ExplicationDTO} to a Explication {@link Explication}
     *
     * @param explicationDTO the data source
     * @return the one Explication object {@link Explication}
     */
    public Explication mapExplicationDTOToExplication(final ExplicationDTO explicationDTO) {
        return Objects.nonNull(explicationDTO) ?
                new Explication.ExplicationBuilder()
                        .id(explicationDTO.getId())
                        .designation(explicationDTO.getDesignation())
                        .description(explicationDTO.getDescription())
                        .studyArea(mapStudyAreaDTOToStudyArea(explicationDTO.getStudyArea()))
                        .isRemote(explicationDTO.isRemote())
                        .teacher(mapUserDTOToUser(explicationDTO.getTeacher()))
                        .active(explicationDTO.isActive())
                        .build()
                : null;
    }

    /**
     * Method to map a StudyArea {@link StudyArea} to a StudyAreaDTO {@link StudyAreaDTO}
     *
     * @param studyArea the data source
     * @return the one StudyAreaDTO object {@link StudyAreaDTO}
     */
    public StudyAreaDTO mapStudyAreaToStudyAreaDTO(final StudyArea studyArea) {
        return Objects.nonNull(studyArea) ?
                new StudyAreaDTO.StudyAreaDTOBuilder()
                        .id(studyArea.getId())
                        .designation(studyArea.getDesignation())
                        .description(studyArea.getDescription())
                        .build()
                : null;
    }

    /**
     * Method to map a StudyAreaDTO {@link StudyAreaDTO} to a StudyArea {@link StudyArea}
     *
     * @param studyAreaDTO the data source
     * @return the one StudyArea object {@link StudyArea}
     */
    public StudyArea mapStudyAreaDTOToStudyArea(final StudyAreaDTO studyAreaDTO) {
        return Objects.nonNull(studyAreaDTO) ?
                new StudyArea.StudyAreaBuilder()
                        .id(studyAreaDTO.getId())
                        .designation(studyAreaDTO.getDesignation())
                        .description(studyAreaDTO.getDescription())
                        .build()
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
