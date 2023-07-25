package com.ijv.internjava.mapper;

import com.ijv.internjava.model.dto.ServiceImageDto;
import com.ijv.internjava.model.entity.ServicesImage;

public class ServiceImageMapper {
    private static ServiceImageMapper INSTANCE;

    public static ServiceImageMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ServiceImageMapper();
        }
        return INSTANCE;
    }

    public ServicesImage toEntity(ServiceImageDto serviceImageDto) {
        ServicesImage servicesImage = new ServicesImage();
        servicesImage.setId(serviceImageDto.getId());
        servicesImage.setNameFile(serviceImageDto.getFileName());
        return servicesImage;
    }

    public ServiceImageDto toDto(ServicesImage serviceImage) {
        ServiceImageDto serviceImageDto = new ServiceImageDto();
        serviceImageDto.setId(serviceImage.getId());
        serviceImageDto.setFileName(serviceImage.getNameFile());
        return serviceImageDto;
    }
}