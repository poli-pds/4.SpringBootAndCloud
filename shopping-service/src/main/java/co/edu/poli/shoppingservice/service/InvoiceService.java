package co.edu.poli.shoppingservice.service;

import co.edu.poli.shoppingservice.persistence.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    void save(Invoice invoice);
    void delete(Invoice invoice);
    List<Invoice> findAll();
    Invoice findById(Long id);
    Invoice findByNumberInvoice(String numberInvoice);

}
