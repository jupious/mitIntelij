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
    public boolean insert(ManagerDTO managerDTO) {
        boolean flag = false;
        if(managerRepository.findById(managerDTO.getPno()).isEmpty()){
            managerRepository.save(this.dtoToEntity(managerDTO));
            flag = true;
        }
        return flag;
    }

    @Override
    public List<ManagerDTO> getDataList() {
        List<Manager> result =  managerRepository.findAll();
        List<ManagerDTO> trans = new ArrayList<>();
        result.forEach(x ->{
            trans.add(entityToDTO(x));
        });
        return trans;
    }

    @Override
    public boolean dupCheck(Long pno) {
        //중복되면(존재하면)True, 아니면 False
        return managerRepository.findById(pno).isPresent();
    }


}
