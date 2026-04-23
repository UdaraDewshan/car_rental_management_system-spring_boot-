package edu.icet.service;

import edu.icet.model.dto.UserDTO;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    final ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> customerList = new ArrayList<>();

        for (User user : allUsers) {
            if (!"ADMIN".equals(user.getRole())) {
                customerList.add(modelMapper.map(user, UserDTO.class));
            }
        }
        return customerList;
    }
}
