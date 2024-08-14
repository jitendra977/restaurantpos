package com.nishana.restaurantpos.controller;

import com.nishana.restaurantpos.dto.ApiResponse;
import com.nishana.restaurantpos.dto.PaymentMethodDTO;
import com.nishana.restaurantpos.exception.DatabaseException;
import com.nishana.restaurantpos.exception.ResourceNotFoundException;
import com.nishana.restaurantpos.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-method")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<List<PaymentMethodDTO>> getAllPaymentMethod(){
        List<PaymentMethodDTO> paymentMethodDTOS = paymentMethodService.getAllPaymentMethod();
        return ResponseEntity.ok(paymentMethodDTOS);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<ApiResponse<PaymentMethodDTO>> getPaymentMethodById(@PathVariable Long Id){
        PaymentMethodDTO paymentMethodDTO = paymentMethodService.getPaymentMethodById(Id);
        ApiResponse<PaymentMethodDTO> response = new ApiResponse<>("Payment method with id "+ Id,paymentMethodDTO);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<PaymentMethodDTO>> addPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO){
        PaymentMethodDTO createdpaymentMethodDTO = paymentMethodService.createPaymentMethod(paymentMethodDTO);
        ApiResponse<PaymentMethodDTO> response = new ApiResponse<>("method Created successfully ",createdpaymentMethodDTO);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deletePaymentMethod(@PathVariable Long Id){
        try {
            paymentMethodService.deleteById(Id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (DatabaseException ex) {
            // Handle database errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        } catch (Exception ex) {
            // Handle any other unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
