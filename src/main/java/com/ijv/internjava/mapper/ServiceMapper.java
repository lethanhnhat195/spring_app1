package com.ijv.internjava.mapper;

import com.ijv.internjava.model.dto.ServiceDto;
import com.ijv.internjava.model.entity.Service;

import java.util.stream.Collectors;

public class ServiceMapper {
    private static ServiceMapper INSTANCE;

    public static ServiceMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ServiceMapper();
        }
        return INSTANCE;
    }

    public Service toEntity(ServiceDto serviceDto) {
        Service service = new Service();
        service.setId(serviceDto.getId());
        service.setName(serviceDto.getName());
        service.setServiceTime(serviceDto.getServiceTime());
        service.setPrice(serviceDto.getPrice());
        service.setDescription(serviceDto.getDescription());
        service.setServicesImages(serviceDto.getServiceImageDtos().stream()
                .map(serviceImageDto -> ServiceImageMapper.getInstance().toEntity(serviceImageDto))
                .collect(Collectors.toSet()));
        return service;
    }

    public ServiceDto toDto(Service service) {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setId(service.getId());
        serviceDto.setName(service.getName());
        serviceDto.setServiceTime(service.getServiceTime());
        serviceDto.setPrice(service.getPrice());
        serviceDto.setDescription(service.getDescription());
        serviceDto.setServiceImageDtos(service.getServicesImages().stream()
                .map(servicesImage -> ServiceImageMapper.getInstance().toDto(servicesImage))
                .collect(Collectors.toSet()));
        return serviceDto;
    }
}