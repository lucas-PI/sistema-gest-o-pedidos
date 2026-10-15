package com.masteraluminio.gerenciadopedidos.services;

import com.masteraluminio.gerenciadopedidos.dtos.response.OrderDTO;
import com.masteraluminio.gerenciadopedidos.dtos.response.UserDTO;
import com.masteraluminio.gerenciadopedidos.model.User;
import com.masteraluminio.gerenciadopedidos.repositories.UserRepository;
import com.masteraluminio.gerenciadopedidos.services.excptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO insert(UserDTO request){
        User entity = new User(request);
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }
    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserDTO(entity);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public Page<OrderDTO> findOrdersByUserId(Long id,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        List<OrderDTO> orderDTOS = findById(id).getOrderDTOS();

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize() , orderDTOS.size());

        List<OrderDTO> pageContent = orderDTOS.subList(start,end);

        Page<OrderDTO> pageOrderDTOS = new PageImpl<>(
                pageContent,
                pageable,
                orderDTOS.size()
        );
        return pageOrderDTOS;
    }

}
