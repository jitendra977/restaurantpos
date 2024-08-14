package com.nishana.restaurantpos.mapper;

import com.nishana.restaurantpos.dto.PaymentMethodDTO;
import com.nishana.restaurantpos.model.PaymentMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PaymentMethodMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PaymentMethodDTO toDTO(PaymentMethod paymentMethod){
        return modelMapper.map(paymentMethod,PaymentMethodDTO.class);
    }

    public PaymentMethod toEntity(PaymentMethodDTO paymentMethodDTO){
        return modelMapper.map(paymentMethodDTO,PaymentMethod.class);
    }
}
