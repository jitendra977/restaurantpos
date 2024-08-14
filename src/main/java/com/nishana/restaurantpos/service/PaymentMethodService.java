package com.nishana.restaurantpos.service;

import com.nishana.restaurantpos.dto.PaymentMethodDTO;
import com.nishana.restaurantpos.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
     List<PaymentMethodDTO> getAllPaymentMethod();
     PaymentMethodDTO createPaymentMethod(PaymentMethodDTO paymentMethodDTO);
     PaymentMethodDTO getPaymentMethodById(Long Id);
     void deleteById(Long Id);
}
