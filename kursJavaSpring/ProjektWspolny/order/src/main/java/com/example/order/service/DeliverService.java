package com.example.order.service;

import com.example.order.entity.DeliverDTO;
import com.example.order.repository.DeliverRepository;
import com.example.order.translators.DeliverToDeliverDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliverService
{
    private final DeliverRepository deliverRepository;
    private final DeliverToDeliverDTO deliverToDeliverDTO;

    public List<DeliverDTO> getAllDeliver()
    {
        return deliverRepository.findAll().stream().map(deliverToDeliverDTO::toDeliverDTO).collect(Collectors.toList());
    }
}
