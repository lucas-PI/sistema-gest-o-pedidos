package com.masteraluminio.gerenciadopedidos.services;

import com.masteraluminio.gerenciadopedidos.dtos.response.OrderDTO;
import com.masteraluminio.gerenciadopedidos.model.Order;
import com.masteraluminio.gerenciadopedidos.model.enums.ProgressStatus;
import com.masteraluminio.gerenciadopedidos.model.enums.StatusPriority;
import com.masteraluminio.gerenciadopedidos.repositories.OrderRepository;
import com.masteraluminio.gerenciadopedidos.repositories.UserRepository;
import com.masteraluminio.gerenciadopedidos.services.excptions.ResourceNotFoundException;
import jakarta.transaction.TransactionScoped;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    public Page<OrderDTO> findAll(int page, int size ){
        Pageable pageable = PageRequest.of(page,size);
        Page<OrderDTO> page1 =  orderRepository.findAll(pageable).map(o -> new OrderDTO(o));
        return page1;
    }

    @Transactional(readOnly = true)
    public Page<OrderDTO> findAllByProgressStatusNoFinish(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<OrderDTO> page1 =  orderRepository.findAllByProgressStatusIn(List.of(ProgressStatus.PENDING,ProgressStatus.IN_PROGRESS)
                ,pageable).map(OrderDTO::new);
        return page1;
    }

    @Transactional
    public OrderDTO insert(OrderDTO request){
        Order entity = new Order();
        entity.setDescription(request.getDescription());
        entity.setObservation(request.getObservation());
        entity.setStatusPriority(request.getStatusPriority());
        entity.setProgressStatus(ProgressStatus.valueOf(request.getProgressStatus()));
        entity.setQuantity(request.getQuantity());
        entity.setUser(userRepository.findById(request.getIdUser()).get());
        entity = orderRepository.save(entity);

        return new OrderDTO(entity);
    }

    @Transactional
    public OrderDTO update(Long id, OrderDTO request){
        Order entity = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        Optional.ofNullable(request.getDescription()).ifPresent(entity::setDescription);
        Optional.ofNullable(request.getObservation()).ifPresent(entity::setObservation);
        Optional.ofNullable(request.getProgressStatus()).ifPresent(e -> entity.setProgressStatus(ProgressStatus.valueOf(e)));
        Optional.ofNullable(request.getStatusPriority()).ifPresent(sp -> entity.setStatusPriority(sp));
        Optional.ofNullable(request.getQuantity()).ifPresent(quant -> entity.setQuantity(quant));
        entity.setUpdatedAt(OffsetDateTime.now());


        return new OrderDTO(orderRepository.save(entity));
    }

    @Transactional
    public void deleteById(Long id){
        orderRepository.delete(orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }
}
