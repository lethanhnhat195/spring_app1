package com.ijv.internjava.service.impl;

import com.ijv.internjava.mapper.ServiceImageMapper;
import com.ijv.internjava.mapper.ServiceMapper;
import com.ijv.internjava.model.dto.ServiceDto;
import com.ijv.internjava.model.dto.ServiceImageDto;
import com.ijv.internjava.model.entity.ServicesImage;
import com.ijv.internjava.repository.ServiceImageRepository;
import com.ijv.internjava.repository.ServiceRepository;
import com.ijv.internjava.service.ServiceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository;
    private ServiceImageRepository serviceImageRepository;

    @Override
    public List<ServiceDto> findAll() {
        return serviceRepository.findAll().stream()
                .map(service -> ServiceMapper.getInstance().toDto(service))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDto detail(Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Service with id [%d] was not found!", id)));
        return ServiceMapper.getInstance().toDto(service);
    }

    @Override
    public ServiceDto create(ServiceDto serviceDto) {
        Service newService = new Service();
        newService.setName(serviceDto.getName());
        newService.setServiceTime(serviceDto.getServiceTime());
        newService.setPrice(serviceDto.getPrice());
        newService.setDescription(serviceDto.getDescription());
        Set<ServicesImage> serviceImages = new HashSet<>();
        serviceRepository.save(newService);
        for (ServiceImageDto serviceImageDto : serviceDto.getServiceImageDtos()) {
            ServicesImage newServicesImage = new ServicesImage();
            newServicesImage.setId(newServicesImage.getId());
            newServicesImage.setService(newService);
            newServicesImage.setNameFile(serviceImageDto.getFileName());
            serviceImages.add(newServicesImage);
            serviceImageRepository.save(newServicesImage);
        }
        newService.setServicesImages(serviceImages);
        return ServiceMapper.getInstance().toDto(serviceRepository.save(newService));
    }

    @Override
    public ServiceDto edit(ServiceDto serviceDto, Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Service with id [%d] was not found!", id)));
        service.setName(serviceDto.getName());
        service.setPrice(serviceDto.getPrice());
        service.setServiceTime(serviceDto.getServiceTime());
        service.setDescription(serviceDto.getDescription());
        for (ServiceImageDto serviceImageDto : serviceDto.getServiceImageDtos()) {
            ServicesImage servicesImage = ServiceImageMapper.getInstance().toEntity(serviceImageDto);
            servicesImage.setService(service);
            serviceImageRepository.save(servicesImage);
        }
        return ServiceMapper.getInstance().toDto(serviceRepository.save(service));
    }

    @Override
    public void delete(long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Service with id [%d] was not found!", id)));
        for (ServicesImage serviceImage : service.getServicesImages()) {
            serviceImageRepository.deleteById(serviceImage.getId());
        }
        serviceRepository.delete(service);
    }
}
