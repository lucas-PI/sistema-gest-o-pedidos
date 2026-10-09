package com.masteraluminio.gerenciadopedidos.services;

import com.masteraluminio.gerenciadopedidos.dtos.response.UserDTO;
import com.masteraluminio.gerenciadopedidos.model.User;
import com.masteraluminio.gerenciadopedidos.repositories.UserRepository;
import com.masteraluminio.gerenciadopedidos.services.excptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO insert(UserDTO request){
        User entity = new User(request);
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }

    public UserDTO findById(Long id){
        User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserDTO(entity);
    }


}
