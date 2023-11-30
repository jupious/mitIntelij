package com.kwak.remote.service;

import com.kwak.remote.dto.ManagerDTO;
import com.kwak.remote.entity.Manager;
import com.kwak.remote.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService{

    private ManagerRepository managerRepository;
    @Override
    public void insert(ManagerDTO managerDTO) {
        managerRepository.save(this.dtoToEntity(managerDTO));
    }

    @Override
    public List<ManagerDTO> getData() {
        List<Manager> result =  managerRepository.findAll();
        List<ManagerDTO> trans = new ArrayList<>();
        result.forEach(x ->{
            trans.add(entityToDTO(x));
        });
        return trans;
    }
}
