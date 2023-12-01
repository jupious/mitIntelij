package com.kwak.remote.service;

import com.kwak.remote.dto.ManagerDTO;
import com.kwak.remote.entity.Manager;

import java.util.List;


public interface ManagerService {

    //등록
    boolean insert(ManagerDTO managerDTO);

    //확인
    List<ManagerDTO> getDataList();

    //중복확인용
    boolean dupCheck(Long pno);
    default Manager dtoToEntity(ManagerDTO managerDTO){
        //java8부터 default를 통해 인터페이스에서 직접 구현이 가능함
        return Manager.builder()
                .pno(managerDTO.getPno())
                .part(managerDTO.getPart())
                .name(managerDTO.getName())
                .tel(managerDTO.getTel())
                .build();

    }

    default ManagerDTO entityToDTO(Manager entity){
        return ManagerDTO.builder()
                .pno(entity.getPno())
                .part(entity.getPart())
                .name(entity.getName())
                .tel(entity.getTel())
                .build();
    }
}
