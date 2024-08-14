package com.nishana.restaurantpos.serviceImpl;

import com.nishana.restaurantpos.dto.PaymentMethodDTO;
import com.nishana.restaurantpos.exception.DatabaseException;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.mapper.PaymentMethodMapper;
import com.nishana.restaurantpos.model.PaymentMethod;
import com.nishana.restaurantpos.repository.PaymentMethodRepository;
import com.nishana.restaurantpos.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;


    @Override
    public List<PaymentMethodDTO> getAllPaymentMethod() {
        List<PaymentMethod> paymentMethod = paymentMethodRepository.findAll();
        return paymentMethod.stream()
                .map(paymentMethodMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentMethodDTO createPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(paymentMethodDTO);
        paymentMethod = paymentMethodRepository.save(paymentMethod);
        return paymentMethodMapper.toDTO(paymentMethod);
    }

    @Override
    public PaymentMethodDTO getPaymentMethodById(Long Id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(Id)
                .orElseThrow(()->new ResourceNotFoundException("Method Not Found : "+Id));
        return paymentMethodMapper.toDTO(paymentMethod);
    }

    @Override
    public void deleteById(Long Id) {
        try {
            PaymentMethod paymentMethod = paymentMethodRepository.findById(Id)
                    .orElseThrow(()->new  ResourceNotFoundException("Method Not Found "));
            paymentMethodRepository.deleteById(Id);
        }catch (DatabaseException ex){
            throw new DatabaseException("An error occurred while trying to delete the category with id: " + Id, ex);
        }catch (Exception ex) {
            // Handle any other unexpected exceptions
            throw new RuntimeException("An unexpected error occurred", ex);
        }
    }

}
